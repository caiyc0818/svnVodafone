package com.huawei.vodafone.ui.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * 自定义ScrollView 解决ScrollView中ViewPager无法正常滑动问题 解决方法只需要在接近水平滚动时ScrollView不处理事件而交由其子View(即这里的ViewPager)处理即可，
 * 重写ScrollView的onInterceptTouchEvent函数
 * 
 * @author zhangbingkang
 * @version V1.0 创建时间：2014-2-18 下午4:01:10
 */
public class NewScrollView extends ScrollView
{
    
    public NewScrollView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }
    @Override  
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {  
        int height = 0;  
        View childView = getChildAt(0);  
        if (childView != null) {  
            childView.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));  
            int h = childView.getHeight();  
            if (h > height) {  
                height = h;  
            }  
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);  
        }  
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);  
    } 
}

