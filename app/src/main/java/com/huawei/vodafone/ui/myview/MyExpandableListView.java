package com.huawei.vodafone.ui.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

/**
 * @author kanl
 *
 * @create 2016年7月22日 下午17:35:22
 */
public class MyExpandableListView extends ExpandableListView
{
    
    public MyExpandableListView(Context context)
    {
        super(context);
        // TODO Auto-generated constructor stub
    }
    
    public MyExpandableListView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }
    
    public MyExpandableListView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        // TODO Auto-generated method stub
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
