package com.huawei.vodafone.util;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.text.TextUtils;

/**
 * Bitmap创建类
 * 
 * @author huanwu
 */
public class BitmapUtil {

	public static Drawable convertBitmap2Drawable(Resources res, Bitmap bitmap) {
		BitmapDrawable bd = new BitmapDrawable(res, bitmap);
		// 因为BtimapDrawable是Drawable的子类，最终直接使用bd对象即可。
		return (Drawable) bd;
	}

	public static Bitmap convertDrawable2Bitmap(Drawable d) {

		BitmapDrawable bd = (BitmapDrawable) d;

		Bitmap bm = bd.getBitmap();
		return bm;
	}

	public static Bitmap createBitmap(Bitmap source, int x, int y, int width,
			int height, Matrix m, boolean filter) {
		Bitmap bitmap = null;
		if (source != null && !source.isRecycled()) {
			try {
				bitmap = Bitmap.createBitmap(source, 0, 0, width, height, m,
						true);
			} catch (OutOfMemoryError e) {
				System.gc();
				try {
					bitmap = Bitmap.createBitmap(source, 0, 0, width, height,
							m, true);
				} catch (OutOfMemoryError e1) {
				}
			} catch (Exception e2) {
			}
		}
		if (bitmap == null) {
			bitmap = Bitmap.createBitmap(1, 1, Config.ALPHA_8);
		}
		return bitmap;
	}

	public static Bitmap createBitmap(int width, int height, Config config) {
		Bitmap bitmap = null;
		try {
			bitmap = Bitmap.createBitmap(width, height, config);
		} catch (OutOfMemoryError e) {
			System.gc();
			try {
				bitmap = Bitmap.createBitmap(width, height, config);
			} catch (OutOfMemoryError e1) {
			}
		} catch (Exception e2) {
		}
		if (bitmap == null) {
			bitmap = Bitmap.createBitmap(1, 1, Config.ALPHA_8);
		}
		return bitmap;
	}

	public static Bitmap decodeFile(String pathName) {
		Bitmap bitmap = null;
		if (FileUtil.isFileExist(pathName)) {
			BitmapFactory.Options opts = new BitmapFactory.Options();

			opts.inPurgeable = true;
			opts.inInputShareable = true;
			opts.inPreferredConfig = android.graphics.Bitmap.Config.ALPHA_8;
			opts.inDither = true;
			// InputStream is = FileUtil.readFileInputStream(pathName);
			// bitmap = decodeStream(is);
			try {
				bitmap = BitmapFactory.decodeFile(pathName, opts);
			} catch (OutOfMemoryError e) {
				System.gc();
				try {
					bitmap = BitmapFactory.decodeFile(pathName, opts);
				} catch (OutOfMemoryError e1) {
				}
			} catch (Exception e2) {
			}
		}
		// if (bitmap == null) {
		// bitmap = Bitmap.createBitmap(1, 1, Config.ALPHA_8);
		// }
		return bitmap;
	}

	public static Bitmap decodeFile(String pathName, int width, int height) {
		Bitmap bitmap = null;
		if (FileUtil.isFileExist(pathName)) {
			BitmapFactory.Options opts = new BitmapFactory.Options();
			opts.inJustDecodeBounds = true;
			BitmapFactory.decodeFile(pathName, opts);
			opts.inSampleSize = computeSampleSize(opts, -1, width * height);
			opts.inJustDecodeBounds = false;

			opts.inPurgeable = true;
			opts.inInputShareable = true;
			opts.inPreferredConfig = android.graphics.Bitmap.Config.ALPHA_8;
			opts.inDither = true;

			try {
				bitmap = BitmapFactory.decodeFile(pathName, opts);
			} catch (OutOfMemoryError e) {
				System.gc();
				try {
					bitmap = BitmapFactory.decodeFile(pathName, opts);
				} catch (OutOfMemoryError e1) {
				}
			} catch (Exception e2) {
			}
		}
		// if (bitmap == null) {
		// bitmap = Bitmap.createBitmap(1, 1, Config.ALPHA_8);
		// }
		return bitmap;
	}

