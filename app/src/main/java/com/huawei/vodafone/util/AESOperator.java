package com.huawei.vodafone.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

/**
 * AES 是一种可逆加密算法，对用户的敏感信息加密处理 对原始数据进行AES加密后，在进行Base64编码转化；
 */
public class AESOperator {

	/*
	 * 加密用的Key 可以用26个字母和数字组成 此处使用AES-128-CBC加密模式，key需要为16位。
	 */
	public static String sKey = "g6UjmVe#/rTdfrCo";

	public static String ivParameter = "$cf@;4NA=wO?8SJ*";

	private static AESOperator instance = null;

	private AESOperator() {

	}

	public static AESOperator getInstance() {
		if (instance == null)
			instance = new AESOperator();
		return instance;
	}

	public static String Encrypt(String encData, String secretKey, String vector)
			throws Exception {

		if (secretKey == null) {
			return null;
		}
		if (secretKey.length() != 16) {
			return null;
		}
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] raw = secretKey.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		IvParameterSpec iv = new IvParameterSpec(vector.getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
		byte[] encrypted = cipher.doFinal(encData.getBytes("utf-8"));
		return new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码。
	}

	// 加密
	public String encrypt(String sSrc) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] raw = sKey.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
		byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
		return new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码。
	}

	// 解密
	public String decrypt(String sSrc) throws Exception {
		try {
			byte[] raw = sKey.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);// 先用base64解密
			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original, "utf-8");
			return originalString;
		} catch (Exception ex) {
			return null;
		}
	}

	public static String decrypt(String sSrc, String key, String ivs)
			throws Exception {
		try {
			byte[] raw = key.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec iv = new IvParameterSpec(ivs.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);// 先用base64解密
			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original, "utf-8");
			return originalString;
		} catch (Exception ex) {
			return null;
		}
	}

	public static String encodeBytes(byte[] bytes) {
		StringBuffer strBuf = new StringBuffer();

		for (int i = 0; i < bytes.length; i++) {
			strBuf.append((char) (((bytes[i] >> 4) & 0xF) + ((int) 'a')));
			strBuf.append((char) (((bytes[i]) & 0xF) + ((int) 'a')));
		}

		return strBuf.toString();
	}

	public static void main(String[] args) throws Exception {
		// 需要加密的字串
		// String cSrc =
		// "{\"request_no\":\"1001\",\"service_code\":\"FS0001\",\"contract_id\":\"100002\",\"order_id\":\"0\",\"phone_id\":\"13913996922\",\"plat_offer_id\":\"100094\",\"channel_id\":\"1\",\"activity_id\":\"100045\"}";
		String cSrc = "{\"MessageHeader\":{\"commandId\":\"queryArticleByCode\",\"sourcecode\":\"smkApp\",\"timestamp\":\"2014-05-09 10:19:25\",\"messageLength\":\"20\",\"integrationId\":\"smkApp201508290438174210\"},\"MessageBody\":{\"reqInfo\":{\"license\":\"123123123123\",\"msgName\":\"queryArticleByCode\",\"req_device\":\"2\",\"req_language\":\"1\",\"req_time\":\"2014-05-09 10:19:25\" },\"columnCode\":\"MSGG\",\"pageNum\":\"1\",\"pageSize\":\"4\"}} ";
		// 加密
		long lStart = System.currentTimeMillis();
		// String enString = AESOperator.getInstance().encrypt(cSrc);
		// System.out.println("加密后的字串是：" + enString);

		long lUseTime = System.currentTimeMillis() - lStart;
		// System.out.println("加密耗时：" + lUseTime + "毫秒");
		// 解密
		lStart = System.currentTimeMillis();
		String a = "VtWMZO36cxAznNSaHlBlhVRX5sSfkFpXpQzzWektB01J3OZ/mRj3ZxVqVpCT7Uv4Yoh8NE69kNRtHYI/ieZD09gtzN0awob49LI5J/1rPZK+QFgaNToE7tQmu8gWoQPiIaoDMWne2/u4W5WW43glg4uWKXMZRrwu4ojb21jwFygqrLD4n0PAwDFbkWR2SxplVmZwYtZuOx0+eT80ARuR3fIkVYrlPF6h2xz2Fk8y1DeEbm3mhmcwTmv7zU+SgMuUe1Eo4dgtvtiV21YueChtGYp9th3rYb0a82z4icR4dM5Iv3lqbeDCL4Byu9WtVv28j3RgaSvy52NNNMaC1X58DUC21w/GTgoxqi/rsSTeYVi8zvtunR23JhFzXfMlxtJR7vdQVqczBykSTyDeegw7iu+o4Cmdk6ww5i4f6YyrzarD7976Vj+4yzIW7c1NQtGIOM1bRlkHin49Tn/C/H6KCZcHMSM2gFCSlk9/WvAqAp4pi4vW5f/i2azaztejvrjEROI62Odf/Mij1sP5S1dd97VaR2mQfhhzbtFnkajKaVR+heP8z1wBo5q3Vl77F2712A3pTqKgANQFn3pV1hnZoHRFZ2DBpTmAYX0YSg5KYg8ka7Qft153MoCyC3ugEEDS7DwrXUeln6AjxNnkCaEvGyHHFiJRyYBu9JIt1zeeN4PSxk3y8txEk9xErclzACzzHod0ea/+pT2Bg/3Yya695j06/9PYbATAnLi0kgMxEdjN6TvDtEyC7cFrVqMLZ4AO3HCprtWAuXbZK3/TcinX8rPFrg/jhgVCligdBgiwyuLVmcSHqQQ/wZi2JSvElnTB9dYCdCCxlpVVPH7CDTig4aoO5b6gDnPROp/TuYNSD10K/n7bvYMxsD7899O6FmndNGKRqZHa6Hs/zaMVeUj80/w++nk1oKBhjqkTix/1uV662U9CfD9pwZhUxvHUbiMQvgdks5HhME9UyJdpvZ5jdLg8OpFFXipdiLGUQIiAQYQAEQ3CJdKiq/EqBqJvNeOmb2MucTBA9yfBvesxKNXtLgKMJobVOydSZK3GfJ3hjc0fWDsHx+bVq5w/uQ2KEHJCyNr+IhCQndSAZV09W6yx2f0VGXfbalC04fDK/AqFmf0D83UHlL3irUZoqf3257SBpKtYDVxz/zKEjmXxw5k85ZX9ZQzBxhc4QEL+sRoKJkV+q9M9mEz6rEAEgh78BUx4iZ1KaJP0bFo8GfWidZDSF9k0icUSJd02H8Q5a5pn/5sDy+F7VmmhIRe72ZvCM2fxJU3cx6rA3IXQXZpI3HtHN30YCih6vK/ItXnmw+z9+ylJELV9olRciFdZsxFo76oGJ2MWdNVrEcAcDqx8I80sHX7PavQefh8a8YhXALlIDGyoctF8pQBRgVJAZ7ETGJXQLCDlIuwipTujz7poKYs/IAVBYgBMA7rwlYLz+pvxcbxt3sHaW9S7w+OT7XARFhJ10+DG3krJvZhzzO72Ff/2MCSj2A9Vap8yTxFav9CGYa2dHFx+H+WLwGbcfphfE+JlZMiYeN6HMyF5bjn7ZJmuz9+j9yVHTw8MyUHAnWJR9XIZsPdlM/2+xNGcW3+OqHI/LV6+Jun2Z/vlmnbSZ6JEnA==";
		// String DeString = AESOperator.getInstance().decrypt(a);
		String DeString = AESOperator.getInstance().decrypt(a,
				"haoduSmk20150906", "haoduSmkappkeyiv");
		// System.out.println("解密后的字串是：" + DeString);
		lUseTime = System.currentTimeMillis() - lStart;
		// System.out.println("解密耗时：" + lUseTime + "毫秒");
	}

}
