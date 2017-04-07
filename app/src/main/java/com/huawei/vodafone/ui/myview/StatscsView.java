package com.huawei.vodafone.ui.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.huawei.vodafone.R;

/**
 * @author kanl
 *
 * @create 2016年7月28日 下午12:56:49
 */
public class StatscsView extends View {

	public StatscsView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub

		init(context, null);
	}

	public StatscsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init(context, attrs);
	}

	// 坐标轴 轴线 画笔：
	private Paint axisLinePaint;
	// 坐标轴水平内部 虚线画笔
	private Paint hLinePaint;
	// 绘制文本的画笔
	private Paint titlePaint;
	// 矩形画笔 柱状图的样式信息
	private Paint recPaint;

	private void init(Context context, AttributeSet attrs) {

		axisLinePaint = new Paint();
		hLinePaint = new Paint();
		titlePaint = new Paint();
		recPaint = new Paint();

		axisLinePaint.setColor(Color.GRAY);
		hLinePaint.setColor(Color.GRAY);
		titlePaint.setColor(Color.WHITE);
		titlePaint.setTextSize(26);

	}

	// 6 条
	private int[] thisYear;

	// 6 条
	private int[] lastYear;

	/**
	 * 跟新自身的数据 需要View子类重绘。
	 * 
	 * 主线程 刷新控件的时候调用： this.invalidate(); 失效的意思。 this.postInvalidate(); 可以子线程
	 * 更新视图的方法调用。
	 * 
	 * */
	// updata this year data
	public void updateThisData(int[] thisData) {
		thisYear = thisData;
		// this.invalidate(); //失效的意思。
		this.postInvalidate(); // 可以子线程 更新视图的方法调用。
	}

	// updata last year data
	public void updateLastData(int[] lastData) {
		lastYear = lastData;
		// this.invalidate(); //失效的意思。
		this.postInvalidate(); // 可以子线程 更新视图的方法调用。
	}

	private String[] yTitlesStrings = new String[] { "€30", "€20", "€10", "" };

	// private String[] xTitles =
	// new String[]{"Nov","Dec","Jan","Feb","May","Apr"};

	private String[] xTitles = new String[] { "Apr", "May", "Jun",
			"Jul", "Aug" , "Sep" };

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);

		int width = getWidth();
		int height = getHeight();

		// 1 绘制坐标线：
		// canvas.drawLine(100, 10, 100, 320, axisLinePaint);
		axisLinePaint.setStyle(Paint.Style.STROKE);
		axisLinePaint.setColor(Color.LTGRAY);
		Path path1 = new Path();
		path1.moveTo(100, 320);
		path1.lineTo(width - 10, 320);
		PathEffect effects1 = new DashPathEffect(new float[] { 5, 5, 5, 5 }, 2);
		axisLinePaint.setPathEffect(effects1);
		canvas.drawPath(path1, axisLinePaint);
		// canvas.drawLine(100, 320, width-10 , 320, axisLinePaint);

		// 2 绘制坐标内部的水平线

		int leftHeight = 300;// 左侧外周的 需要划分的高度：

		int hPerHeight = leftHeight / 3;

		hLinePaint.setTextAlign(Align.CENTER);
		for (int i = 0; i < 3; i++) {
			hLinePaint.setStyle(Paint.Style.STROKE);
			hLinePaint.setColor(Color.LTGRAY);
			Path path = new Path();
			path.moveTo(100, 20 + i * hPerHeight);
			path.lineTo(width - 10, 20 + i * hPerHeight);
			PathEffect effects = new DashPathEffect(new float[] { 5, 5, 5, 5 },
					2);
			hLinePaint.setPathEffect(effects);
			canvas.drawPath(path, hLinePaint);
			// canvas.drawLine(100, 20+i*hPerHeight, width-10, 20+i*hPerHeight,
			// hLinePaint);
		}

		// 3 绘制 Y 周坐标

		FontMetrics metrics = titlePaint.getFontMetrics();
		int descent = (int) metrics.descent;
		titlePaint.setTextAlign(Align.RIGHT);
		for (int i = 0; i < yTitlesStrings.length; i++) {
			canvas.drawText(yTitlesStrings[i], 80, 20 + i * hPerHeight
					+ descent, titlePaint);
		}

		// 4 绘制 X 周 做坐标

		int xAxisLength = width - 110;
		int columCount = xTitles.length + 1;
		int step = xAxisLength / columCount;

		for (int i = 0; i < columCount - 1; i++) {
			canvas.drawText(xTitles[i], 120 + step * (i + 1), 360, titlePaint);
		}

		// 5 绘制矩形

		if (thisYear != null && thisYear.length > 0) {
			int thisCount = thisYear.length;

			for (int i = 0; i < thisCount; i++) {
				float value = thisYear[i];

				float num = 8 - value / 10f;

				recPaint.setColor(getResources().getColor(R.color.lin_top));

				RectF rect = new RectF();
				rect.left = 100 + step * (i + 1) - 18;
				rect.right = 100 + step * (i + 1) + 18;

				// 当前的相对高度：
				float rh = (leftHeight * num) / 8;

				rect.top = rh + 40;
				rect.bottom = 320;
				canvas.drawRoundRect(rect, 20, 20, recPaint);
				// canvas.drawRect(rect, recPaint);

			}
		}

		if (lastYear != null && lastYear.length > 0) {
			int thisCount = lastYear.length;

			for (int i = 0; i < thisCount; i++) {
				float value = lastYear[i];

				float num = 8 - value / 10f;

				recPaint.setColor(getResources().getColor(R.color.lin_bottom));

				RectF rect = new RectF();

				rect.left = 100 + step * (i + 1) - 18;
				rect.right = 100 + step * (i + 1) + 18;

				// 当前的相对高度：
				float rh = (leftHeight * num) / 8f;

				rect.top = rh + 40;
				rect.bottom = 320;

				// canvas.drawRect(rect, recPaint);
				canvas.drawRoundRect(rect, 20, 20, recPaint);

			}
		}

	}

}
