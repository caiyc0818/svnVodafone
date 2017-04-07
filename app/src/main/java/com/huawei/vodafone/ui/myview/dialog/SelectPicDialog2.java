package com.huawei.vodafone.ui.myview.dialog;

import com.huawei.vodafone.R;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;


public class SelectPicDialog2 extends Dialog
{
    private Context mContext;
    
    private LayoutInflater inflater;
    
    private LayoutParams lp;
    
    private OperationListener mOperation;
    
    private Button selectBtn;
    
    private Button takePhotoBtn;
    
    public SelectPicDialog2(Context context, OperationListener operation)
    {
        super(context, R.style.Dialog2);
        this.mContext = context;
        this.mOperation = operation;
        inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.select_pic_dialog2, null);
        setContentView(layout);
        // 设置window属性
        lp = getWindow().getAttributes();
        lp.width = LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.BOTTOM;
        lp.dimAmount = (float)0.75; // 去背景遮盖
        lp.alpha = 1.0f;
        getWindow().setAttributes(lp);
        selectBtn = (Button)findViewById(R.id.select_from_photo);
        takePhotoBtn = (Button)findViewById(R.id.take_photo);
        Button cancelBtn = (Button)findViewById(R.id.cancel_button);
        selectBtn.setOnClickListener(mOnCancelListener);
        takePhotoBtn.setOnClickListener(mOnCancelListener);
        cancelBtn.setOnClickListener(mOnCancelListener);
    }
    
    android.view.View.OnClickListener mOnCancelListener = new android.view.View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.select_from_photo:
                    mOperation.operationPhoto(1);
                    cancel();
                    break;
                case R.id.take_photo:
                    mOperation.operationPhoto(2);
                    cancel();
                    break;
                case R.id.cancel_button:
                    cancel();
                    break;
                default:
                    break;
            }
        }
    };
    
    public interface OperationListener
    {
        public void operationPhoto(int witch);
    }
}
