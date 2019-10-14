package per.ydd.gousheng.network;

import android.util.Log;
import java.net.URLEncoder;

import per.ydd.http.HttpClient;

public class Coupon {

    public interface CouponCallBack{
       void Call(String result,Exception err);
    }

    private static String url = "http://api.tbk.dingdanxia.com/tbk/tkl_privilege";
    private static String apiKey = "wpVmHmKSg9RTdgFJidqryKOJ574rzAde";

    public static  void getCoupon(String tkl,final CouponCallBack callBack){
        try {
            String param = "apikey="+ URLEncoder.encode(apiKey,"UTF-8")+"&tkl="+URLEncoder.encode(tkl,"UTF-8");
            Log.d("coupon", "getCoupon: "+param);
            HttpClient.Post(url, param, new HttpClient.CallBack() {
                @Override
                public void Call(String result, Exception err) {
                    if (err == null) {
                        callBack.Call(result,null);
                    } else {
                        callBack.Call(null,err);
                    }
                }
            });
        }catch (Exception err){
            callBack.Call(null,err);
        }


    }
}