package com.huawei.vodafone.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.MessageInfo;
import com.huawei.vodafone.bean.UserInfo;
import com.huawei.vodafone.ui.activity.PhotoActivity;
import com.huawei.vodafone.util.BitmapUtil;
import com.huawei.vodafone.util.DateUtil;
import com.huawei.vodafone.util.StringUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * @author hanweipeng
 * @date 2015-7-21 下午8:53:36
 */
public class MeaasgeListAdapter extends BaseAdapter {
	private Context mContext;

	// private String imageUrl;

	private LayoutInflater inflater;

	private List<MessageInfo> messageList;

	public MeaasgeListAdapter(Context mContext, List<MessageInfo> messageList) {
		this.mContext = mContext;
		this.messageList = messageList;
		inflater = LayoutInflater.from(mContext);
	}

	public void setMessageList(List<MessageInfo> messageList) {
		this.messageList = messageList;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return messageList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return messageList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		String senderId = messageList.get(position).getSender().getUserId();
		if (senderId.equals("1")) {
			// 自己发的消息
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			String senderId = messageList.get(position).getSender().getUserId();
			if (getItemViewType(position) == 1) {// 别人发的非产品消息
				convertView = inflater.inflate(R.layout.left_chat_item, null);
				viewHolder.messageContent = (TextView) convertView
						.findViewById(R.id.message_content);
				viewHolder.failStatus = (ImageView) convertView
						.findViewById(R.id.fail_icon);
				viewHolder.sendName = (TextView) convertView
						.findViewById(R.id.send_name);
			} else if (getItemViewType(position) == 0) {
				// 自己发的消息
				convertView = inflater.inflate(R.layout.right_chat_item, null);
				viewHolder.messageContent = (TextView) convertView
						.findViewById(R.id.message_content);
				viewHolder.failStatus = (ImageView) convertView
						.findViewById(R.id.fail_icon);
				viewHolder.sendName = (TextView) convertView
						.findViewById(R.id.send_name);
			}
			viewHolder.messageTime = (TextView) convertView
					.findViewById(R.id.message_time);
			viewHolder.senderIcon = (ImageView) convertView
					.findViewById(R.id.send_icon);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		final MessageInfo messageInfo = messageList.get(position);

		viewHolder.sendName.setText(StringUtils.isEmpty(messageInfo.getSender()
				.getNickname()) ? "" : messageInfo.getSender().getNickname());
		// if (viewHolder.sendName.getText().length() > 5) {
		//
		// viewHolder.sendName.setText((viewHolder.sendName.getText() +
		// "").substring(0, 4) + "...");
		// }
		// viewHolder.messageTime.setText(DateUtil.getFormateDate1(messageInfo.getCreatetime()));
		String pattern = messageList.get(position).getPattern();
		// if (pattern != null && pattern.equals("notice")) {
		// String formateStr = "yyyy-MM-dd";
		// viewHolder.messageTime.setText(DateUtil.formateTime(messageInfo.getCreatetime()));
		// } else {
		// viewHolder.messageTime.setText(DateUtil.formateTime(messageInfo.getCreatetime()));
		// }
		viewHolder.messageTime.setText(DateUtil.formateTime(messageInfo
				.getCreatetime()));

		// if (!StringUtils.isEmpty(messageInfo.getSender().getAvatar())) {
		// if (messageInfo.getSender().getAvatar().equals("-1"))
		// viewHolder.senderIcon.setVisibility(View.GONE);
		// else {
		// viewHolder.senderIcon.setVisibility(View.VISIBLE);
		// ImageLoader.getInstance().displayImage(Urls.imgHost +
		// messageInfo.getSender().getAvatar(),
		// viewHolder.senderIcon,
		// AppConfig.options(R.drawable.user_defult_photo));
		// }
		// }
		if (getItemViewType(position) == 0) {
			viewHolder.senderIcon.setImageBitmap(UserInfo.getIcon(mContext));
		}
		if (getItemViewType(position) == 0 || getItemViewType(position) == 1) {
			viewHolder.failStatus.setVisibility(View.GONE);
			if (messageInfo.getSendStatus().equals("1")) {
				viewHolder.failStatus.setVisibility(View.VISIBLE);
				viewHolder.failStatus.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub

					}
				});
			}
		}
		if (!StringUtils.isEmpty(messageInfo.getImage())
				|| !StringUtils.isEmpty(messageInfo.getLocalImage())) {
			// imageUrl =messageInfo.getImage();
			Bitmap bitmap = BitmapFactory.decodeResource(
					mContext.getResources(), R.drawable.user_defult_photo);
			SpannableString spannableString = addPicture(bitmap, "i");
			viewHolder.messageContent.setText(spannableString);
			ImageSize imageSize = new ImageSize(200, 200);
			if (!StringUtils.isEmpty(messageInfo.getLocalImage())) {
				setImg("file:///" + messageInfo.getLocalImage(), imageSize,
						viewHolder.messageContent);
			} else {
				// if (!StringUtils.isEmpty(messageInfo.getImage())) {
				// setImg(Urls.imgHost + messageInfo.getImage(), imageSize,
				// viewHolder.messageContent);
				// }
			}
		}

		if (StringUtils.isEmpty(messageInfo.getLocalImage())
				&& StringUtils.isEmpty(messageInfo.getImage())
				&& getItemViewType(position) != 2) {
			viewHolder.messageContent.setText("");
			viewHolder.messageContent.setText(messageInfo.getContent());
		}
		return convertView;
	}

	private void setImg(String url, ImageSize imageSize, final TextView textView) {

		ImageLoader.getInstance().loadImage(url, imageSize,
				new ImageLoadingListener() {

					@Override
					public void onLoadingStarted(String imageUri, View view) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onLoadingFailed(String imageUri, View view,
							FailReason failReason) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onLoadingComplete(final String imageUri,
							View view, Bitmap loadedImage) {
						// TODO Auto-generated method stub
						// Bitmap bitmap =
						// ImageLoader.getInstance().loadImageSync(messageInfo.getImgUrl(),
						// imageSize);
						Bitmap newBitmap = null;
						if (imageUri.contains("file:///")) {
							int angle = BitmapUtil.getBitmapDegree(imageUri
									.substring("file:///".length()));
							newBitmap = BitmapUtil.rotaingImageView(angle,
									loadedImage);
						} else {
							newBitmap = loadedImage;
						}
						SpannableString spannableString = addPicture(newBitmap,
								"i");
						textView.setText(spannableString);
						textView.setOnClickListener(new OnClickListener() {

							@Override
							public void onClick(View v) {
								ArrayList<String> photoUrls = new ArrayList<String>();
								photoUrls.add(imageUri);
								// TODO Auto-generated method stub
								Intent intent = new Intent(mContext,
										PhotoActivity.class);
								intent.putExtra("photos", photoUrls);
								mContext.startActivity(intent);
							}
						});
					}

					@Override
					public void onLoadingCancelled(String imageUri, View view) {
						// TODO Auto-generated method stub

					}
				});

	}

	/**
	 * 添加图片
	 * 
	 * @param context
	 * @param bmpUrl
	 *            图片路径
	 * @param spannableString
	 * @return
	 */
	private SpannableString addPicture(Bitmap bitmap, String spannableString) {
		if (TextUtils.isEmpty(spannableString)) {
			return null;
		}

		ImageSpan imageSpan = new ImageSpan(mContext, bitmap);
		SpannableString spannable = new SpannableString(spannableString);
		spannable.setSpan(imageSpan, 0, spannableString.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		return spannable;
	}

	static class ViewHolder {
		public TextView messageTime;

		public TextView messageContent;

		public ImageView senderIcon;

		public ImageView failStatus;

		public ImageView productPost;

		public TextView productTitle;

		public TextView productTags;

		public TextView productDays;

		public TextView productDistance;

		public TextView sendName;
		public RelativeLayout productLayout;
	}

	public interface ReSendMessageInterface {
		public void reSend(int position);
	}
}
