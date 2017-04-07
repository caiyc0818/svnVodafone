package com.huawei.vodafone.bills.activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.VolleyError;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.huawei.vodafone.bean.UsageListInfo;
import com.huawei.vodafone.bean.UsageVolumeList;
import com.huawei.vodafone.net.IRequest;
import com.huawei.vodafone.net.RequestJSon;
import com.huawei.vodafone.net.RequestListener;
import com.huawei.vodafone.net.URLs;
import com.huawei.vodafone.util.JsonUtils;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;

public class BarChart3s implements RequestListener{
	private static final String TAG = "1";
	private Context mContext;
	private String usageType;
	private List<UsageListInfo> usageListInfo=new ArrayList<UsageListInfo>();
	private List<UsageVolumeList> usageVolumeLists =new ArrayList<UsageVolumeList>();;
	XAxis xAxis ;
	public BarChart3s(BarChart chart,String usageType) {
		this.usageType=usageType;
		IRequest.get(TAG, URLs.USAGE, RequestJSon.Usage(), this);
        // 数据描述
        chart.setDescription("");
        
        //背景
        chart.setBackgroundColor(0xffffffff);
        //定义数据描述得位置
        //chart.setDescriptionPosition(2,100);
        // 设置描述文字的颜色
        // chart.setDescriptionColor(0xffededed);
        // 动画
        chart.animateY(1000);
        //设置无边框
        chart.setDrawBorders(false);
        // 设置是否可以触摸
        chart.setTouchEnabled(false);
        // 是否可以拖拽
        chart.setDragEnabled(false);
        // 是否可以缩放
        chart.setScaleEnabled(false);
        //设置网格背景
        chart.setGridBackgroundColor(0xffffffff);
        //设置边线宽度
        chart.setBorderWidth(0);
        //设置边线颜色
        chart.setBorderColor(0xffffffff);
        // 集双指缩放
        chart.setPinchZoom(false);
        // 隐藏右边的坐标轴
        chart.getAxisRight().setEnabled(false);
        // 隐藏左边的左边轴
        chart.getAxisLeft().setEnabled(true);
//        chart.getXAxis().setDrawGridLines(true);
//      //隐藏左边坐标轴横网格线
//        chart.getAxisLeft().setDrawGridLines(false);
//        //隐藏右边坐标轴横网格线
//        chart.getAxisRight().setDrawGridLines(false);

        Legend mLegend = chart.getLegend(); // 设置比例图标示
        // 设置窗体样式
        mLegend.setForm(Legend.LegendForm.SQUARE);
        //设置图标位置
        mLegend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);
        // 字体
        mLegend.setFormSize(4f);
        //是否显示注释
        mLegend.setEnabled(false);
        // 字体颜色
//        mLegend.setTextColor(Color.parseColor("#7e7e7e"));

        //设置X轴位置
        xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        // 前面xAxis.setEnabled(false);则下面绘制的Grid不会有"竖的线"（与X轴有关）
        // 上面第一行代码设置了false,所以下面第一行即使设置为true也不会绘制AxisLine
        //设置轴线得颜色
        xAxis.setAxisLineColor(0xffb0b0b0);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        xAxis.setSpaceBetweenLabels(2);
        xAxis.setTextColor(0xff969696);
        //设置Y轴
        YAxis leftAxis = chart.getAxisLeft();
        //Y轴颜色
        leftAxis.setAxisLineColor(0xffffffff);
        
        leftAxis.setLabelCount(3, false); 
        //Y轴参照线颜色
        leftAxis.setGridColor(0xffb0b0b0);
        leftAxis.setDrawGridLines(true);
        //参照线长度
        leftAxis.setAxisLineWidth(5f);
        // 顶部居最大值站距离占比
        leftAxis.setSpaceTop(-5f);

