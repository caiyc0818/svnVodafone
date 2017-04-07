package com.bcinfo.photoselector.ui;
/**
 * 
 * @author Aizaz AZ
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bcinfo.photoselector.domain.PhotoSelectorDomain;
import com.bcinfo.photoselector.model.PhotoModel;
import com.bcinfo.photoselector.ui.PhotoSelectorActivity.OnLocalReccentListener;
import com.bcinfo.photoselector.util.CommonUtils;

import android.os.Bundle;


public class PhotoPreviewActivity extends BasePhotoPreviewActivity implements OnLocalReccentListener {

	private PhotoSelectorDomain photoSelectorDomain;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		photoSelectorDomain = new PhotoSelectorDomain(getApplicationContext());

		init(getIntent().getExtras());
	}

	@SuppressWarnings("unchecked")
	protected void init(Bundle extras) {
		if (extras == null)
			return;

		if (extras.containsKey("photos")) { 
			photos = (ArrayList<PhotoModel>) extras.getSerializable("photos");
			current = extras.getInt("position", 0);
			updatePercent();
			bindData();
		} else if (extras.containsKey("album")) { 
			String albumName = extras.getString("album"); 
			this.current = extras.getInt("position");
			if (!CommonUtils.isNull(albumName) && albumName.equals(PhotoSelectorActivity.RECCENT_PHOTO)) {
				photoSelectorDomain.getReccent(this);
			} else {
				photoSelectorDomain.getAlbum(albumName, this);
			}
		}
	}

	@Override
	public void onPhotoLoaded(List<PhotoModel> photos) {
		this.photos = (ArrayList<PhotoModel>)photos;
		updatePercent();
		bindData();
	}

}
