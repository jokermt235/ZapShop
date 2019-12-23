package devel.exesoft.com.zapshop.view_model;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Observable;

import devel.exesoft.com.zapshop.CartActivity;
import devel.exesoft.com.zapshop.MainActivity;

public class CartViewModel extends Observable {
    private CartActivity activity;
    private Context context;
    private static  String TAG = "CartViewModel";
    public CartViewModel(CartActivity activity){
        this.activity = activity;
        this.context = activity.getApplicationContext();
    }

    public void onHomeItemClicked(){
        Log.d(TAG, "Home menu item clicked");
        activity.startActivity(new Intent(context, MainActivity.class));
        activity.finish();
    }
}
