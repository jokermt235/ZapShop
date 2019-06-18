package devel.exesoft.com.zapshop.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import org.json.JSONArray;

public class BannerAdapter extends PagerAdapter {

    private Context mContext;

    private Bitmap[] mImages;

    private JSONArray mItems;

    public BannerAdapter(Context  c, Bitmap[] images, JSONArray items){
        mContext = c;
        this.mItems = items;
        this.mImages = images;
    }

    @Override
    public int getCount(){
        return  mImages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}
