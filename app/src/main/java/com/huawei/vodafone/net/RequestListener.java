package com.huawei.vodafone.net;

import com.android.volley.VolleyError;

public interface RequestListener
{
    
    /** 成功 */
    public void requestSuccess(Object tag, String json);
    
    /** 错误 */
    public void requestError(Object tag, VolleyError e);
}
