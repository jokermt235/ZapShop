package devel.exesoft.com.zapshop.view_model;

import android.content.Context;

import java.util.Observable;

import devel.exesoft.com.zapshop.MainActivity;

public class MainViewModel extends Observable {
    private static String TAG ="MainViewModel";
    public MainActivity activity;
    public Context context;
    public MainViewModel(MainActivity activity){
        this.activity = activity;
        this.context = activity.getApplicationContext();
    }
}
