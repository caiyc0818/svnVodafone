//package com.huawei.vodafone.ui.myview.dialog;
//
//import android.app.Activity;
//import android.app.Dialog;
//import android.content.Context;
//import android.os.Bundle;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.WindowManager.LayoutParams;
//import android.widget.LinearLayout;
//import android.widget.Toast;
//
//
//import com.huawei.vodafone.R;
//import com.huawei.vodafone.util.StringUtils;
//import com.umeng.socialize.bean.SHARE_MEDIA;
//import com.umeng.socialize.bean.SocializeEntity;
//import com.umeng.socialize.controller.UMServiceFactory;
//import com.umeng.socialize.controller.UMSocialService;
//import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
//import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
//import com.umeng.socialize.exception.SocializeException;
//import com.umeng.socialize.handler.QZoneSsoHandler;
//import com.umeng.socialize.handler.UMQQSsoHandler;
//import com.umeng.socialize.handler.UMWXHandler;
//import com.umeng.socialize.media.QQShareContent;
//import com.umeng.socialize.media.QZoneShareContent;
//import com.umeng.socialize.media.SinaShareContent;
//import com.umeng.socialize.media.UMImage;
//import com.umeng.socialize.media.WeiXinShareContent;
//
//import com.umeng.socialize.utils.OauthHelper;
//
//
///**
// * @author weiCh
// * @param context
// * @param imageurl
// *            显示图片地址
// * @param text
// *            显示主体文本
// * @param title
// *            显示标题
// * @param url
// *            显示连接地址
// */
//public class ShareSelectDialog extends Dialog {
//	private Context mContext;
//
//	private LayoutInflater inflater;
//
//	private LayoutParams lp;
//
//	View mShareButton;
//
//	public UMSocialService mController = UMServiceFactory.getUMSocialService("myshare");
//
//	private String imageurl;
//
//	private String text;
//
//	private String title;
//
//	private String url;
//
//	private boolean imageurlboolean = false;
//
//	private boolean urlboolean = false;
//
//	private String nickName;
//
//	public ShareSelectDialog(Context context, String imageurl, String text, String title, String url, String shareUrl,String nickName) {
//		super(context, R.style.Dialog);
//		com.umeng.socialize.utils.Log.LOG = true;
//		this.mContext = context;
//		if (StringUtils.isEmpty(imageurl)) {
//			imageurlboolean = false;
//		} else {
//			this.imageurl = Urls.imgHost + imageurl;
//			imageurlboolean = true;
//		}
//		if(StringUtils.verifyIsPhone(text)){
//			text = StringUtils.getSecretStr(text);
//		}
//		this.text = StringUtils.isEmpty(text) ? " " : text;
//		if(StringUtils.verifyIsPhone(title)){
//			title = StringUtils.getSecretStr(title);
//		}
//		this.title = StringUtils.isEmpty(title) ? " " : title;
//		if (StringUtils.isEmpty(url)) {
//			urlboolean = false;
//		} else {
//			this.url = shareUrl + url + ".html";
//			if(shareUrl.equals(Urls.ShareUrlOfProduct)&&!StringUtils.isEmpty(PreferenceUtil.getUserId())){
//				this.url = shareUrl + url +"-"+PreferenceUtil.getUserId()+ ".html";
//			}
//			if(shareUrl.equals(Urls.ShareUrlOfUser)&&!StringUtils.isEmpty(PreferenceUtil.getUserId())){
//				this.url = shareUrl + url +"-"+PreferenceUtil.getUserId()+ ".html";
//			}
//			urlboolean = true;
//		}
//		if(StringUtils.verifyIsPhone(nickName)){
//			nickName = StringUtils.getSecretStr(nickName);
//		}
//		this.nickName = StringUtils.isEmpty(nickName)?" ":nickName;
//		inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//		View layout = inflater.inflate(R.layout.share_select_dialog, null);
//		setContentView(layout);
//		// 设置window属性
//		lp = getWindow().getAttributes();
//		lp.width = LayoutParams.MATCH_PARENT;
//		lp.height = LayoutParams.WRAP_CONTENT;
//		lp.gravity = Gravity.BOTTOM;
//		lp.dimAmount = (float) 0.75; // 去背景遮盖
//		lp.alpha = 1.0f;
//		getWindow().setAttributes(lp);
//		LinearLayout SocializeWechatLayout = (LinearLayout) findViewById(R.id.socialize_wechat_layout);
//		LinearLayout SocializeWxcircleLayout = (LinearLayout) findViewById(R.id.socialize_wxcircle_layout);
//		LinearLayout SocializeQqLayout = (LinearLayout) findViewById(R.id.socialize_qq_layout);
//		LinearLayout SocializeSinaLayout = (LinearLayout) findViewById(R.id.socialize_sina_layout);
//		LinearLayout SocializeTxLayout = (LinearLayout) findViewById(R.id.socialize_tx_layout);
//		LinearLayout SocializeRenrenLayout = (LinearLayout) findViewById(R.id.socialize_renren_layout);
//		LinearLayout SocializeSmsLayout = (LinearLayout) findViewById(R.id.socialize_sms_layout);
//		LinearLayout SocializeGmailLayout = (LinearLayout) findViewById(R.id.socialize_gmail_layout);
//		LinearLayout SocializeQzoneLayout = (LinearLayout) findViewById(R.id.socialize_qzone_layout);
//		LinearLayout SocializeLinkLayout = (LinearLayout) findViewById(R.id.socialize_link_layout);
//		SocializeWechatLayout.setOnClickListener(mOnCancelListener);
//		SocializeWxcircleLayout.setOnClickListener(mOnCancelListener);
//		SocializeQqLayout.setOnClickListener(mOnCancelListener);
//		SocializeSinaLayout.setOnClickListener(mOnCancelListener);
//		SocializeTxLayout.setOnClickListener(mOnCancelListener);
//		SocializeRenrenLayout.setOnClickListener(mOnCancelListener);
//		SocializeSmsLayout.setOnClickListener(mOnCancelListener);
//		SocializeGmailLayout.setOnClickListener(mOnCancelListener);
//		SocializeQzoneLayout.setOnClickListener(mOnCancelListener);
//		SocializeLinkLayout.setOnClickListener(mOnCancelListener);
//
//	}
//
//	public ShareSelectDialog(Context context, String imageurl, String text, String title, String url, String shareUrl,String nickName,boolean check) {
//		super(context, R.style.Dialog);
//		com.umeng.socialize.utils.Log.LOG = true;
//		this.mContext = context;
//		if (StringUtils.isEmpty(imageurl)) {
//			imageurlboolean = false;
//		} else {
//			this.imageurl = Urls.imgHost + imageurl;
//			imageurlboolean = true;
//		}
//		if(StringUtils.verifyIsPhone(text)){
//			text = StringUtils.getSecretStr(text);
//		}
//		this.text = StringUtils.isEmpty(text) ? " " : text;
//		if(StringUtils.verifyIsPhone(title)){
//			title = StringUtils.getSecretStr(title);
//		}
//		this.title = StringUtils.isEmpty(title) ? " " : title;
//		if (StringUtils.isEmpty(shareUrl)) {
//			urlboolean = false;
//		} else {
//			if(check)
//				this.url = shareUrl;
//			else{
//			this.url = shareUrl + url + ".html";
//			if(shareUrl.equals(Urls.ShareUrlOfProduct)&&!StringUtils.isEmpty(PreferenceUtil.getUserId())){
//				this.url = shareUrl + url +"-"+PreferenceUtil.getUserId()+ ".html";
//			}
//			}
//			urlboolean = true;
//		}
//		if(StringUtils.verifyIsPhone(nickName)){
//			nickName = StringUtils.getSecretStr(nickName);
//		}
//		this.nickName = StringUtils.isEmpty(nickName)?" ":nickName;
//		inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//		View layout = inflater.inflate(R.layout.share_select_dialog, null);
//		setContentView(layout);
//		// 设置window属性
//		lp = getWindow().getAttributes();
//		lp.width = LayoutParams.MATCH_PARENT;
//		lp.height = LayoutParams.WRAP_CONTENT;
//		lp.gravity = Gravity.BOTTOM;
//		lp.dimAmount = (float) 0.75; // 去背景遮盖
//		lp.alpha = 1.0f;
//		getWindow().setAttributes(lp);
//		LinearLayout SocializeWechatLayout = (LinearLayout) findViewById(R.id.socialize_wechat_layout);
//		LinearLayout SocializeWxcircleLayout = (LinearLayout) findViewById(R.id.socialize_wxcircle_layout);
//		LinearLayout SocializeQqLayout = (LinearLayout) findViewById(R.id.socialize_qq_layout);
//		LinearLayout SocializeSinaLayout = (LinearLayout) findViewById(R.id.socialize_sina_layout);
//		LinearLayout SocializeTxLayout = (LinearLayout) findViewById(R.id.socialize_tx_layout);
//		LinearLayout SocializeRenrenLayout = (LinearLayout) findViewById(R.id.socialize_renren_layout);
//		LinearLayout SocializeSmsLayout = (LinearLayout) findViewById(R.id.socialize_sms_layout);
//		LinearLayout SocializeGmailLayout = (LinearLayout) findViewById(R.id.socialize_gmail_layout);
//		LinearLayout SocializeQzoneLayout = (LinearLayout) findViewById(R.id.socialize_qzone_layout);
//		LinearLayout SocializeLinkLayout = (LinearLayout) findViewById(R.id.socialize_link_layout);
//		SocializeWechatLayout.setOnClickListener(mOnCancelListener);
//		SocializeWxcircleLayout.setOnClickListener(mOnCancelListener);
//		SocializeQqLayout.setOnClickListener(mOnCancelListener);
//		SocializeSinaLayout.setOnClickListener(mOnCancelListener);
//		SocializeTxLayout.setOnClickListener(mOnCancelListener);
//		SocializeRenrenLayout.setOnClickListener(mOnCancelListener);
//		SocializeSmsLayout.setOnClickListener(mOnCancelListener);
//		SocializeGmailLayout.setOnClickListener(mOnCancelListener);
//		SocializeQzoneLayout.setOnClickListener(mOnCancelListener);
//		SocializeLinkLayout.setOnClickListener(mOnCancelListener);
//
//	}
//
//	/**
//	 * 根据不同的平台设置不同的分享内容</br>
//	 */
//	private void setShareContent(int num) {
//
//		UMImage urlImage = new UMImage((Activity) mContext, imageurl);
//
//		switch (num) {
//		case 1:// 设置微信
//			WeiXinShareContent weixinContent = new WeiXinShareContent();
//			weixinContent.setShareContent(text);
////			weixinContent.setTitle(title);
//			if (imageurlboolean)
//				weixinContent.setShareImage(urlImage);
//			if (urlboolean)
//				weixinContent.setTargetUrl(url);
//			mController.setShareMedia(weixinContent);
//			break;
//		case 2: // 设置朋友圈分享的内容
//
//			CircleShareContent circleMedia = new CircleShareContent();
//			circleMedia.setShareContent(text);
//			circleMedia.setTitle(title);
//			if (imageurlboolean)
//				circleMedia.setShareMedia(urlImage);
//			if (urlboolean)
//				circleMedia.setTargetUrl(url);
//			mController.setShareMedia(circleMedia);
//			break;
//		case 3:// qq分享
//
//			QQShareContent qqShareContent = new QQShareContent();
//			qqShareContent.setShareContent(text);
//			qqShareContent.setTitle(title);
//			if (imageurlboolean)
//				qqShareContent.setShareMedia(urlImage);
//			if (urlboolean)
//				qqShareContent.setTargetUrl(url);
//			mController.setShareMedia(qqShareContent);
//			break;
//		case 4:// 新浪微博
//			SinaShareContent sinaContent = new SinaShareContent();
//			String txt = "";
//			String name = nickName;
//			if(StringUtils.verifyIsPhone(name)){
//				name = StringUtils.getSecretStr(name);
//			}
//			text = name+" "+url;
//			if (text.length() > 120) {
//				txt = text.substring(0, 120) + "...";
//			} else {
//				txt = text;
//			}
//			sinaContent.setShareContent(txt);
//			sinaContent.setTitle(title);
//			if (imageurlboolean)
//				sinaContent.setShareMedia(urlImage);
//			if (urlboolean)
//				sinaContent.setTargetUrl(url);
//			mController.setShareMedia(sinaContent);
//			break;
//		case 5:// 设置QQ空间分享内容
//
//			QZoneShareContent qzone = new QZoneShareContent();
//			qzone.setShareContent(text);
//			qzone.setTitle(title);
//			if (imageurlboolean)
//				qzone.setShareMedia(urlImage);
//			if (urlboolean)
//				qzone.setTargetUrl(url);
//			mController.setShareMedia(qzone);
//			break;
//		default:
//			break;
//		}
//
//		// 本地图片
//		// UMImage localImage = new UMImage((Activity)mContext,
//		// R.drawable.ic_launcher);
//		// 网上图片
//		// UMImage urlImage = new UMImage((Activity)mContext,
//		// "http://www.umeng.com/images/pic/social/integrated_3.png");
//		// UMImage resImage = new UMImage((Activity)mContext, R.drawable.icon);
//
//		// // 视频分享
//		// UMVideo video = new UMVideo(
//		// "http://v.youku.com/v_show/id_XNTc0ODM4OTM2.html");
//		// //
//		// vedio.setThumb("http://www.umeng.com/images/pic/home/social/img-1.png");
//		// video.setTitle("友盟社会化组件视频");
//		// video.setThumb(urlImage);
//		// //音乐分享
//		// UMusic uMusic = new UMusic(
//		// "http://music.huoxing.com/upload/20130330/1364651263157_1085.mp3");
//		// uMusic.setAuthor("umeng");
//		// uMusic.setTitle("天籁之音");
//		// // uMusic.setThumb(urlImage);
//		// uMusic.setThumb("http://www.umeng.com/images/pic/social/chart_1.png");
//
//		// // 设置renren分享内容
//		// RenrenShareContent renrenShareContent = new RenrenShareContent();
//		// renrenShareContent.setShareContent("人人分享内容");
//		// UMImage image = new UMImage((Activity)mContext,
//		// BitmapFactory.decodeResource(getResources(), R.drawable.device));
//		// image.setTitle("thumb title");
//		// image.setThumb("http://www.umeng.com/images/pic/social/integrated_3.png");
//		// renrenShareContent.setShareImage(image);
//		// renrenShareContent.setAppWebSite("http://www.umeng.com/social");
//		// mController.setShareMedia(renrenShareContent);
//		//
//		// UMImage qzoneImage = new UMImage((Activity)mContext,
//		// "http://www.umeng.com/images/pic/social/integrated_3.png");
//		// qzoneImage
//		// .setTargetUrl("http://www.umeng.com/images/pic/social/integrated_3.png");
//		// //腾讯微博
//		// TencentWbShareContent tencent = new TencentWbShareContent();
//		// tencent.setShareContent("来自友盟社会化组件（SDK）让移动应用快速整合社交分享功能-腾讯微博。http://www.umeng.com/social");
//		// // 设置tencent分享内容
//		// mController.setShareMedia(tencent);
//		//
//		// // 设置邮件分享内容， 如果需要分享图片则只支持本地图片
//		// MailShareContent mail = new MailShareContent(localImage);
//		// mail.setTitle("share form umeng social sdk");
//		// mail.setShareContent("来自友盟社会化组件（SDK）让移动应用快速整合社交分享功能-email。http://www.umeng.com/social");
//		// // 设置tencent分享内容
//		// mController.setShareMedia(mail);
//		//
//		// // 设置短信分享内容
//		// SmsShareContent sms = new SmsShareContent();
//		// sms.setShareContent("来自友盟社会化组件（SDK）让移动应用快速整合社交分享功能-短信。http://www.umeng.com/social");
//		// // sms.setShareImage(urlImage);
//		// mController.setShareMedia(sms);
//
//	}
//
//	View.OnClickListener mOnCancelListener = new View.OnClickListener() {
//		@Override
//		public void onClick(View v) {
//
//			// 调用直接分享
//			// mController.directShare((Activity)mContext,
//			// SHARE_MEDIA.QQ,mShareListener);
//			// 调用直接分享, 但是在分享前用户可以编辑要分享的内容
//			// mController.postShare((Activity)mContext, SHARE_MEDIA.QQ,
//			// mShareListener);
//			switch (v.getId()) {
//			case R.id.socialize_wechat_layout:// 添加微信平台
//				UMWXHandler wxHandler = new UMWXHandler((Activity) mContext, "wx513e3e254518495d",
//						"2459b944473b01633c1f18716c58d3ed");
//				wxHandler.addToSocialSDK();
//				setShareContent(1);
//				mController.postShare((Activity) mContext, SHARE_MEDIA.WEIXIN, mShareListener);
//				cancel();
//				break;
//			case R.id.socialize_wxcircle_layout:// 添加微信朋友圈
//				UMWXHandler wxCircleHandler = new UMWXHandler((Activity) mContext, "wx513e3e254518495d",
//						"2459b944473b01633c1f18716c58d3ed");
//				wxCircleHandler.setToCircle(true);
//				wxCircleHandler.addToSocialSDK();
//				setShareContent(2);
//				mController.postShare((Activity) mContext, SHARE_MEDIA.WEIXIN_CIRCLE, mShareListener);
//				cancel();
//				break;
//			case R.id.socialize_qq_layout:// 添加QQ平台
//				UMQQSsoHandler qqHandler = new UMQQSsoHandler((Activity) mContext, "1104713805",
//						"55acba9267e58ef8c0001108");
//				qqHandler.addToSocialSDK();
//				setShareContent(3);
//				mController.directShare((Activity) mContext, SHARE_MEDIA.QQ, mShareListener);
//				cancel();
//				break;
//			case R.id.socialize_sina_layout:// 新浪微博
//				mController = UMServiceFactory.getUMSocialService("com.umeng.login");
//				//mController.getConfig().setSsoHandler(new SinaSsoHandler());
//				setShareContent(4);
//				boolean flag = OauthHelper.isAuthenticated(mContext, SHARE_MEDIA.SINA);
//				if (flag) {
//					mController.directShare((Activity) mContext, SHARE_MEDIA.SINA, mShareListener);
//					cancel();
//				} else {
//					mController.doOauthVerify((Activity) mContext, SHARE_MEDIA.SINA, new UMAuthListener() {
//
//						@Override
//						public void onStart(SHARE_MEDIA arg0) {
//							Toast.makeText((Activity) mContext, "授权开始", Toast.LENGTH_SHORT).show();
//
//						}
//
//						@Override
//						public void onError(SocializeException arg0, SHARE_MEDIA arg1) {
//							Toast.makeText((Activity) mContext, "授权错误", Toast.LENGTH_SHORT).show();
//
//						}
//
//						@Override
//						public void onComplete(Bundle arg0, SHARE_MEDIA arg1) {
//							Toast.makeText(mContext, "授权完成", Toast.LENGTH_SHORT).show();
//							mController.directShare((Activity) mContext, SHARE_MEDIA.SINA, mShareListener);
//							cancel();
//						}
//
//						@Override
//						public void onCancel(SHARE_MEDIA arg0) {
//							// TODO Auto-generated method stub
//
//						}
//					});
//				}
//
//				break;
//			case R.id.socialize_qzone_layout:// 添加QQ空间平台
//				QZoneSsoHandler qzoneHandler = new QZoneSsoHandler((Activity) mContext, "1104713805",
//						"55acba9267e58ef8c0001108");
//				qzoneHandler.addToSocialSDK();
//				setShareContent(5);
//				mController.directShare((Activity) mContext, SHARE_MEDIA.QZONE, mShareListener);
//				cancel();
//				break;
//			case R.id.socialize_tx_layout:// 腾讯微博
//				mController.getConfig().setSsoHandler(new TencentWBSsoHandler());
//
//				mController.directShare((Activity) mContext, SHARE_MEDIA.TENCENT, mShareListener);
//				cancel();
//				break;
//			case R.id.socialize_renren_layout:// 添加人人网SSO授权功能
////				RenrenSsoHandler renrenSsoHandler = new RenrenSsoHandler((Activity) mContext, "201874",
////						"28401c0964f04a72a14c812d6132fcef", "3bf66e42db1e4fa9829b955cc300b737");
////				renrenSsoHandler.addToSocialSDK();
////
////				// 人人网分享时，如果不设置website，点击¨应用名称¨或者¨图片¨将跳转到人人网主页；如果设置website将跳转到此website的页面
////				mController.setAppWebSite(SHARE_MEDIA.RENREN, "http://www.umeng.com/social");
////
////				mController.directShare((Activity) mContext, SHARE_MEDIA.RENREN, mShareListener);
////				cancel();
//				break;
//			case R.id.socialize_sms_layout:// 添加短信
//				SmsHandler smsHandler = new SmsHandler();
//				smsHandler.addToSocialSDK();
//
//				mController.directShare((Activity) mContext, SHARE_MEDIA.SMS, mShareListener);
//				cancel();
//				break;
//			case R.id.socialize_gmail_layout:// 添加email
//				EmailHandler emailHandler = new EmailHandler();
//				emailHandler.addToSocialSDK();
//
//				mController.directShare((Activity) mContext, SHARE_MEDIA.EMAIL, mShareListener);
//				cancel();
//				break;
//			case R.id.socialize_link_layout:
//				cancel();
//				break;
//			default:
//				break;
//			}
//		}
//	};
//
//	/**
//	 * 分享监听器
//	 */
//	SnsPostListener mShareListener = new SnsPostListener() {
//
//		@Override
//		public void onStart() {
//			// Toast.makeText((Activity)mContext, "开始分享.",
//			// Toast.LENGTH_SHORT).show();
//		}
//
//		@Override
//		public void onComplete(SHARE_MEDIA platform, int stCode, SocializeEntity entity) {
//			if (stCode == 200) {
//				// Toast.makeText((Activity)mContext, "分享成功",
//				// Toast.LENGTH_SHORT).show();
//			} else {
//				// Toast.makeText((Activity)mContext, "分享失败 : error code : " +
//				// stCode, Toast.LENGTH_SHORT).show();
//			}
//		}
//	};
//
//}