        chart.invalidate();
    }

    public List<BarDataSet> getDataSet() {
        ArrayList<BarDataSet> dataSets = null;
        ArrayList<BarEntry> valueSet1 = new ArrayList<BarEntry>();
        float [] data1={40,30,50,80,108,50,30};
        for (int j = 0; j < 4; j++) {
            valueSet1.add(new BarEntry(40,j));}
        ArrayList<BarEntry> valueSet2 = new ArrayList<BarEntry>();
        for (int j = 0; j < 4; j++) {
            valueSet2.add(new BarEntry(30,j));}
        ArrayList<BarEntry> valueSet3 = new ArrayList<BarEntry>();
        for (int j = 0; j < 4; j++) {
            valueSet3.add(new BarEntry(50,j));}
        ArrayList<BarEntry> valueSet4 = new ArrayList<BarEntry>();
        for (int j = 0; j < 4; j++) {
            valueSet4.add(new BarEntry(80,j));}
        ArrayList<BarEntry> valueSet5 = new ArrayList<BarEntry>();
        for (int j = 0; j < 4; j++) {
            valueSet5.add(new BarEntry(108,j));}
        ArrayList<BarEntry> valueSet6 = new ArrayList<BarEntry>();
        for (int j = 0; j < 4; j++) {
            valueSet6.add(new BarEntry(50,j));}
        ArrayList<BarEntry> valueSet7 = new ArrayList<BarEntry>();
        for (int j = 0; j < 4; j++) {
            valueSet7.add(new BarEntry(30,j));}


        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "目标");
        barDataSet1.setColor(Color.parseColor("#952e9c"));
        barDataSet1.setBarShadowColor(Color.parseColor("#01000000"));
        barDataSet1.setDrawValues(false);

        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "实际");
        barDataSet2.setColor(Color.parseColor("#952e9c"));
        barDataSet2.setBarShadowColor(Color.parseColor("#01000000"));
        barDataSet2.setDrawValues(false);
        
        BarDataSet barDataSet3 = new BarDataSet(valueSet3, "实际");
        barDataSet3.setColor(Color.parseColor("#952e9c"));
        barDataSet3.setBarShadowColor(Color.parseColor("#01000000"));
        barDataSet3.setDrawValues(false);
        
        BarDataSet barDataSet4 = new BarDataSet(valueSet4, "实际");
        barDataSet4.setColor(Color.parseColor("#952e9c"));
        barDataSet4.setBarShadowColor(Color.parseColor("#01000000"));
        barDataSet4.setDrawValues(false);
        
        BarDataSet barDataSet5 = new BarDataSet(valueSet5, "实际");
        barDataSet5.setColor(Color.parseColor("#952e9c"));
        barDataSet5.setBarShadowColor(Color.parseColor("#01000000"));
        barDataSet5.setDrawValues(false);
        
        BarDataSet barDataSet6 = new BarDataSet(valueSet6, "实际");
        barDataSet6.setColor(Color.parseColor("#952e9c"));
        barDataSet6.setBarShadowColor(Color.parseColor("#01000000"));
        barDataSet6.setDrawValues(false);
        
        BarDataSet barDataSet7 = new BarDataSet(valueSet7, "实际");
        barDataSet7.setColor(Color.parseColor("#952e9c"));
        barDataSet7.setBarShadowColor(Color.parseColor("#01000000"));
        barDataSet7.setDrawValues(false);

        dataSets = new ArrayList<BarDataSet>();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
        dataSets.add(barDataSet3);
        dataSets.add(barDataSet4);
        dataSets.add(barDataSet5);
        dataSets.add(barDataSet6);
        dataSets.add(barDataSet7);


        return dataSets;
    }
    
    public List<BarDataSet> getDataSet1() {
        ArrayList<BarDataSet> dataSets = null;
        float [] data={20,30,50,40,30,20,40};
        ArrayList<BarEntry> valueSet1 = new ArrayList<BarEntry>();
        for (int j = 0; j < 7; j++) {
            valueSet1.add(new BarEntry(data[j],j));}
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
        ArrayList<String> xAxis = new ArrayList<String>();
            xAxis.add("01/01/2016");
            xAxis.add("");
            xAxis.add("");
            xAxis.add("01/02/2016");
        return xAxis;
    }
    
    public ArrayList<String> getXAxisValues1() {
        ArrayList<String> xAxis = new ArrayList<String>();
            xAxis.add("May");
            xAxis.add("Jun");
            xAxis.add("Jul");
            xAxis.add("Aug");
            xAxis.add("Sep");
            xAxis.add("Oct");
            xAxis.add("Nov");
        return xAxis;
    }

	@Override
	public void requestSuccess(Object tag, String json) {
		if (tag==TAG) {
			if (JsonUtils.getHeadCode(json).equals("0")) {
				try {
					JSONObject obj1=new JSONObject(json);
					JSONObject obj2=new JSONObject("body");
					JSONArray jarray1= obj2.getJSONArray("usageList");
					JSONObject obj3=jarray1.getJSONObject(0);
					JSONObject obj4=jarray1.getJSONObject(1);
					JSONArray jarray2=obj3.getJSONArray("usageVolumeList");
					JSONArray jarray3=obj4.getJSONArray("usageVolumeList");
					usageVolumeLists.addAll(JsonUtils.getArray(jarray2.toString(), UsageVolumeList.class));
				
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void requestError(Object tag, VolleyError e) {
		// TODO Auto-generated method stub
		
	}
}
