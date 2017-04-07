package com.huawei.vodafone.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.huawei.vodafone.R;
import com.huawei.vodafone.ui.myview.ProgressTextView;

public class FilterPlansActivity extends BaseActivity implements
		OnSeekBarChangeListener, OnClickListener {

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.filter_plans);
		initSecondTitle(getString(R.string.filter_plans), false, true);
		initViews();
	}

	private SeekBar costSb;
	private ProgressTextView costTv;
	private SeekBar dataSb;
	private ProgressTextView dataTv;
	private SeekBar callSb;
	private ProgressTextView callTv;

	private static final float ratio = 1 / 4.0f;
	private static final int maxCost = 80;
	private static final int maxData = 5;
	private static final int maxCall = 4;

	/**
	 * 初始化组件
	 */
	private void initViews() {
		costSb = (SeekBar) findViewById(R.id.cost_sb);
		costTv = (ProgressTextView) findViewById(R.id.cost_tv);
		dataSb = (SeekBar) findViewById(R.id.data_sb);
		dataTv = (ProgressTextView) findViewById(R.id.data_tv);
		callSb = (SeekBar) findViewById(R.id.call_sb);
		callTv = (ProgressTextView) findViewById(R.id.call_tv);
		costTv.setmMaxProgress(maxCost);
		dataTv.setmMaxProgress(maxData);
		callTv.setmMaxProgress(maxCall);
		costSb.setOnSeekBarChangeListener(this);
		dataSb.setOnSeekBarChangeListener(this);
		callSb.setOnSeekBarChangeListener(this);
		Thread costThread = new InitThread(1);
		Thread dataThread = new InitThread(2);
		Thread callThread = new InitThread(3);
		costThread.start();
		dataThread.start();
		callThread.start();
	}

	class InitThread extends Thread {
		private int type;
		private int i = 1;

		public InitThread(int type) {
			this.type = type;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			int max;
			if (type == 1)
				max = maxCost;
			else if (type == 2)
				max = maxData;
			else
				max = maxCall;
			while (i <= max * ratio) {
				Bundle bundle = new Bundle();
				bundle.putInt("type", type);
				bundle.putInt("progress", i);
				Message msg = handler.obtainMessage();
				msg.setData(bundle);
				handler.sendMessage(msg);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				++i;
			}
		}
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			int i = msg.getData().getInt("progress");
			int type = msg.getData().getInt("type");
			switch (type) {
			case 1:
				costSb.setProgress(0);
				costTv.setProgress(0, 0 + "€");
				break;
			case 2:
				dataSb.setProgress(0);
				dataTv.setProgress(0, (0 + 3) * 100 + "MB");
				break;
			case 3:
				callSb.setProgress(0);
				callTv.setProgress(0, (0 + 1) * 100 + "Min");
				break;
			default:
				break;
			}
		};
	};

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub
		switch (seekBar.getId()) {
		case R.id.cost_sb:
			costTv.setProgress(progress, progress + "€");
			break;
		case R.id.data_sb:
			if (progress <= 0) {
				progress = 0;
				dataTv.setProgress(progress, (progress + 3) * 100 + "MB");
				dataSb.setProgress(progress);
			} else if (progress > 0 && progress <= 2) {
				progress = 2;
				dataTv.setProgress(progress, (progress + 3) * 100 + "MB");
				dataSb.setProgress(progress);
			} else if (progress > 2 && progress <= 5) {
				progress = 5;
				dataTv.setProgress(progress, (progress + 3) * 100 + "MB");
				dataSb.setProgress(progress);
			}
			break;
		case R.id.call_sb:
			if (progress <= 0) {
				progress = 0;
				callTv.setProgress(progress, (progress + 1) * 100 + "Min");
				callSb.setProgress(progress);
			} else if (progress > 0 && progress <= 2) {
				progress = 2;
				callTv.setProgress(progress, (progress + 1) * 100 + "Min");
				callSb.setProgress(progress);
			} else if (progress > 2 && progress <= 4) {
				progress = 4;
				callTv.setProgress(progress, (progress + 1) * 100 + "Min");
				callSb.setProgress(progress);
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		// int costValue = costSb.getProgress();
		// int dataValue = dataSb.getProgress();
		// int callValue = callSb.getProgress() * 10;
		// Intent intent = new Intent();
		// intent.putExtra("costValue", costValue);
		// intent.putExtra("dataValue", dataValue);
		// intent.putExtra("callValue", callValue);
		// setResult(-1, intent);

		default:
			break;
		}
	}
}
