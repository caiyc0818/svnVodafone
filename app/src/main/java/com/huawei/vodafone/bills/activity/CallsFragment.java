package com.huawei.vodafone.bills.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.Quota;
import com.huawei.vodafone.bean.UsageListInfo;
import com.huawei.vodafone.bean.UsageVolumeList;
import com.huawei.vodafone.bean.UserInfo;
import com.huawei.vodafone.bean.Volume;
import com.huawei.vodafone.net.IRequest;
import com.huawei.vodafone.net.RequestJSon;
import com.huawei.vodafone.net.RequestListener;
import com.huawei.vodafone.net.URLs;
import com.huawei.vodafone.ui.fragment.BaseFragment;
import com.huawei.vodafone.util.DateUtil;
import com.huawei.vodafone.util.JsonUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanl
 *
 * @create 2016年7月23日 下午6:02:22
 */
public class CallsFragment extends BaseFragment implements RequestListener {
	private static final String TAG = "1";
	private Context mContext;
	private String usageType;
	private List<UsageListInfo> usageListInfo = new ArrayList<UsageListInfo>();
	private List<UsageVolumeList> usageVolumeLists;
	XAxis xAxis;
	private TextView tv_top1, tv_top2, tv_top3, tv_bottom1, tv_bottom2,
			tv_bottom3;
	JSONObject obj2;
	JSONObject obj3;
	BarChart chart;
	BarChart chart1;
	private Volume volume;
	private Quota quota;
	private ProgressBar progressBar1;
	private ProgressBar progressBar2;
	private TextView title1;
	private TextView title2;
	private TextView text1;
	private TextView text2;
	private int currentDate;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_calls, null);
		initView(view);
		IRequest.get(TAG, URLs.USAGE, RequestJSon.Usage(), this);
		return view;
	}

	private void initView(View view) {
		volume = new Volume();
		quota = new Quota();
		usageVolumeLists = new ArrayList<UsageVolumeList>();
		tv_top1 = (TextView) view.findViewById(R.id.tv_top1);
		tv_top2 = (TextView) view.findViewById(R.id.tv_top2);
		tv_top3 = (TextView) view.findViewById(R.id.tv_top3);
		tv_bottom1 = (TextView) view.findViewById(R.id.tv_bottom1);
		tv_bottom2 = (TextView) view.findViewById(R.id.tv_bottom2);
		tv_bottom3 = (TextView) view.findViewById(R.id.tv_bottom3);
		title1 = (TextView) view.findViewById(R.id.title_call);
		title2 = (TextView) view.findViewById(R.id.title_call2);
		text1 = (TextView) view.findViewById(R.id.text1);
		text2 = (TextView) view.findViewById(R.id.text2);
		chart = (BarChart) view.findViewById(R.id.chart);
		chart1 = (BarChart) view.findViewById(R.id.chart1);
		progressBar1 = (ProgressBar) view.findViewById(R.id.progress1);
		progressBar2 = (ProgressBar) view.findViewById(R.id.progress2);
		// 设置call
		setProgress();
		currentDate = Integer.parseInt(DateUtil.getCurrentTimeStr().substring(
				6, 8));

	}

	private void setProgress() {
		float allData = Float.parseFloat(UserInfo.getDiyunitall().replace(",",
				""));
		float leftData = Float.parseFloat(UserInfo.getDiyunitleft().replace(
				",", ""));
		float allAddData = Float.parseFloat(UserInfo.getAllUnit().replace(",",
				""));
		float leftAddData = Float.parseFloat(UserInfo.getLeftUnit().replace(
				",", ""));

		int pro = (int) ((leftData / allData) * 100);
		int pro2 = (int) (((leftAddData - leftData) / (allAddData - allData)) * 100);
		progressBar1.setProgress(pro);
		if (pro == 0) {
			text1.setText("");
		} else {
			text1.setText(pro + "%");
		}
		progressBar2.setProgress(pro2);
		if (pro2 == 0) {
			text2.setText("");
		} else {
			text2.setText(pro2 + "%");
		}
		title1.setText("In plan-" + leftData + "Min/" + allData + "Min");
		title2.setText("Add on-" + (leftAddData - leftData) + "Min/"
				+ (allAddData - allData) + "Min");
	}

	private void getBar() {
		BarChart3s(chart, usageType);
		BarChart3s(chart1, usageType);
		// BarData data = new BarData(getXAxisValues(), getDataSet());
		//
		// BarData data1 = new BarData(getXAxisValues1(), getDataSet1());
		//
		// // 设置数据
		// chart.setData(data);
		// chart1.setData(data1);
	}

	private void BarChart3s(BarChart chart, String usageType) {
		this.usageType = usageType;
		// 数据描述
		chart.setDescription("");

		// 背景
		chart.setBackgroundColor(0xffffffff);
		// 定义数据描述得位置
		// chart.setDescriptionPosition(2,100);
		// 设置描述文字的颜色
		// chart.setDescriptionColor(0xffededed);
		// 动画
		chart.animateY(1000);
		// 设置无边框
		chart.setDrawBorders(false);
		// 设置是否可以触摸
		chart.setTouchEnabled(false);
		// 是否可以拖拽
		chart.setDragEnabled(false);
		// 是否可以缩放
		chart.setScaleEnabled(false);
		// 设置网格背景
		chart.setGridBackgroundColor(0xffffffff);
		// 设置边线宽度
		chart.setBorderWidth(0);
		// 设置边线颜色
		chart.setBorderColor(0xffffffff);
		// 集双指缩放
		chart.setPinchZoom(false);
		// 隐藏右边的坐标轴
		chart.getAxisRight().setEnabled(false);
		// 隐藏左边的左边轴
		chart.getAxisLeft().setEnabled(false);
		// chart.getXAxis().setDrawGridLines(true);
		// //隐藏左边坐标轴横网格线
		// chart.getAxisLeft().setDrawGridLines(false);
		// //隐藏右边坐标轴横网格线
		// chart.getAxisRight().setDrawGridLines(false);

		Legend mLegend = chart.getLegend(); // 设置比例图标示
		// 设置窗体样式
		mLegend.setForm(Legend.LegendForm.SQUARE);
		// 设置图标位置
		mLegend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);
		// 字体
		mLegend.setFormSize(4f);
		// 是否显示注释
		mLegend.setEnabled(false);
		// 字体颜色
		// mLegend.setTextColor(Color.parseColor("#7e7e7e"));

		// 设置X轴位置
		xAxis = chart.getXAxis();
		xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
		// 前面xAxis.setEnabled(false);则下面绘制的Grid不会有"竖的线"（与X轴有关）
		// 上面第一行代码设置了false,所以下面第一行即使设置为true也不会绘制AxisLine
		// 设置轴线得颜色
		xAxis.setAxisLineColor(0xffb0b0b0);
		xAxis.setDrawAxisLine(true);
		xAxis.setDrawGridLines(false);
		xAxis.setSpaceBetweenLabels(-2);
		xAxis.setTextColor(0xff969696);
		xAxis.setTextSize(12f);
		// 设置Y轴
		YAxis leftAxis = chart.getAxisLeft();
		// Y轴颜色
		leftAxis.setAxisLineColor(0xffffffff);

		leftAxis.setLabelCount(3, false);
		// Y轴参照线颜色
		leftAxis.setGridColor(0xffb0b0b0);
		leftAxis.setDrawGridLines(true);
		// 参照线长度
		leftAxis.setAxisLineWidth(5f);
		// 顶部居最大值站距离占比
		leftAxis.setSpaceTop(-5f);

		chart.invalidate();
	}

	public List<BarDataSet> getDataSet() {
		ArrayList<BarDataSet> dataSets = null;
		ArrayList<Integer> num2 = new ArrayList<>();
		num2.add(63);
		num2.add(75);
		num2.add(43);
		num2.add(50);
		num2.add(72);
		num2.add(40);
		num2.add(60);
		num2.add(43);
		num2.add(43);
		num2.add(86);
		num2.add(72);
		num2.add(50);
		num2.add(75);
		num2.add(95);
		num2.add(43);
		num2.add(49);
		num2.add(86);
		num2.add(43);
		num2.add(43);
		num2.add(86);
		num2.add(72);
		num2.add(65);
		num2.add(80);
		num2.add(95);
		num2.add(50);
		num2.add(43);
		num2.add(86);
		num2.add(43);
		num2.add(43);
		num2.add(86);
		num2.add(72);
		num2.add(69);
		num2.add(92);
		num2.add(82);
		num2.add(43);
		num2.add(30);
		num2.add(86);
		num2.add(72);
		num2.add(92);
		num2.add(95);
		num2.add(43);
		num2.add(86);
		num2.add(72);
		num2.add(92);
		dataSets = new ArrayList<BarDataSet>();
		ArrayList<BarEntry> valueSet1 = new ArrayList<BarEntry>();
		if (currentDate <= 8) {
			if (currentDate >= 7) {
				for (int i = 1; i <= currentDate + 1; i++) {
					if (i == 8) {
						valueSet1.add(new BarEntry(0, i));
					} else {
						valueSet1.add(new BarEntry(num2.get(i), i));
					}
				}
			} else {
				for (int i = 1; i <= currentDate; i++) {
					valueSet1.add(new BarEntry(num2.get(i), i));
				}
			}

		} else if (currentDate > 8 && currentDate <= 16) {
			if (currentDate >= 14) {
				for (int i = 1; i <= currentDate + 2; i++) {
					if (i == 8) {
						valueSet1.add(new BarEntry(0, i));
					} else if (i == 16) {
						valueSet1.add(new BarEntry(0, i));
					} else {
						valueSet1.add(new BarEntry(num2.get(i), i));
					}
				}
			} else {
				for (int i = 1; i <= currentDate + 1; i++) {
					if (i == 8) {
						valueSet1.add(new BarEntry(0, i));
					} else {
						valueSet1.add(new BarEntry(num2.get(i), i));
					}
				}
			}
		} else if (currentDate > 16 && currentDate <= 24) {
			if (currentDate >= 21) {
				for (int i = 1; i <= currentDate + 3; i++) {
					if (i == 16) {
						valueSet1.add(new BarEntry(0, i));
					} else if (i == 8) {
						valueSet1.add(new BarEntry(0, i));
					} else if (i == 24) {
						valueSet1.add(new BarEntry(0, i));
					} else {
						valueSet1.add(new BarEntry(num2.get(i), i));
					}
				}
			} else {
				for (int i = 1; i <= currentDate + 2; i++) {
					if (i == 16) {
						valueSet1.add(new BarEntry(0, i));
					} else if (i == 8) {
						valueSet1.add(new BarEntry(0, i));
					} else {
						valueSet1.add(new BarEntry(num2.get(i), i));
					}
				}
			}
		} else if (currentDate > 24 && currentDate <= 31) {
			if (currentDate >= 28) {
				for (int i = 1; i <= currentDate + 4; i++) {
					if (i == 24) {
						valueSet1.add(new BarEntry(0, i));
					} else if (i == 16) {
						valueSet1.add(new BarEntry(0, i));
					} else if (i == 8) {
						valueSet1.add(new BarEntry(0, i));
					} else if (i == 32) {
						valueSet1.add(new BarEntry(0, i));
					} else {
						valueSet1.add(new BarEntry(num2.get(i), i));
					}
				}
			} else {
				for (int i = 1; i <= currentDate + 3; i++) {
					if (i == 24) {
						valueSet1.add(new BarEntry(0, i));
					} else if (i == 16) {
						valueSet1.add(new BarEntry(0, i));
					} else if (i == 8) {
						valueSet1.add(new BarEntry(0, i));
					} else {
						valueSet1.add(new BarEntry(num2.get(i), i));
					}
				}
			}

		}

		BarDataSet barDataSet1 = new BarDataSet(valueSet1, "目标");
		barDataSet1.setColor(Color.parseColor("#952e9c"));
		barDataSet1.setBarShadowColor(Color.parseColor("#01000000"));
		barDataSet1.setDrawValues(false);
		dataSets.add(barDataSet1);
		return dataSets;

		/*
		 * 以星期数为单位 第一种以天为单位
		 */
		// ArrayList<BarDataSet> dataSets = null;
		// ArrayList<BarEntry> valueSet1 = new ArrayList<BarEntry>();
		// ArrayList<BarEntry> valueSet2 = new ArrayList<BarEntry>();
		// ArrayList<BarEntry> valueSet3 = new ArrayList<BarEntry>();
		// ArrayList<BarEntry> valueSet4 = new ArrayList<BarEntry>();
		// ArrayList<BarEntry> valueSet5 = new ArrayList<BarEntry>();
		// ArrayList<BarEntry> valueSet6 = new ArrayList<BarEntry>();
		// ArrayList<BarEntry> valueSet7 = new ArrayList<BarEntry>();
		//
		// ArrayList<ArrayList<BarEntry>> list = new ArrayList<>();
		// list.add(valueSet1);
		// list.add(valueSet2);
		// list.add(valueSet3);
		// list.add(valueSet4);
		// list.add(valueSet5);
		// list.add(valueSet6);
		// list.add(valueSet7);
		// currentDate =
		// Integer.parseInt(DateUtil.getCurrentTimeStr().substring(6, 8));
		// int num = currentDate % 7;
		// int j = 0;
		// if (currentDate < 7) {
		// j = 0;
		// } else {
		// j = currentDate / 7;
		// }
		//
		// ArrayList<Integer> num2 = new ArrayList<>();
		// num2.add(63);
		// num2.add(80);
		// num2.add(95);
		// num2.add(43);
		// num2.add(86);
		// num2.add(72);
		// num2.add(92);
		// ArrayList<Integer> num3 = new ArrayList<>();
		// num3.add(80);
		// num3.add(95);
		// num3.add(120);
		// num3.add(86);
		// num3.add(92);
		// num3.add(43);
		// num3.add(72);
		//
		// if (j == 0) {
		// for (int i = 0; i < num; i++) {
		// list.get(i).add(new BarEntry(num2.get(j), 0));
		// }
		// } else {
		// for (int i = 0; i < j; i++) {
		// for (int k = 0; k < 7; k++) {
		// list.get(k).add(new BarEntry(num2.get(k), i));
		// }
		// }
		// if (num != 0) {
		// for (int i = 0; i < num; i++) {
		// list.get(i).add(new BarEntry(num3.get(i), j));
		// }
		// }
		//
		// }
		//
		// BarDataSet barDataSet1 = new BarDataSet(valueSet1, "目标");
		// barDataSet1.setColor(Color.parseColor("#952e9c"));
		// barDataSet1.setBarShadowColor(Color.parseColor("#01000000"));
		// barDataSet1.setDrawValues(false);
		//
		// BarDataSet barDataSet2 = new BarDataSet(valueSet2, "实际");
		// barDataSet2.setColor(Color.parseColor("#952e9c"));
		// barDataSet2.setBarShadowColor(Color.parseColor("#01000000"));
		// barDataSet2.setDrawValues(false);
		//
		// BarDataSet barDataSet3 = new BarDataSet(valueSet3, "实际");
		// barDataSet3.setColor(Color.parseColor("#952e9c"));
		// barDataSet3.setBarShadowColor(Color.parseColor("#01000000"));
		// barDataSet3.setDrawValues(false);
		//
		// BarDataSet barDataSet4 = new BarDataSet(valueSet4, "实际");
		// barDataSet4.setColor(Color.parseColor("#952e9c"));
		// barDataSet4.setBarShadowColor(Color.parseColor("#01000000"));
		// barDataSet4.setDrawValues(false);
		//
		// BarDataSet barDataSet5 = new BarDataSet(valueSet5, "实际");
		// barDataSet5.setColor(Color.parseColor("#952e9c"));
		// barDataSet5.setBarShadowColor(Color.parseColor("#01000000"));
		// barDataSet5.setDrawValues(false);
		//
		// BarDataSet barDataSet6 = new BarDataSet(valueSet6, "实际");
		// barDataSet6.setColor(Color.parseColor("#952e9c"));
		// barDataSet6.setBarShadowColor(Color.parseColor("#01000000"));
		// barDataSet6.setDrawValues(false);
		//
		// BarDataSet barDataSet7 = new BarDataSet(valueSet7, "实际");
		// barDataSet7.setColor(Color.parseColor("#952e9c"));
		// barDataSet7.setBarShadowColor(Color.parseColor("#01000000"));
		// barDataSet7.setDrawValues(false);
		//
		// dataSets = new ArrayList<BarDataSet>();
		// dataSets.add(barDataSet1);
		// dataSets.add(barDataSet2);
		// dataSets.add(barDataSet3);
		// dataSets.add(barDataSet4);
		// dataSets.add(barDataSet5);
		// dataSets.add(barDataSet6);
		// dataSets.add(barDataSet7);
		//
		// return dataSets;
	}

	public List<BarDataSet> getDataSet1(float[] data) {
		ArrayList<BarDataSet> dataSets = null;
		ArrayList<BarEntry> valueSet1 = new ArrayList<BarEntry>();
		for (int j = 0; j < 6; j++) {
			valueSet1.add(new BarEntry(data[j], j));
		}
		ArrayList<BarEntry> valueSet2 = new ArrayList<BarEntry>();

		BarDataSet barDataSet1 = new BarDataSet(valueSet1, "目标");
		barDataSet1.setBarSpacePercent(75f);
		barDataSet1.setColor(Color.parseColor("#952e9c"));
		barDataSet1.setBarShadowColor(Color.parseColor("#01000000"));
		barDataSet1.setDrawValues(false);

		dataSets = new ArrayList<BarDataSet>();
		dataSets.add(barDataSet1);

		return dataSets;
	}

	public ArrayList<String> getXAxisValues() {
		int monthDay = DateUtil.getCurrentMonthDay();
		ArrayList<String> xAxis = new ArrayList<String>();
		String newStarData = "01/"
				+ DateUtil.getCurrentTimeStr().substring(4, 6) + "/"
				+ DateUtil.getCurrentTimeStr().substring(0, 4);
		String newEndData = monthDay + "/"
				+ DateUtil.getCurrentTimeStr().substring(4, 6) + "/"
				+ DateUtil.getCurrentTimeStr().substring(0, 4);
		for (int i = 0; i < monthDay + 5; i++) {
			if (i == 3) {
				xAxis.add(newStarData);
			} else if (i == monthDay + 1) {
				xAxis.add(newEndData);
			} else {
				xAxis.add("");
			}

		}

		// xAxis.add("01/09/2016");
		// xAxis.add("");
		// xAxis.add("");
		// xAxis.add("");
		// xAxis.add("01/10/2016");
		return xAxis;
	}

	public ArrayList<String> getXAxisValues1() {
		ArrayList<String> xAxis = new ArrayList<String>();

		// if (usageVolumeLists.size() < 7) {
		// if (usageVolumeLists.size() > 0 && usageVolumeLists.size() < 7) {
		// for (int i = 0; i < usageVolumeLists.size(); i++) {
		// xAxis.add(usageVolumeLists.get(i).getStatisDate());
		// }
		// for (int j = 0; j < 7 - usageVolumeLists.size(); j++) {
		// xAxis.add("");
		// }
		// }
		// }
		xAxis.add("201609");
		xAxis.add("201608");
		xAxis.add("201607");
		xAxis.add("201606");
		xAxis.add("201605");
		xAxis.add("201604");

		return xAxis;
	}

	@Override
	public void requestSuccess(Object tag, String json) {
		if (tag == TAG) {
			if (JsonUtils.getHeadCode(json).equals("0")) {
				float[] mydata = { 250, 455, 380, 300, 500, 200 };
				try {

					JSONArray j = ((new JSONObject(json).getJSONObject("body")
							.getJSONArray("usageList")));
					JSONObject obj1 = j.getJSONObject(1);
					JSONArray j2 = obj1.getJSONArray("usageVolumeList");
					obj2 = j2.getJSONObject(0);
					obj3 = j2.getJSONObject(1);
					JSONObject obj4 = obj2.getJSONObject("volume");
					JSONObject obj5 = obj3.getJSONObject("quota");
					usageVolumeLists.addAll(JsonUtils.getArray(j2.toString(),
							UsageVolumeList.class));
					// tv_top2.setText("Mobile data used in
					// megabytes("+obj4.getString("measureUnit")+")");
					// tv_top3.setText("Total data used
					// 108("+obj4.getString("measureUnit")+")");
					// tv_bottom2.setText("Mobile data used in
					// gigabyte("+obj5.getString("measureUnit")+")");
					// tv_bottom3.setText("Total data used
					// 5.5("+obj5.getString("measureUnit")+")");

					for (int i = 0; i < j2.length(); i++) {
						mydata[i] = j2.getJSONObject(i).getJSONObject("volume")
								.optInt("measureValue");
					}
					mydata[3] = 380;
					mydata[3] = 400;
					mydata[4] = 300;
					mydata[5] = 360;
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					Log.d("____________", "erro");
					e.printStackTrace();
				}
				// 设置数据
				getBar();
				BarData data = new BarData(getXAxisValues(), getDataSet());
				chart.setData(data);
				BarData data1 = new BarData(getXAxisValues1(),
						getDataSet1(mydata));
				chart1.setData(data1);
			}
		}

	}

	@Override
	public void requestError(Object tag, VolleyError e) {
		// TODO Auto-generated method stub

	}
}
