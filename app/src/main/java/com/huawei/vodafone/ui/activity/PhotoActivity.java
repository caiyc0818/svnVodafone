package com.huawei.vodafone.ui.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.ui.adapter.FaqsPagerAdapter;
import com.huawei.vodafone.util.StringUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * @author hanweipeng
 * @date 2015-6-30 下午2:20:44
 */
public class PhotoActivity extends BaseActivity implements OnPageChangeListener
{
    private ViewPager viewPager;
    
    private TextView numberTxt;
    
    private int photoPosition = 0;
    
    private ArrayList<String> photoUrls;
    
    private List<View> views;
    
    @Override
    protected void onCreate(Bundle arg0)
    {
        // TODO Auto-generated method stub
        super.onCreate(arg0);
        setContentView(R.layout.photo_activity);
        initView();
    }
    
    protected void initView()
    {
        photoPosition = getIntent().getIntExtra("position", 0);
        if (getIntent().getStringArrayListExtra("photos") != null)
        {
            photoUrls = getIntent().getStringArrayListExtra("photos");
        }
        else
        {
            photoUrls = new ArrayList<String>();
        }
        viewPager = (ViewPager)findViewById(R.id.photo_page);
        numberTxt = (TextView)findViewById(R.id.number_txt);
        numberTxt.setText((photoPosition + 1) + "/" + photoUrls.size());
        addPhotos(photoUrls);
        viewPager.setCurrentItem(photoPosition);
    }
    
    private void addPhotos(ArrayList<String> tempList)
    {
        int count = tempList.size();
        views = new ArrayList<View>();
        for (int i = 0; i < count; i++)
        {
            // 初始化图片资源
            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ScaleType.FIT_CENTER);
            WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
            int width = wm.getDefaultDisplay().getWidth();
            if (!StringUtils.isEmpty(tempList.get(i)))
            {
                ImageLoader.getInstance().displayImage(tempList.get(i), imageView);
            }
            imageView.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					finish();
				}
			});
            views.add(imageView);
        }
        // 设置填充ViewPager页面的适配器
        viewPager.setAdapter(new FaqsPagerAdapter(views));
        // 设置一个监听器，当ViewPager中的页面改变时调用
        viewPager.setOnPageChangeListener(this);
    }
    
    @Override
    public void onPageScrollStateChanged(int arg0)
    {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2)
    {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void onPageSelected(int arg0)
    {
        // TODO Auto-generated method stub
        numberTxt.setText((arg0 + 1) + "/" + photoUrls.size());
    }
}
