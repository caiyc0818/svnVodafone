package com.huawei.vodafone.net;

import com.android.volley.VolleyError;

/**
 * 小袁 Created by Administrator on 2015/3/11.
 */
public interface RequestJsonListener<T>
{
    /**
     * 成功
     * 
     * @param <T>
     */
    public void requestSuccess(Object tag, T result);
    
    /**
     * 错误
     */
    public void requestError(Object tag, VolleyError e);
}