	public static Bitmap decodeStream(InputStream is) {
		Bitmap bitmap = null;
		if (is != null) {
			BitmapFactory.Options opts = new BitmapFactory.Options();
			opts.inPurgeable = true;
			opts.inInputShareable = true;
			opts.inPreferredConfig = android.graphics.Bitmap.Config.ALPHA_8;
			opts.inDither = true;

			try {
				bitmap = BitmapFactory.decodeStream(is, null, opts);
			} catch (OutOfMemoryError e) {
				System.gc();
				try {
					bitmap = BitmapFactory.decodeStream(is, null, opts);
				} catch (OutOfMemoryError e1) {
				}
			} catch (Exception e2) {
			}
		}
		if (bitmap == null) {
			bitmap = Bitmap.createBitmap(1, 1, Config.ALPHA_8);
		}
		return bitmap;
	}

	public static Bitmap createBitmap(int[] colors, int width, int height,
			Config config) {
		Bitmap bitmap = null;
		try {
			bitmap = Bitmap.createBitmap(colors, width, height, config);
		} catch (OutOfMemoryError e) {
			System.gc();
			try {
				bitmap = Bitmap.createBitmap(colors, width, height, config);
			} catch (OutOfMemoryError e1) {
			}
		} catch (Exception e2) {
		}
		if (bitmap == null) {
			bitmap = Bitmap.createBitmap(1, 1, Config.ALPHA_8);
		}
		return bitmap;
	}

	public static Bitmap createBitmap(Bitmap source, int x, int y, int width,
			int height) {
		Bitmap bitmap = null;
		if (source != null && !source.isRecycled()) {
			try {
				bitmap = Bitmap.createBitmap(source, x, y, width, height);
			} catch (OutOfMemoryError e) {
				System.gc();
				try {
					bitmap = Bitmap.createBitmap(source, x, y, width, height);
				} catch (OutOfMemoryError e1) {
				}
			} catch (Exception e2) {
			}
		}
		if (bitmap == null) {
			bitmap = Bitmap.createBitmap(1, 1, Config.ALPHA_8);
		}
		return bitmap;
	}

	private static int computeSampleSize(BitmapFactory.Options options,
			int minSideLength, int maxNumOfPixels) {
		int initialSize = computeInitialSampleSize(options, minSideLength,
				maxNumOfPixels);
		int roundedSize;
		if (initialSize <= 8) {
			roundedSize = 1;
			while (roundedSize < initialSize) {
				roundedSize <<= 1;
			}
		} else {
			roundedSize = (initialSize + 7) / 8 * 8;
		}

		return roundedSize;
	}

	private static int computeInitialSampleSize(BitmapFactory.Options options,
			int minSideLength, int maxNumOfPixels) {
		double w = options.outWidth;
		double h = options.outHeight;

		int lowerBound = (maxNumOfPixels == -1) ? 1 : (int) Math.ceil(Math
				.sqrt(w * h / maxNumOfPixels));
		int upperBound = (minSideLength == -1) ? 128 : (int) Math.min(
				Math.floor(w / minSideLength), Math.floor(h / minSideLength));

		if (upperBound < lowerBound) {
			// return the larger one when there is no overlapping zone.
			return lowerBound;
		}

		if ((maxNumOfPixels == -1) && (minSideLength == -1)) {
			return 1;
		} else if (minSideLength == -1) {
			return lowerBound;
		} else {
			return upperBound;
		}
	}

	/**
	 * 读取
	 * 
	 * @param filePath
	 *            文件路径
	 * @return
	 */
	public static Bitmap readBitmap(final String filePath) {
		if (TextUtils.isEmpty(filePath)) {
			return null;
		} else {
			// BitmapFactory.Options options=new BitmapFactory.Options();
			// options.inSampleSize = 8;
			return BitmapUtil.decodeFile(filePath);
		}
	}

