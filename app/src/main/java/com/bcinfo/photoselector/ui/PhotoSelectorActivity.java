package com.bcinfo.photoselector.ui;

/**
 * 
 * @author Aizaz AZ
 *
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bcinfo.photoselector.domain.PhotoSelectorDomain;
import com.bcinfo.photoselector.model.AlbumModel;
import com.bcinfo.photoselector.model.PhotoModel;
import com.bcinfo.photoselector.ui.PhotoItem.onItemClickListener;
import com.bcinfo.photoselector.ui.PhotoItem.onPhotoItemCheckedListener;
import com.bcinfo.photoselector.ui.PhotoItem.onPhotoItemClickedListener;
import com.bcinfo.photoselector.util.AnimationUtil;
import com.bcinfo.photoselector.util.CommonUtils;
import com.huawei.vodafone.R;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aizaz AZ
 * 
 */
public class PhotoSelectorActivity extends Activity implements onItemClickListener, onPhotoItemCheckedListener,
		OnItemClickListener, OnClickListener, onPhotoItemClickedListener {

	public static final int SINGLE_IMAGE = 1;
	public static final String KEY_MAX = "key_max";
	private int MAX_IMAGE;


	public static String RECCENT_PHOTO = null;

	private GridView gvPhotos;
	private ListView lvAblum;
	private LinearLayout btnOk;
	private TextView tvAlbum, tvPreview;
	private PhotoSelectorDomain photoSelectorDomain;
	private PhotoSelectorAdapter photoAdapter;
	private AlbumAdapter albumAdapter;
	private RelativeLayout layoutAlbum;
	private ArrayList<Parcelable> selected;
	private TextView tvNumber;
	private boolean isMultiChoice = true;

	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		RECCENT_PHOTO = "recent_photos";
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
		setContentView(R.layout.activity_photoselector);
		selected = new ArrayList<>();
		if (getIntent().getExtras() != null) {
			MAX_IMAGE = getIntent().getIntExtra(KEY_MAX, 10);
			selected.addAll((ArrayList<? extends Parcelable>) getIntent().getParcelableArrayListExtra("selected"));
			isMultiChoice = getIntent().getBooleanExtra("isMultiChoice", true);
		}

		initImageLoader();

		photoSelectorDomain = new PhotoSelectorDomain(getApplicationContext());

		gvPhotos = (GridView) findViewById(R.id.gv_photos_ar);
		lvAblum = (ListView) findViewById(R.id.lv_ablum_ar);
		btnOk = (LinearLayout) findViewById(R.id.btn_right_lh);
		tvAlbum = (TextView) findViewById(R.id.tv_album_ar);
		tvPreview = (TextView) findViewById(R.id.tv_preview_ar);
		layoutAlbum = (RelativeLayout) findViewById(R.id.layout_album_ar);
		tvNumber = (TextView) findViewById(R.id.tv_number);
		tvNumber.setText("(" + selected.size() + ")");
		btnOk.setOnClickListener(this);
		tvAlbum.setOnClickListener(this);
		tvPreview.setOnClickListener(this);

		if (selected.size() > 0) {
			tvPreview.setEnabled(true);
		} else {
			tvPreview.setEnabled(false);

		}

		if (isMultiChoice) {

			photoAdapter = new PhotoSelectorAdapter(getApplicationContext(), new ArrayList<PhotoModel>(),
					CommonUtils.getWidthPixels(this), this, null, this, this);
		} else {
			photoAdapter = new PhotoSelectorAdapter(getApplicationContext(), new ArrayList<PhotoModel>(),
					CommonUtils.getWidthPixels(this), null, this, this, this);
			btnOk.setVisibility(View.GONE);
		}
		gvPhotos.setAdapter(photoAdapter);

		albumAdapter = new AlbumAdapter(getApplicationContext(), new ArrayList<AlbumModel>());
		lvAblum.setAdapter(albumAdapter);
		lvAblum.setOnItemClickListener(this);

		findViewById(R.id.bv_back_lh).setOnClickListener(this); // 返回

		photoSelectorDomain.getReccent(reccentListener); // 更新最近照片
		photoSelectorDomain.updateAlbum(albumListener); // 跟新相册信息
	}

	private void initImageLoader() {
		DisplayImageOptions imageOptions = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.ic_picture_loading).showImageOnFail(R.drawable.ic_picture_loadfailed)
				.cacheInMemory(true).cacheOnDisk(true).resetViewBeforeLoading(true).considerExifParams(false)
				.bitmapConfig(Bitmap.Config.RGB_565).build();

		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).memoryCacheExtraOptions(400, 400)
				// default = device screen dimensions
				.diskCacheExtraOptions(400, 400, null).threadPoolSize(5)
				// default Thread.NORM_PRIORITY - 1
				.threadPriority(Thread.NORM_PRIORITY)
				// default FIFO
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				// default
				.denyCacheImageMultipleSizesInMemory().memoryCache(new LruMemoryCache(2 * 1024 * 1024))
				.memoryCacheSize(2 * 1024 * 1024).memoryCacheSizePercentage(13)
				// default
				.diskCache(new UnlimitedDiscCache(StorageUtils.getCacheDirectory(this, true)))
				// default
				.diskCacheSize(50 * 1024 * 1024).diskCacheFileCount(100)
				.diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
				// default
				.imageDownloader(new BaseImageDownloader(this))
				// default
				.imageDecoder(new BaseImageDecoder(false))
				// default
				.defaultDisplayImageOptions(DisplayImageOptions.createSimple())
				// default
				.defaultDisplayImageOptions(imageOptions).build();

		ImageLoader.getInstance().init(config);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_right_lh)
			ok(); // 选完照片
		else if (v.getId() == R.id.tv_album_ar)
			album();
		else if (v.getId() == R.id.tv_preview_ar)
			priview();
		else if (v.getId() == R.id.tv_camera_vc)
			catchPicture();
		else if (v.getId() == R.id.bv_back_lh)
			finish();
	}

	/** 拍照 */
	private void catchPicture() {
		CommonUtils.selectPicFromCamera(this);
		;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == CommonUtils.CAMERA_PHOTO && resultCode == RESULT_OK) {
			// selected.clear();
			// //--keep all
			// selected photos
			// tvNumber.setText("(0)");
			// //--keep all
			// selected photos
			// ///////////////////////////////////////////////////////////////////////////////////////////
			if (CommonUtils.cameraFile != null && CommonUtils.cameraFile.exists()) {
				String str_choosed_img = CommonUtils.cameraFile.getAbsolutePath();
				PhotoModel photoModel = new PhotoModel();
				photoModel.setChecked(true);
				photoModel.setOriginalPath(str_choosed_img);
				if (selected.size() >= MAX_IMAGE) {
//					Toast.makeText(this, String.format(getString(R.string.wifi_finder2), MAX_IMAGE),
//							Toast.LENGTH_SHORT).show();
					photoModel.setChecked(false);
					photoAdapter.notifyDataSetChanged();
				} else {
					if (!selected.contains(photoModel)) {
						selected.add(photoModel);
					}
				}
				ok();
			} else {
				CommonUtils.showToast(this, "获取照片失败，请重试");
			}
		}
	}

	/** 完成 */
	private void ok() {
		if (selected.size() > MAX_IMAGE) {
//			Toast.makeText(this, String.format(getString(R.string.wifi_finder2), MAX_IMAGE),
//					Toast.LENGTH_SHORT).show();
			return;
		}
		Intent data = new Intent();
		Bundle bundle = new Bundle();
		bundle.putSerializable("photos", selected);
		data.putExtras(bundle);
		setResult(RESULT_OK, data);
		finish();
	}

	/** 预览照片 */
	private void priview() {
		Bundle bundle = new Bundle();
		bundle.putSerializable("photos", selected);
		CommonUtils.launchActivity(this, PhotoPreviewActivity.class, bundle);
	}

	private void album() {
		if (layoutAlbum.getVisibility() == View.GONE) {
			popAlbum();
		} else {
			hideAlbum();
		}
	}

	/** 弹出相册列表 */
	private void popAlbum() {
		layoutAlbum.setVisibility(View.VISIBLE);
		new AnimationUtil(getApplicationContext(), R.anim.translate_up_current).setLinearInterpolator()
				.startAnimation(layoutAlbum);
	}

	/** 隐藏相册列表 */
	private void hideAlbum() {
		new AnimationUtil(getApplicationContext(), R.anim.translate_down).setLinearInterpolator()
				.startAnimation(layoutAlbum);
		layoutAlbum.setVisibility(View.GONE);
	}

	/** 清空选中的图片 */
	private void reset() {
		selected.clear();
		tvNumber.setText("(0)");
		tvPreview.setEnabled(false);
	}

	@Override
	/** 点击查看照片 */
	public void onItemClick(int position) {
		// Bundle bundle = new Bundle();
		// if (tvAlbum.getText().toString().equals(RECCENT_PHOTO))
		// bundle.putInt("position", position - 1);
		// else
		// bundle.putInt("position", position);
		// bundle.putString("album", tvAlbum.getText().toString());
		// CommonUtils.launchActivity(this, PhotoPreviewActivity.class, bundle);
	}

	@Override
	/** 照片选中状态改变之后 */
	public void onCheckedChanged(PhotoModel photoModel, CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
			if (!selected.contains(photoModel))
				selected.add(photoModel);
			tvPreview.setEnabled(true);
		} else {
			selected.remove(photoModel);
		}
		tvNumber.setText("(" + selected.size() + ")");

		if (selected.isEmpty()) {
			tvPreview.setEnabled(false);
			tvPreview.setText(getString(R.string.preview));
		}
	}

	@Override
	public void onBackPressed() {
		if (layoutAlbum.getVisibility() == View.VISIBLE) {
			hideAlbum();
		} else
			super.onBackPressed();
	}

	@Override
	/** 相册列表点击事件 */
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		AlbumModel current = (AlbumModel) parent.getItemAtPosition(position);
		for (int i = 0; i < parent.getCount(); i++) {
			AlbumModel album = (AlbumModel) parent.getItemAtPosition(i);
			if (i == position)
				album.setCheck(true);
			else
				album.setCheck(false);
		}
		albumAdapter.notifyDataSetChanged();
		hideAlbum();
		tvAlbum.setText(current.getName());
		// tvTitle.setText(current.getName());

		// 更新照片列表
		if (current.getName().equals(RECCENT_PHOTO))
			photoSelectorDomain.getReccent(reccentListener);
		else
			photoSelectorDomain.getAlbum(current.getName(), reccentListener); // 获取选中相册的照片
	}

	/** 获取本地图库照片回调 */
	public interface OnLocalReccentListener {
		public void onPhotoLoaded(List<PhotoModel> photos);
	}

	/** 获取本地相册信息回调 */
	public interface OnLocalAlbumListener {
		public void onAlbumLoaded(List<AlbumModel> albums);
	}

	private OnLocalAlbumListener albumListener = new OnLocalAlbumListener() {
		@Override
		public void onAlbumLoaded(List<AlbumModel> albums) {
			albumAdapter.update(albums);
		}
	};

	private OnLocalReccentListener reccentListener = new OnLocalReccentListener() {
		@Override
		public void onPhotoLoaded(List<PhotoModel> photos) {
			for (PhotoModel model : photos) {
				if (selected.contains(model)) {
					model.setChecked(true);
				}
			}
			photoAdapter.update(photos);
			gvPhotos.smoothScrollToPosition(0); // 滚动到顶端
			// reset(); //--keep selected photos

		}
	};

	@Override
	public void onClicked(PhotoModel photoModel) {
		// TODO Auto-generated method stub
		if (!selected.contains(photoModel))
			selected.add(photoModel);
		ok();
	}

	@Override
	public int totalSize() {
		// TODO Auto-generated method stub
		return selected.size();
	}

	@Override
	public boolean isContain(PhotoModel photoModel) {
		// TODO Auto-generated method stub
		return selected.contains(photoModel);
	}
}
