package com.huawei.vodafone.ui.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.huawei.vodafone.R;

/**
 * 仿iphone带进度的进度条，线程安全的View，可直接在线程中更新进度
 * 
 * @author xiaanming
 * 
 */
public class RoundProgressBar extends View {
	/**
	 * 画笔对象的引用
	 */
	private Paint paint;
	/**
	 * 圆环的颜色
	 */
	private int roundColor;
	/**
	 * 圆环进度的颜色
	 */
	private int roundProgressColor;
	/**
	 * 第三种圆环的颜色
	 */
	private int ProgressColorth;
	/**
	 * 中间进度百分比的字符串的颜色
	 */
	private int textColor;
	/**
	 * 中间进度百分比的字符串的字体
	 */
	private float textSize;
	/**
	 * 开始视角
	 */
	private float startAngle;
	/**
	 * 圆环的宽度
	 */
	private float roundWidth;
	/**
	 * 最大进度
	 */
	private int max;
	/**
	 * 移动的图片,结束位置
	 */
	private Drawable moveD;
	/**
	 * 固定的图片,开始位置
	 */
	private Drawable moveS;
	/**
	 * 当前进度
	 */
	private float progress;
	/**
	 * 第二个进度条
	 */
	private float progressth = 0;
	/**
	 * 第二个进度条
	 */
	private float startprogressth = 0;
	/**
	 * 是否显示中间的进度
	 */
	private boolean textIsDisplayable;
	/**
	 * 进度的风格，实心或者空心
	 */
	private int style;
	/**
	 * 文字控制
	 */
	private boolean textType = true;
	/**
	 * 起点图片的大小
	 */
	Rect StartSrc = null;
	/**
	 * 起点图片的位置
	 */
	RectF StartDst = null;
	/**
	 * 自己设置text
	 */
	boolean usemytext = false;
	/**
	 * text1,text2,text3
	 */
	String text1, text2, text3;

	public void setTextType(boolean textType) {
		this.textType = textType;
	}

	public static final int STROKE = 0;
	public static final int FILL = 1;

	public RoundProgressBar(Context context) {
		this(context, null);
	}