	/**
	 * 转换图片成圆形
	 * 
	 * @param bitmap
	 *            传入Bitmap对象
	 * @return
	 */
	public static Bitmap toRoundBitmap(Bitmap bitmap) {
		if (bitmap == null) {
			return null;
		}
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		float roundPx;
		float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;
		if (width <= height) {
			roundPx = width / 2;
			top = 0;
			bottom = width;
			left = 0;
			right = width;
			height = width;
			dst_left = 0;
			dst_top = 0;
			dst_right = width;
			dst_bottom = width;
		} else {
			roundPx = height / 2;
			float clip = (width - height) / 2;
			left = clip;
			right = width - clip;
			top = 0;
			bottom = height;
			width = height;
			dst_left = 0;
			dst_top = 0;
			dst_right = height;
			dst_bottom = height;
		}

		Bitmap output = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int color = 0xffffffff;
		final Paint paint = new Paint();
		final Rect src = new Rect((int) left, (int) top, (int) right,
				(int) bottom);
		final Rect dst = new Rect((int) dst_left, (int) dst_top,
				(int) dst_right, (int) dst_bottom);
		final RectF rectF = new RectF(dst);

		paint.setAntiAlias(true);

		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, src, dst, paint);
		setBitmapBorder(canvas, roundPx);
		return output;
	}

	/**
	 * 给bitmap设置边框
	 * 
	 * @param canvas
	 */
	private static void setBitmapBorder(Canvas canvas, float round) {
		Paint paint = new Paint();
		// 设置边框颜色
		paint.setColor(Color.WHITE);
		paint.setStyle(Paint.Style.STROKE);
		paint.setAntiAlias(true); // 消除锯齿
		paint.setStrokeWidth(3); // 设置圆环的宽度
		canvas.drawCircle(round, round, round - 1.5f, paint);
	}

	public static Bitmap decodeResource(Context context, int resId) {
		Bitmap bitmap = null;
		try {
			bitmap = BitmapFactory
					.decodeResource(context.getResources(), resId);
		} catch (OutOfMemoryError e) {
			System.gc();
		} catch (Exception e2) {
		}
		if (bitmap == null) {
			bitmap = Bitmap.createBitmap(1, 1, Config.ALPHA_8);
		}
		return bitmap;
	}

	/**
	 * 获取带圆角的图片
	 * 
	 * @param bitmap
	 *            需要处理的图片
	 * @param roundPx
	 *            圆角半径
	 * @return Bitmap 带圆角的图片
	 */
	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx) {
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);

		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);
		return output;
	}

	/**
	 * 获取带圆角的图片
	 * 
	 * @param drawable
	 *            需要处理的图片
	 * @param roundPx
	 *            圆角半径
	 * @return Bitmap 带圆角的图片
	 */
	public static Bitmap getRoundedCornerBitmap(Drawable drawable, float roundPx) {
		if (drawable == null) {
			return null;
		}
		Bitmap bitmap = ImageUtil.drawableToBitmap(drawable);
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);

		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);

		return output;
	}

	/**
	 * 读取图片的旋转的角度
	 * 
	 * @param path
	 *            图片绝对路径
	 * @return 图片的旋转角度
	 */
	public static int getBitmapDegree(String path) {
		int degree = 0;
		try {
			// 从指定路径下读取图片，并获取其EXIF信息
			ExifInterface exifInterface = new ExifInterface(path);
			// 获取图片的旋转信息
			int orientation = exifInterface.getAttributeInt(
					ExifInterface.TAG_ORIENTATION,
					ExifInterface.ORIENTATION_NORMAL);
			switch (orientation) {
			case ExifInterface.ORIENTATION_ROTATE_90:
				degree = 90;
				break;
			case ExifInterface.ORIENTATION_ROTATE_180:
				degree = 180;
				break;
			case ExifInterface.ORIENTATION_ROTATE_270:
				degree = 270;
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return degree;
	}

	/**
	 * 旋转图片
	 * 
	 * @param angle
	 * @param bitmap
	 * @return Bitmap
	 */
	public static Bitmap rotaingImageView(int angle, Bitmap bitmap) {
		// 旋转图片 动作
		Matrix matrix = new Matrix();
		matrix.postRotate(angle);
		System.out.println("angle2=" + angle);
		// 创建新的图片
		Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0,
				bitmap.getWidth(), bitmap.getHeight(), matrix, true);
		return resizedBitmap;
	}

}
