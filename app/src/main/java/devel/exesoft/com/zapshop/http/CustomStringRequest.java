package devel.exesoft.com.zapshop.http;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CustomStringRequest extends StringRequest {

    private static String TAG = "CustomStringRequest";
    private static String access_token = "a4d5c33e12795c21a3e40a53d94ddfd0";
    private JSONObject body;
    private JSONArray bodyArray;
    public void setBody(JSONObject pBody){
        body = pBody;
    }
    public CustomStringRequest(int method, String url, JSONObject params, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
        Log.d(TAG, "Params:" + params.toString());

        body = params;
    }

    public CustomStringRequest(String url, JSONArray params, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.POST, url, listener, errorListener);

        bodyArray = params;
    }


    public CustomStringRequest(String url,JSONObject params, Response.Listener<String> listener, Response.ErrorListener errorListener) throws UnsupportedEncodingException {
        super(Method.GET, url + getParamsString(params), listener, errorListener);
    }


    private String getUrlParams(String url , JSONObject params){
        if(params != null){

        }
        return url;
    }

    public CustomStringRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

    public void onErrorResponse(VolleyError error){
        try {
            Log.d(TAG, "Error in parent StringRequest : " + error.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {

        Map<String, String> headers = new HashMap<>();

        headers.put("Content-Type", "application/json; charset=UTF-8");

        headers.put("Authorization" , "Bearer "+ access_token);

        headers.put("Accept", "application/json");

        return headers;
    }

    @Override

    public byte[] getBody() throws AuthFailureError{
        if(bodyArray != null){
            return bodyArray.toString().getBytes();
        }
        return body.toString().getBytes();
    }


    private static String getParamsString(JSONObject params)
            throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        try {

            for (Iterator<String> it = params.keys(); it.hasNext(); ) {
                Object entry = it.next();
                result.append(URLEncoder.encode(entry.toString(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(params.get(entry.toString()).toString(), "UTF-8"));
                result.append("&");
            }
        }catch (JSONException e){
            Log.d(TAG, e.getStackTrace().toString());
        }

        String resultString = "?" + result.toString();
        Log.d(TAG, resultString);
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }

}
