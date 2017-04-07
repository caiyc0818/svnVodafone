package com.huawei.vodafone.zxing.encode;

import java.util.Hashtable;

import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
/**
 * @author Ryan Tang
 *
 */
public final class EncodingHandler {
	private static final int BLACK = 0xff000000;
	
	public static Bitmap createQRCode(String str,int widthAndHeight) throws WriterException {
		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();  
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); 
		BitMatrix matrix = new MultiFormatWriter().encode(str,
				BarcodeFormat.QR_CODE, widthAndHeight, widthAndHeight);
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		
		int start =0;
		for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (matrix.get(x, y)) {
                    start = x;
                    break;
                }
            }
        }
		int trueWidth=width-2*start;
		int trueHeight=height-2*start;
		int[] pixels = new int[trueWidth * trueHeight];
		for (int y = 0; y < trueHeight; y++) {
			for (int x = 0; x < trueWidth; x++) {
				if (matrix.get(x+start, y+start)) {
					pixels[y * trueWidth + x] = BLACK;
				}
			}
		}
		Bitmap bitmap = Bitmap.createBitmap(trueWidth, trueHeight,
				Bitmap.Config.ARGB_8888);
		bitmap.setPixels(pixels, 0, trueWidth, 0, 0, trueWidth, trueHeight);
		return bitmap;
	}
}
