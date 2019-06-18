package devel.exesoft.com.zapshop.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import devel.exesoft.com.zapshop.BrandActivity;
import devel.exesoft.com.zapshop.ItemActivity;
import devel.exesoft.com.zapshop.R;

public class BrandGridAdapter extends BaseAdapter {

    private Context mContext;

    private final String[] gridViewString;
    private final Bitmap[] gridViewImageBitmap;

    public BrandGridAdapter(Context c, String[] gridViewString, Bitmap[] gridViewImageBitmap) {
        this.mContext = c;
        this.gridViewString = gridViewString;
        this.gridViewImageBitmap = gridViewImageBitmap;
    }

    @Override
    public int getCount() {
        return gridViewString.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = null;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder viewHolder;

        if (convertView == null) {
            view = inflater.inflate(R.layout.brand_grid_item, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = (View) convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        //viewHolder.imageView.setImageBitmap(gridViewImageBitmap[i]);
        viewHolder.textView.setText(gridViewString[i]);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext, ItemActivity.class));
            }
        });
        return view;
    }

    private class ViewHolder {
        final ImageView imageView;
        final TextView textView;

        ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.brand_grid_image);
            textView = (TextView) view.findViewById(R.id.brand_grid_title);
        }
    }
}
