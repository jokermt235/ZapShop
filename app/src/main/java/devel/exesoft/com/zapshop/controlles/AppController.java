package devel.exesoft.com.zapshop.controlles;


import android.app.Application;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AppController extends Application {
    private static  final String TAG  = "AppController";

    private static AppController mInstance;

    private RequestQueue requestQueue;

    @Override
    public void onCreate(){
        super.onCreate();
        mInstance = this;
        Log.d(TAG, "onCreate");
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        return requestQueue;
    }

}
