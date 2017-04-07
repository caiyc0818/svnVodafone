package com.huawei.vodafone.bills.activity;

import com.huawei.vodafone.MyApplication;
import com.huawei.vodafone.R;
import com.huawei.vodafone.ui.myview.CustomListView;
import com.huawei.vodafone.ui.myview.CustomListView.OnLoadListener;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author kanl
 *
 * @create 2016年7月23日 下午6:02:22
 */
public class ChargeableFragment extends Fragment{
	private CustomListView myListView;
	// private TextView tv_loadmore;
	private ChargeableAdapter adapter;
	private int num = 10;
	private static final String TAG = "1";

	private static final int LOAD_DATA_FINISH = 10;

	private static final int REFRESH_DATA_FINISH = 11;

	private int count = 10;
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case REFRESH_DATA_FINISH:

				if (adapter != null) {
					adapter.notifyDataSetChanged();
				}
				myListView.onRefreshComplete(); // 下拉刷新完成
				break;
			case LOAD_DATA_FINISH:
				if (adapter != null) {
					num += 10;
					adapter.notifyDataSetChanged();
				}
				myListView.onLoadComplete(); // 加载更多完成
				break;
			default:
				break;
			}
		};
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_chargeable, null);
		initView(view);
		return view;
	}

	private void initView(View view) {
		myListView = (CustomListView) view.findViewById(R.id.listview);
		myListView.setFocusable(false);
		adapter = new ChargeableAdapter(getActivity(), num);
		myListView.setAdapter(adapter);
		myListView.setonLoadListener(new OnLoadListener() {

			@Override
			public void onLoad() {
				// TODO 加载更多
				loadData(1);
			}
		});
	}
	
	public void loadData(final int type){
		new Thread(){
			@Override
			public void run() {
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(type==0){	//下拉刷新
//					Collections.reverse(mList);	//逆序
					handler.sendEmptyMessage(REFRESH_DATA_FINISH);
				}else if(type==1){
					handler.sendEmptyMessage(LOAD_DATA_FINISH);
				}
				
			}
		}.start();
	}

	class ChargeableAdapter extends BaseAdapter {
		private Context mContext;

		public ChargeableAdapter(Context mContext, int num) {
			this.mContext = mContext;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return num;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = LayoutInflater.from(mContext).inflate(R.layout.itemised_detail_item, parent, false);
				int width = MyApplication.screenWidth;
				int height = MyApplication.screenHeight;
				int lin_height = (int) (76 / 1136.0 * height);
				int lin_paddind_top = (int) (16 / 1136.0 * height);
				int lin_paddind_left_first = (int) (20 / 640.0 * width);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			return convertView;
		}

		private class ViewHolder {

		}
	}
}
