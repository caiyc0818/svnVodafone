package com.huawei.vodafone.ui.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

public class CircleProgressView extends View {

	private static final String TAG = "CircleProgressBar";

	private int mMaxProgress = 100;

	private int mProgress = 30;

	private final int mCircleLineStrokeWidth = 8;


	// 画圆所在的距形区域
	private final RectF mRectF;

	private final Paint mPaint;

	private final Context mContext;



	public CircleProgressView(Context context, AttributeSet attrs) {
		super(context, attrs);

		mContext = context;
		mRectF = new RectF();
		mPaint = new Paint();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		int width = this.getWidth();
		int height = this.getHeight();

		if (width != height) {
			int min = Math.min(width, height);
			width = min;
			height = min;
		}

		// 设置画笔相关属性
		mPaint.setAntiAlias(true);
		mPaint.setColor(Color.rgb(0xe9, 0xe9, 0xe9));
		canvas.drawColor(Color.TRANSPARENT);
		mPaint.setStrokeCap(Paint.Cap.ROUND);
		mPaint.setStrokeWidth(mCircleLineStrokeWidth);
		mPaint.setStyle(Style.STROKE);
		// 位置
		mRectF.left = mCircleLineStrokeWidth / 2; // 左上角x
		mRectF.top = mCircleLineStrokeWidth / 2; // 左上角y
		mRectF.right = width - mCircleLineStrokeWidth / 2; // 左下角x
		mRectF.bottom = height - mCircleLineStrokeWidth / 2; // 右下角y

		// 绘制圆圈，进度条背景
		canvas.drawArc(mRectF, -90, 360, false, mPaint);
		mPaint.setColor(Color.parseColor("#00AFCA"));
		canvas.drawArc(mRectF, -90, ((float) mProgress / mMaxProgress) * 360, false, mPaint);

	}

	public int getMaxProgress() {
		return mMaxProgress;
	}

	public void setMaxProgress(int maxProgress) {
		this.mMaxProgress = maxProgress;
	}

	public void setProgress(int progress) {
		this.mProgress = progress;
		this.invalidate();
	}

	public void setProgressNotInUiThread(int progress) {
		this.mProgress = progress;
		this.postInvalidate();
	}

}
