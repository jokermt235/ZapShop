package devel.exesoft.com.zapshop.controlles;

import android.content.Intent;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;

import devel.exesoft.com.zapshop.MainActivity;
import devel.exesoft.com.zapshop.R;
import devel.exesoft.com.zapshop.SplashScreen;
import devel.exesoft.com.zapshop.http.CustomStringRequest;

public class CustomerController extends  AppController {
    private static String TAG = "CustomerController";
    public static void setCustomer(final  SplashScreen activity){
        String source = activity.getString(R.string.api_server)+"customers";
        try {

            JSONObject params = new JSONObject();
            params.put("device_id",activity.getDeviceId());
            final CustomStringRequest jsonObjectRequest = new CustomStringRequest(Request.Method.POST,source,params, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    activity.startActivity(new Intent(activity, MainActivity.class));
                    Log.e(TAG, response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    this.onErrorResponse(error);
                    Log.e(TAG, error.toString());
                }
            });
            getInstance().getRequestQueue().add(jsonObjectRequest);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
