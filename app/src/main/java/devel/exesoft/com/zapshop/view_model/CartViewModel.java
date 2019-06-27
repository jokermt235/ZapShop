package devel.exesoft.com.zapshop.view_model;

import android.content.Context;

import java.util.Observable;

import devel.exesoft.com.zapshop.CartActivity;

public class CartViewModel extends Observable {
    private CartActivity activity;
    private Context context;
    public CartViewModel(CartActivity activity){
        this.activity = activity;
        this.context = activity.getApplicationContext();
    }

}
