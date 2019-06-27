package devel.exesoft.com.zapshop.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import devel.exesoft.com.zapshop.BrandActivity;
import devel.exesoft.com.zapshop.R;
import devel.exesoft.com.zapshop.controlles.ModelController;
import devel.exesoft.com.zapshop.models.Brand;

public class BrandGridAdapter extends BaseAdapter {

    private Context mContext;

    private BrandActivity activity;

    private ArrayList<Brand> brands;

    public BrandGridAdapter(BrandActivity activity, ArrayList<Brand> brands) {
        this.mContext = activity.getApplicationContext();
        this.brands = brands;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return this.brands.size();
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
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
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

        viewHolder.imageView.setImageBitmap(brands.get(i).getImage());
        viewHolder.textView.setText(brands.get(i).getTitle());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.brand_id = brands.get(i).getId();
                ModelController.getModels(activity, view, brands.get(i).getId());
            }
        });
        return view;
    }

    private class ViewHolder {
        final ImageView imageView;
        final TextView textView;

        ViewHolder(View view) {
            imageView = view.findViewById(R.id.brand_grid_image);
            textView = view.findViewById(R.id.brand_grid_title);
        }
    }
}
