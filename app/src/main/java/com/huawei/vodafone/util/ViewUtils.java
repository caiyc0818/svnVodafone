package com.huawei.vodafone.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.graphics.ColorMatrixColorFilter;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;



public class ViewUtils {
	public final static float[] BT_SELECTED = new float[] { 1, 0, 0, 0, -50, 0,
		1, 0, 0, -50, 0, 0, 1, 0, -50, 0, 0, 0, 1, 0 };
public final static float[] BT_NOT_SELECTED = new float[] { 1, 0, 0, 0, 0,
		0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0 };

private static final OnTouchListener touchListener = new OnTouchListener() {

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if(v.getBackground()!=null){
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			v.getBackground().setColorFilter(
					new ColorMatrixColorFilter(BT_SELECTED));
			v.setBackgroundDrawable(v.getBackground());
		} else if (event.getAction() == MotionEvent.ACTION_UP) {
			v.getBackground().setColorFilter(
					new ColorMatrixColorFilter(BT_NOT_SELECTED));
			v.setBackgroundDrawable(v.getBackground());
		}
		}
		return false;
	}
};

/**   
 * 按钮焦点改变   
 */    
public final static OnFocusChangeListener buttonOnFocusChangeListener=new OnFocusChangeListener() {     
     
@Override    
public void onFocusChange(View v, boolean hasFocus) {     
 if (hasFocus) {     
  v.getBackground().setColorFilter(new ColorMatrixColorFilter(BT_SELECTED));     
  v.setBackgroundDrawable(v.getBackground());     
 }     
 else    
 {     
  v.getBackground().setColorFilter(new ColorMatrixColorFilter(BT_NOT_SELECTED));     
   v.setBackgroundDrawable(v.getBackground());     
 }     
}     
};  

public static  void setButtonStateChangeListener(View v) {
	v.setOnTouchListener(touchListener);
	v.setOnFocusChangeListener(buttonOnFocusChangeListener);   
}

}
