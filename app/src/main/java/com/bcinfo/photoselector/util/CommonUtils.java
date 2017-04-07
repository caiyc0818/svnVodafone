package com.bcinfo.photoselector.util;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.ImageColumns;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.widget.Toast;

import com.bcinfo.photoselector.model.PhotoModel;
import com.bcinfo.photoselector.ui.PhotoSelectorActivity;
import com.huawei.vodafone.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 通用工具类
 * 
 * @author chenww
 * 
 */
public class CommonUtils {
	public static File cameraFile;
	public static final int CAMERA_PHOTO = 10002;
	/**
	 * 开启activity
	 */
	public static void launchActivity(Context context, Class<?> activity) {
		Intent intent = new Intent(context, activity);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		context.startActivity(intent);
	}

	/**
	 * 开启activity(带参数)
	 */
	public static void launchActivity(Context context, Class<?> activity, Bundle bundle) {
		Intent intent = new Intent(context, activity);
		intent.putExtras(bundle);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		context.startActivity(intent);
	}

	/**
	 * 开启activity(带参数)
	 */
	public static void launchActivity(Context context, Class<?> activity, String key, int value) {
		Bundle bundle = new Bundle();
		bundle.putInt(key, value);
		launchActivity(context, activity, bundle);
	}

	public static void launchActivity(Context context, Class<?> activity, String key, String value) {
		Bundle bundle = new Bundle();
		bundle.putString(key, value);
		launchActivity(context, activity, bundle);
	}

	public static void launchActivityForResult(Activity context, Class<?> activity, int requestCode) {
		Intent intent = new Intent(context, activity);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		context.startActivityForResult(intent, requestCode);
	}
	
	public static void launchActivityForResult(Activity context, Class<?> activity, int requestCode, int maxImage) {
		Intent intent = new Intent(context, activity);
		intent.putExtra(PhotoSelectorActivity.KEY_MAX, maxImage);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		context.startActivityForResult(intent, requestCode);
	}

	public static void launchActivityForResult(Activity activity, Intent intent, int requestCode) {
		activity.startActivityForResult(intent, requestCode);
	}

	/** 启动一个服务 */
	public static void launchService(Context context, Class<?> service) {
		Intent intent = new Intent(context, service);
		context.startService(intent);
	}

	public static void stopService(Context context, Class<?> service) {
		Intent intent = new Intent(context, service);
		context.stopService(intent);
	}

	/**
	 * 判断字符串是否为空
	 * @param text
	 * @return true null false !null
	 */
	public static boolean isNull(CharSequence text) {
		if (text == null || "".equals(text.toString().trim()) || "null".equals(text))
			return true;
		return false;
	}

	/** 获取屏幕宽度 */
	public static int getWidthPixels(Activity activity) {
		DisplayMetrics dm = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		return dm.widthPixels;
	}

	/** 获取屏幕高度 */
	public static int getHeightPixels(Activity activity) {
		DisplayMetrics dm = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		return dm.heightPixels;
	}

	/** 通过Uri获取图片路径 */
	public static String query(Context context, Uri uri) {
		Cursor cursor = context.getContentResolver().query(uri, new String[] { ImageColumns.DATA }, null, null, null);
		cursor.moveToNext();
		return cursor.getString(cursor.getColumnIndex(ImageColumns.DATA));
	}

	
	// 返回是否有SD卡
	public static boolean GetSDState() {
		if (Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			return true;
		}
		return false;
	}
	/**
	 * 照相获取图片
	 * 
	 * @return 图片路径
	 */
	public static void selectPicFromCamera(Context mContext) {
		if (!GetSDState()) {
			showToast(mContext, "SD卡不存在，不能拍照");
			return;
		}
		cameraFile = new File(getFileAddress(0, mContext.getResources()
				.getString(R.string.app_name), mContext), "userface"
				+ System.currentTimeMillis() + ".png");
		try {
			deleteFile(cameraFile);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			cameraFile.getParentFile().mkdirs();
			((Activity) mContext).startActivityForResult(new Intent(
					MediaStore.ACTION_IMAGE_CAPTURE).putExtra(
					MediaStore.EXTRA_OUTPUT, Uri.fromFile(cameraFile)),
					CAMERA_PHOTO);
		}

	}
	
	/**
	 * 
	 * @Title: deleteFile
	 * @Description: TODO(删除文件)
	 * @param @param file 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void deleteFile(File file) {
		if (file.exists()) { // 判断文件是否存在
			if (file.isFile()) { // 判断是否是文件
				file.delete(); // delete()方法 你应该知道 是删除的意思;
			} else if (file.isDirectory()) { // 否则如果它是一个目录
				File files[] = file.listFiles(); // 声明目录下所有的文件 files[];
				for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
					deleteFile(files[i]); // 把每个文件 用这个方法进行迭代
				}
			}
			file.delete();
		} else {

		}
	}
	
	/**
	 * 返回SD卡存储路径
	 * 
	 * @param state
	 *            1：picture 2:video 3:voice 4:ceche 其他是cache
	 * @param appName
	 *            项目名称
	 * @return
	 */
	public static String getFileAddress(int state, String appName,
			Context mContext) {

		String Address = "";

		if (GetSDState()) {

			Address = Environment.getExternalStorageDirectory().getPath() + "/"
					+ appName + "/";
		} else {
			Address = mContext.getCacheDir().getAbsolutePath() + "/" + appName
					+ "/";
		}
		switch (state) {
		case 1:
			Address = Address + "cache1/";
			break;
		case 2:
			Address = Address + "video/";
			break;
		case 3:
			Address = Address + "voice/";
			break;
		case 4:
			Address = Address + "file/";
			break;
		case 5:
			Address = Address + "photos/";
			break;
		default:
			Address = Address + "cache/";
			break;
		}
		File baseFile = new File(Address);
		if (!baseFile.exists()) {
			baseFile.mkdirs();
		}
		return Address;
	}
	
	/**
	 * 显示toast
	 * 
	 *            当前activity
	 *            显示的内容
	 */

	public static void showToast(Context mContext, String content) {
		Toast.makeText(mContext, content, Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * 开启PhotoSelector(带参数)
	 */
	public static void launchPhotoSelectorActivity(Activity context,int requestCode) {
		List<PhotoModel> choosed = new ArrayList<>();
		Intent intent = new Intent(context,
				PhotoSelectorActivity.class);
		intent.putExtra(PhotoSelectorActivity.KEY_MAX, 50);
		Bundle bundle = new Bundle();
		bundle.putParcelableArrayList("selected",
				(ArrayList<? extends Parcelable>) choosed);
		bundle.putBoolean("isMultiChoice", false);
		intent.putExtras(bundle);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		context.startActivityForResult(intent, requestCode);
	}
	
	/**
	 * 开启PhotoSelector(带参数)
	 */
	public static void launchPhotoSelectorActivity(Fragment context,int requestCode) {
		List<PhotoModel> choosed = new ArrayList<>();
		Intent intent = new Intent(context.getActivity(),
				PhotoSelectorActivity.class);
		intent.putExtra(PhotoSelectorActivity.KEY_MAX, 50);
		Bundle bundle = new Bundle();
		bundle.putParcelableArrayList("selected",
				(ArrayList<? extends Parcelable>) choosed);
		bundle.putBoolean("isMultiChoice", false);
		intent.putExtras(bundle);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		context.startActivityForResult(intent, requestCode);
	}
}
