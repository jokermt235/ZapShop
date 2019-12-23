package devel.exesoft.com.zapshop.view_model;

import android.content.Context;
import android.content.Intent;

import java.util.Observable;

import devel.exesoft.com.zapshop.CartActivity;
import devel.exesoft.com.zapshop.ItemActivity;
import devel.exesoft.com.zapshop.controlles.ItemController;

public class ItemViewModel extends Observable {
    private static String TAG = "ItemViewModel";
    public ItemActivity activity;
    public Context context;
    public ItemViewModel(ItemActivity activity){
        this.activity = activity;
        this.context = activity.getApplicationContext();
    }
    public void  onCartItemClicked(){
        activity.startActivity(new Intent(context, CartActivity.class));
    }
}
