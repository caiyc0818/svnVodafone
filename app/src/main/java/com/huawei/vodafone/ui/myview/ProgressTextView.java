package com.huawei.vodafone.ui.myview;

import com.huawei.vodafone.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.FontMetricsInt;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

public class ProgressTextView extends View {
	private static final String TAG = ProgressTextView.class.getSimpleName();

	private int mTextColor = Color.WHITE;
	private int mHeight;
	private int mWidth;
	private double mOneProgressWidth;
	private int mCurProgress = 0;
	private String mProgressText = "";
	private int mMaxProgress = 100;
	public void setmMaxProgress(int mMaxProgress) {
		this.mMaxProgress = mMaxProgress;
	}

	private Paint mPaint;
	private float mThumbOffset;
	Bitmap Bmp1;
	private int mTextSize = 36;

	public ProgressTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		if (null != context && attrs != null) {
			TypedArray array = context.obtainStyledAttributes(attrs,
					R.styleable.ProgressTextView);
			mTextColor = array.getColor(
					R.styleable.ProgressTextView_ptv_textColor, Color.WHITE);
			mTextSize = array.getDimensionPixelSize(
					R.styleable.ProgressTextView_ptv_textSize, 36);
			Bitmap Bmp = BitmapFactory.decodeResource(getResources(),
					R.drawable.plans_filter_thumb);
			Bmp1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.plans_filter_point);
			float thumWidth = Bmp.getWidth();
			Log.e(TAG, " thum width " + thumWidth);
			mThumbOffset = thumWidth / 2;
		}
		initObserver();
	}

	private void initObserver() {
		ViewTreeObserver vto = getViewTreeObserver();
		vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {

			@Override
			public boolean onPreDraw() {
				mHeight = getMeasuredHeight();
				mWidth = getMeasuredWidth();
				initPaint();
				initData();
				return true;
			}
		});
	}

	private void initPaint() {
		mPaint = new Paint();
		mPaint.setTextSize(mTextSize);
		mPaint.setTextAlign(Paint.Align.CENTER);
		mPaint.setColor(mTextColor);
	}

	private void initData() {
		mOneProgressWidth = (double) (mWidth - 2 * mThumbOffset)
				/ (mMaxProgress);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		drawText(canvas);
		super.onDraw(canvas);
	}

	// 设置字体居中显示
	private void drawText(Canvas canvas) {
		float x = (float) (mCurProgress * mOneProgressWidth);
		float textWidth = mPaint.measureText(mProgressText);
		float textOffset = textWidth / 2;
		if (x + textOffset > mWidth - mThumbOffset) {// 超过view的右边
			float exWidth = x + textOffset - (mWidth - mThumbOffset);
			x -= exWidth;// 避免超过右边
		}
		if (x + mThumbOffset < textOffset) {// 超过左边
			float exWidth = textOffset - (x + mThumbOffset);
			x += exWidth;// 避免超过左边
		}

		// 将icon图像转换为Bitmap对象
		Bitmap  iconbit = BitmapFactory.decodeResource(getResources(),
				R.drawable.plans_filter_point);
		int left=(int) (x+mThumbOffset-iconbit.getWidth()/2);
		canvas.drawBitmap(iconbit, left, 0, mPaint);
		canvas.translate(mThumbOffset, 0);
		FontMetricsInt fontMetrics = mPaint.getFontMetricsInt();
		canvas.drawText(mProgressText, x,-fontMetrics.ascent+iconbit.getHeight()/5 , mPaint);
	}

	// 设置显示的进度位置和字符串
	public void setProgress(int progress, String showText) {
		mCurProgress = progress;
		mProgressText = showText;
		invalidate();
	}
}
