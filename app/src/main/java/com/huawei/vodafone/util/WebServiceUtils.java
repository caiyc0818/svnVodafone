package com.huawei.vodafone.util;


import com.android.volley.VolleyError;
import com.huawei.vodafone.net.IRequest;
import com.huawei.vodafone.net.RequestJSon;
import com.huawei.vodafone.net.RequestListener;
import com.huawei.vodafone.net.URLs;

public class WebServiceUtils {

	public static void recharge(){
		
	        IRequest.post( URLs.RECHARGE,11, RequestJSon.recharge("15298006639", 10000),
					new RequestListener() {
						
						@Override
						public void requestSuccess(Object tag, String json) {
							// TODO Auto-generated method stub
							System.out.print(2222);
							int i=json.indexOf("</cbs:ResultCode>");
							if(i!=-1){
								char code=json.charAt(i-1);
								if(code=='0'){
									
								}
							}
						}
						
						@Override
						public void requestError(Object tag, VolleyError e) {
							// TODO Auto-generated method stub
							System.out.print(2222);
						}
					});
	}
}
