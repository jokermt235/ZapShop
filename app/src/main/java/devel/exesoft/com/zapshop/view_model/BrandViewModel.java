package devel.exesoft.com.zapshop.view_model;

import android.content.Context;
import android.content.Intent;

import java.util.Observable;

import devel.exesoft.com.zapshop.BrandActivity;
import devel.exesoft.com.zapshop.CartActivity;

public class BrandViewModel extends Observable {
    private static String TAG = "BrandViewModel";
    public BrandActivity activity;
    public Context context;
    public BrandViewModel(BrandActivity activity){
        this.activity = activity;
        this.context = activity.getApplicationContext();
    }

    public void  onCartItemClicked(){
        activity.startActivity(new Intent(context, CartActivity.class));
    }
}
