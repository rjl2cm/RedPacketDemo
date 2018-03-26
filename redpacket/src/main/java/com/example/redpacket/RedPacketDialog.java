package com.example.redpacket;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RedPacketDialog extends DialogFragment implements OnClickListener {
	
	// 红包整体布局
	private FrameLayout mRPContent;
	// 红包里的内容信纸
	private LinearLayout mLetter;
	// 红包的封条
	private ImageView mSeal;
	// 红包正面封皮
	private View mEnvelope;
	// 分享布局
	private LinearLayout mLayoutShare;
	// 紅包实体集
	private RedPacket mRedPacket;
	// 抢到红包之后,进行分享的时候
	private int mDetailsID;
	
	public RedPacketDialog() {
		super();
	}

	public RedPacketDialog(RedPacket redPacket) {
		super();
		this.mRedPacket = redPacket;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		return initDialog(new Dialog(getActivity(), R.style.dialog));
	}
	
	private Dialog initDialog(Dialog dialog) {
		/** 初始化Dialog的布局情况 */
		View view = getActivity().getLayoutInflater().inflate(R.layout.popupview_redpacket, null);
		initView(view);
		dialog.setContentView(view);
		dialog.setCanceledOnTouchOutside(false);
		return dialog;
	}
	
	private void initView(View view) {
		// 关闭按钮
		View cancel = view.findViewById(R.id.cancel);
		if (cancel != null) {
			cancel.setOnClickListener(this);
		}
		// 红包封条
		mSeal = (ImageView) view.findViewById(R.id.rp_seal);
		if (mSeal != null) {
			mSeal.setOnClickListener(this);
		}
		// 红包整体布局
		mRPContent = (FrameLayout) view.findViewById(R.id.flt_rp);
		// Title信息
//		TextView title = (TextView) view.findViewById(R.id.title);
//		title.setText(mRedPacket.getTitle());
//		TextView subTitle = (TextView) view.findViewById(R.id.subtitle);
//		subTitle.setText(mRedPacket.getSubTitle());
		// 红包信纸内容
		mLetter = (LinearLayout) view.findViewById(R.id.rp_letter);
		// 获得积分数字
		TextView credits = (TextView) view.findViewById(R.id.credits);
		credits.setText(mRedPacket.getScore());
		// 红包正封皮
		mEnvelope = view.findViewById(R.id.rp_envelope);
		// 分享布局
		mLayoutShare = (LinearLayout) view.findViewById(R.id.share_channel);
	}
	
	@Override
	public void onClick(final View v) {
		int id = v.getId();
		if (id == R.id.cancel){
            this.dismiss();
        }
        if (id == R.id.rp_seal){
            openRedPacket();
        }
        if (id == R.id.share_qq ||
                id == R.id.share_weibo ||
                id == R.id.share_weibo ||
                id == R.id.share_friendcircle ){
            shareRP(v);
        }
	}
	
	private void openRedPacket() {
		startAnimation();
//		String url = MyHttpClient.getAbsoluteUrlWithSign(MyHttpClient.FM_HBActivity_Insert);
//		RequestParams params = new RequestParams();
//		params.put("Score", mRedPacket.getScore());
//		params.put("Fromuid", MyApplicationUtil.getMyFeimangAccount().getToken());
//		params.put("HBActivityID", mRedPacket.getHBActivityID());
//		MyHttpClient.post(getActivity(), url, null, params, new MySimpleJsonHttpResponseHandler<BaseJson>(
//				BaseJson.class) {
//
//			@Override
//			public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData,
//					BaseJson errorResponse) {
//				super.onFailure(statusCode, headers, throwable, rawJsonData, errorResponse);
//			}
//
//			@Override
//			public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, BaseJson response) {
//				super.onSuccess(statusCode, headers, rawJsonResponse, response);
//				mDetailsID = response.getID();
//			}
//		});
	}
	
	// 打开红包动画
	private void startAnimation() {
		mSeal.animate().rotationXBy(180).setListener(new AnimatorListenerAdapter() {
			
			@Override
			public void onAnimationStart(Animator animation) {
				mSeal.setClickable(false);
				super.onAnimationStart(animation);
			}
			
			@Override
			public void onAnimationEnd(Animator animation) {
				mRPContent.bringChildToFront(mLetter);
				mRPContent.bringChildToFront(mEnvelope);
				mRPContent.requestLayout();
				mLetter.animate().translationYBy(-mLetter.getHeight() / 2).setDuration(500);
//				mLayoutShare.animate().alpha(1f).setDuration(1500);
//				initShareChannel(mLayoutShare);
				super.onAnimationEnd(animation);
			}
		}).setDuration(500);
	}
	
	private void initShareChannel(LinearLayout layout) {
		layout.findViewById(R.id.share_qq).setOnClickListener(this);
		layout.findViewById(R.id.share_weibo).setOnClickListener(this);
		layout.findViewById(R.id.share_weixin).setOnClickListener(this);
		layout.findViewById(R.id.share_friendcircle).setOnClickListener(this);
	}
	
	private void shareRP(final View v) {}
//		// 首先获取内容
//		String str = MyHttpClient.getAbsoluteUrlWithSign(MyHttpClient.AddBP_IntegralDetailsToHB);
//		UserStudy userStudy = MyApplicationUtil.getMyFeimangAccount().getUserStudyEntity().getUserStudy();
//		String url = String.format(str, userStudy.getUserID(), mDetailsID);
//		MyHttpClient.get(getActivity(), url, null, null, new MySimpleJsonHttpResponseHandler_Refresh<String>(
//				String.class) {
//
//			@Override
//			public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData,
//					String errorResponse) {
//				super.onFailure(statusCode, headers, throwable, rawJsonData, errorResponse);
//				final AlertDialog alertDialog = new AlertDialog(getActivity()).builder();
//				alertDialog.setMsg("分享过程被外星人劫持了,请重新点击获取!").setTitle("提示")
//						.setPositiveButton("知道了", new OnClickListener() {
//							@Override
//							public void onClick(View v) {
//								alertDialog.dismiss();
//							}
//						}).show();
//			}
//			final UMSocialService controller = UMServiceFactory.getUMSocialService("com.umeng.share");
//			@Override
//			public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, String response) {
//				// super.onSuccess(statusCode, headers, rawJsonResponse, response);
//				String shareUrl = response.replaceAll("\"", "");
//				 if (null == shareUrl) {//如果获取分享链接失败,直接返回
//					 return;
//				 }
//				SHARE_MEDIA shareMedia = null;
//				switch (v.getId()) {
//				case R.id.share_qq:// 设置QQ空间分享内容
//					String APP_ID = "1103590372";
//					String APP_KEY = "1xDxN3zapRlXOriY";
//					UMQQSsoHandler qqSsoHandler = new UMQQSsoHandler(getActivity(), APP_ID, APP_KEY);
//					qqSsoHandler.addToSocialSDK();
//					QQShareContent qqContent = new QQShareContent();
//					qqContent.setShareContent(mRedPacket.getShareContents());
//					qqContent.setTitle(mRedPacket.getShareTitle());
//					qqContent.setTargetUrl(shareUrl);
//					qqContent.setShareMedia(new UMImage(getActivity(), R.drawable.rp_share));
//					controller.setShareMedia(qqContent);
//					shareMedia = SHARE_MEDIA.QQ;
//					break;
//
//				case R.id.share_weibo:// 设置新浪分享内容
//					SinaShareContent sinaContent = new SinaShareContent();
//					sinaContent.setShareContent(mRedPacket.getShareContents());
//					sinaContent.setTitle(mRedPacket.getShareTitle());
//					sinaContent.setTargetUrl(shareUrl);
//					sinaContent.setShareMedia(new UMImage(getActivity(), R.drawable.rp_share));
//					controller.setShareMedia(sinaContent);
//					shareMedia = SHARE_MEDIA.SINA;
//					break;
//
//				case R.id.share_weixin:// 设置微信分享内容
//					String appId = "wxc02678f3928e2cf7";
//					String appSecret = "021cc533e546551370fb5843c7ab1e7a";
//					// 添加微信平台
//					UMWXHandler wxHandler = new UMWXHandler(getActivity(), appId, appSecret);
//					wxHandler.addToSocialSDK();
//					WeiXinShareContent weixinContent = new	WeiXinShareContent();
//					weixinContent.setShareContent(mRedPacket.getShareContents());
//					weixinContent.setTitle(mRedPacket.getShareTitle());
//					weixinContent.setTargetUrl(shareUrl);
//					weixinContent.setShareMedia(new UMImage(getActivity(), R.drawable.rp_share));
//					controller.setShareMedia(weixinContent);
//					shareMedia = SHARE_MEDIA.WEIXIN;
//					break;
//
//				case R.id.share_friendcircle:// 设置朋友圈分享的内容
//					String appId1 = "wxc02678f3928e2cf7";
//					String appSecret1 = "021cc533e546551370fb5843c7ab1e7a";
//					// 支持微信朋友圈
//					UMWXHandler wxCircleHandler = new UMWXHandler(getActivity(), appId1, appSecret1);
//					wxCircleHandler.setToCircle(true);
//					wxCircleHandler.addToSocialSDK();
//					CircleShareContent circleMedia = new CircleShareContent();
//					circleMedia.setShareContent(mRedPacket.getShareContents());
//					circleMedia.setTitle(mRedPacket.getShareTitle());
//					circleMedia.setTargetUrl(shareUrl);
//					circleMedia.setShareMedia(new UMImage(getActivity(), R.drawable.rp_share));
//					controller.setShareMedia(circleMedia);
//					shareMedia = SHARE_MEDIA.WEIXIN_CIRCLE;
//					break;
//				}
//				controller.directShare(getActivity(), shareMedia, new SnsPostListener() {
//
//					@Override
//					public void onStart() {
//						RedPacketDialog.this.dismiss();
//					}
//
//					@Override
//					public void onComplete(SHARE_MEDIA arg0, int arg1, SocializeEntity arg2) {}
//				});
//			}
//		});
//	}
}