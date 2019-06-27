package devel.exesoft.com.zapshop.view_model;

import android.content.Context;
import android.content.Intent;

import java.util.Observable;

import devel.exesoft.com.zapshop.CartActivity;
import devel.exesoft.com.zapshop.ItemActivity;
import devel.exesoft.com.zapshop.MainActivity;
import devel.exesoft.com.zapshop.models.Cart;

public class MainViewModel extends Observable {
    private static String TAG ="MainViewModel";
    public MainActivity activity;
    public Context context;
    public MainViewModel(MainActivity activity){
        this.activity = activity;
        this.context = activity.getApplicationContext();
    }

    public void  onCartItemClicked(){
        activity.startActivity(new Intent(context, CartActivity.class));
    }

}