	public RoundProgressBar(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public RoundProgressBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		paint = new Paint();
		TypedArray mTypedArray = context.obtainStyledAttributes(attrs,
				R.styleable.RoundProgressBar);
		// 获取自定义属性和默认值
		roundColor = mTypedArray.getColor(
				R.styleable.RoundProgressBar_roundColor, Color.RED);
		ProgressColorth = mTypedArray.getColor(
				R.styleable.RoundProgressBar_roundColorth, Color.RED);
		roundProgressColor = mTypedArray.getColor(
				R.styleable.RoundProgressBar_roundProgressColor, Color.GREEN);
		textColor = mTypedArray.getColor(
				R.styleable.RoundProgressBar_textColor, Color.GREEN);
		textSize = mTypedArray.getDimension(
				R.styleable.RoundProgressBar_textSize, 15);
		roundWidth = mTypedArray.getDimension(
				R.styleable.RoundProgressBar_roundWidth, 5);
		max = mTypedArray.getInteger(R.styleable.RoundProgressBar_max, 100);
		startAngle = mTypedArray.getFloat(
				R.styleable.RoundProgressBar_startAngle, 0);
		moveD = mTypedArray.getDrawable(R.styleable.RoundProgressBar_endImage);
		moveS = mTypedArray
				.getDrawable(R.styleable.RoundProgressBar_startImage);
		textIsDisplayable = mTypedArray.getBoolean(
				R.styleable.RoundProgressBar_textIsDisplayable, true);
		style = mTypedArray.getInt(R.styleable.RoundProgressBar_style, 0);
		mTypedArray.recycle();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		/**
		 * 画最外层的大圆环
		 */
		int centre = getWidth() / 2; // 获取圆心的x坐标
		// int radius = (int) (centre - roundWidth / 2); // 圆环的半径
		int radius = (int) (centre); // 圆环的半径
		int bitwidth = 0;
		if (moveD != null) {
			Bitmap bitmap = ((BitmapDrawable) moveD).getBitmap();
			bitwidth = bitmap.getWidth();

		}
		if (moveS != null) {
			Bitmap bitmap = ((BitmapDrawable) moveS).getBitmap();
			bitwidth = Math.max(bitwidth, bitmap.getWidth());
		}
		if (bitwidth > roundWidth) {
			radius = radius - bitwidth / 2 - (int) roundWidth / 2;
		} else {
			radius = (int) (centre - roundWidth / 2);
		}
		paint.setColor(roundColor); // 设置圆环的颜色
		paint.setStyle(Paint.Style.STROKE); // 设置空心
		paint.setStrokeWidth(roundWidth); // 设置圆环的宽度
		paint.setAntiAlias(true); // 消除锯齿
		canvas.drawCircle(centre, centre, radius, paint); // 画出圆环
		/**
		 * 画进度百分比
		 */
		paint.setStrokeWidth(0);
		paint.setColor(textColor);
		paint.setTextSize(textSize);
		// paint.setTypeface(Typeface.DEFAULT_BOLD); // 设置字体
		if (textType) {
			// if (usemytext) {
			// drawMyText(canvas);
			// } else {
			// int percent = (int) (((float) progress / (float) max) * 100); //
			// 中间的进度百分比，先转换成float在进行除法运算，不然都为0
			// float textWidth = paint.measureText(percent + "%"); //
			// 测量字体宽度，我们需要根据字体的宽度设置在圆环中间
			// float textHeight = paint.getFontMetrics().bottom
			// - paint.getFontMetrics().top;
			// if (textIsDisplayable && style == STROKE) {// 显示百分比
			// canvas.drawText(percent + "%", centre - textWidth / 2,
			// centre + textHeight / 4, paint); // 画出进度百分比
			// }
			// }

			/**
			 * 画圆弧 ，画圆环的进度
			 */
			// 设置进度是实心还是空心
			if (bitwidth > roundWidth) {
				paint.setStrokeWidth(bitwidth); // 设置圆环的宽度
			} else {
				paint.setStrokeWidth(roundWidth); // 设置圆环的宽度
			}

			RectF oval = new RectF(centre - radius, centre - radius, centre
					+ radius, centre + radius); // 用于定义的圆弧的形状和大小的界限

			paint.setColor(roundProgressColor); // 设置进度的颜色
			switch (style) {
			case STROKE: {
				paint.setStyle(Paint.Style.STROKE);
				canvas.drawArc(oval, startAngle, 360 * progress / max, false,
						paint); // 根据进度画圆弧
				break;
			}
			case FILL: {
				paint.setStyle(Paint.Style.FILL_AND_STROKE);
				if (progress != 0)
					canvas.drawArc(oval, startAngle, 360 * progress / max,
							true, paint); // 根据进度画圆弧
				break;
			}
			}

			paint.setStrokeWidth(bitwidth - 8); // 设置圆环的宽度
			paint.setColor(ProgressColorth); // 设置进度的颜色,第二个进度条
			paint.setStyle(Paint.Style.STROKE);
			float startdegree = 360 * startprogressth / max + startAngle;
			for (float i = startdegree; i < 360 * progressth / max + startAngle; i = i + 3) {
				canvas.drawArc(oval, i, 1, false, paint); // 最上面一层黑色
			}
			/*
			 * 把drawable转成bitmap,开始位置的图片
			 */
			if (moveS != null && progress != 0 && progress != 100) {
				Bitmap bitmap = ((BitmapDrawable) moveS).getBitmap();
				if (StartSrc == null || StartDst == null) {
					StartSrc = new Rect();
					StartSrc.left = 0;
					StartSrc.top = 0;
					StartSrc.right = bitmap.getWidth();
					StartSrc.bottom = bitmap.getHeight();

					float pointX = (float) (centre);
					float pointY = (float) (centre - radius);
					int h = bitmap.getHeight();
					StartDst = new RectF();
					StartDst.right = pointX + h / 2;
					StartDst.bottom = pointY + h / 2;
					StartDst.left = pointX - h / 2;
					StartDst.top = pointY - h / 2;
				}
				canvas.drawBitmap(bitmap, StartSrc, StartDst, null);
			}
			/*
			 * 把drawable转成bitmap，结尾位置的图片
			 */
			if (moveD != null && progress != 0 && progress != 100) {
				Bitmap bitmap = ((BitmapDrawable) moveD).getBitmap();
				/*
				 * 计算旋转角度，默认图已经旋转23/100
				 */
				float angle = 360 * (progress - 23) / max;
				Matrix matrix = new Matrix();
				matrix.setRotate(angle, (float) bitmap.getWidth() / 2,
						(float) bitmap.getHeight() / 2);// 旋转图片
				bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
						bitmap.getHeight(), matrix, true);

				Rect src = new Rect();
				src.left = 0;
				src.top = 0;
				src.right = bitmap.getWidth();
				src.bottom = bitmap.getHeight();
				/*
				 * 根据角度计算点得位置
				 */
				float ao = 360 * progress / max;
				double sin = Math.sin(Math.toRadians(ao % 180 == 0 ? 0 : ao));
				double cos = Math.sqrt(1 - sin * sin);
				double temp = ao - ((int) ao / 360) * 360;
				if (temp > 90 && temp < 270) {// 处理负数
					cos = -cos;
				}
				float pointX = (float) (centre + radius * sin);
				float pointY = (float) (centre - radius * cos);
				int h = bitmap.getHeight();
				RectF dst = new RectF();
				dst.right = pointX + h / 2;
				dst.bottom = pointY + h / 2;
				dst.left = pointX - h / 2;
				dst.top = pointY - h / 2;
				canvas.drawBitmap(bitmap, src, dst, null);
				src = null;
				dst = null;
			}
		} else {
			float textWidth = paint
					.measureText((int) Math.floor(progress) + ""); // 测量字体宽度，我们需要根据字体的宽度设置在圆环中间
			float textHeight = paint.getFontMetrics().bottom
					- paint.getFontMetrics().top;
			canvas.drawText((int) Math.floor(progress) + "", centre - textWidth
					/ 2, centre + textHeight / 4, paint); // 画出进度百分比
		}
	}

	private void drawMyText(Canvas canvas) {

		int centreX = getWidth() / 2; // 获取圆心的x坐标
		int centreY = getHeight() / 2;// 获取圆心的Y坐标
		TextPaint paint1 = new TextPaint();
		paint1.setStrokeWidth(0);
		paint1.setAntiAlias(true); // 抗锯齿
		paint1.setColor(textColor);
		paint1.setFakeBoldText(true);
		paint1.setTextSize(textSize + 20);
		float textWidth1 = paint.measureText(text1);
		float textWidth2 = paint1.measureText(text2);
		float textWidth3 = paint.measureText(text3);
		float textHeight = paint1.getFontMetrics().bottom
				- paint1.getFontMetrics().top;
		canvas.drawText(text1, centreX - textWidth1 / 2, centreY - textHeight
				/ 2, paint);
		canvas.drawText(text2, centreX - textWidth2 / 2, centreY + textHeight
				/ 4, paint1);
		canvas.drawText(text3, centreX - textWidth3 / 2, centreY + textHeight
				/ 4 * 3, paint);
	}

	public void MyText(String text1, String text2, String text3) {
		usemytext = true;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
	}

	public synchronized int getMax() {
		return max;
	}

	/**
	 * 设置进度的最大值
	 * 
	 * @param max
	 */
	public synchronized void setMax(int max) {
		if (max < 0) {
			throw new IllegalArgumentException("max not less than 0");
		}
		this.max = max;
	}

	/**
	 * 获取进度.需要同步
	 * 
	 * @return
	 */
	public synchronized float getProgress() {
		return progress;
	}

	/**
	 * 设置进度，此为线程安全控件，由于考虑多线的问题，需要同步 刷新界面调用postInvalidate()能在非UI线程刷新
	 * 
	 * @param progress
	 */
	public synchronized void setProgress(float progress) {
		if (progress < 0) {
			throw new IllegalArgumentException("progress not less than 0");
		}
		if (progress > max) {
			progress = max;
		}
		if (progress <= max) {
			this.progress = progress;
			postInvalidate();
		}
	}

	public synchronized void setProgressth(float startprogressth,
			float progressth) {
		if (progressth < 0 || startprogressth < 0) {
			throw new IllegalArgumentException("progress not less than 0");
		}
		if (progressth > max) {
			progressth = max;
		}
		if (startprogressth > max) {
			startprogressth = max;
		}
		if (progressth <= max) {
			this.progressth = progressth;
			this.startprogressth = startprogressth;
			postInvalidate();
		}
	}

	public int getCricleColor() {
		return roundColor;
	}

	public void setCricleColor(int cricleColor) {
		this.roundColor = cricleColor;
	}

	public int getCricleProgressColor() {
		return roundProgressColor;
	}

	public void setCricleProgressColor(int cricleProgressColor) {
		this.roundProgressColor = cricleProgressColor;
	}

	public int getTextColor() {
		return textColor;
	}

	public void setTextColor(int textColor) {
		this.textColor = textColor;
	}

	public float getTextSize() {
		return textSize;
	}

	public void setTextSize(float textSize) {
		this.textSize = textSize;
	}

	public float getRoundWidth() {
		return roundWidth;
	}

	public void setRoundWidth(float roundWidth) {
		this.roundWidth = roundWidth;
	}
}
