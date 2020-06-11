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

import java.util.ArrayList;

import devel.exesoft.com.zapshop.ItemActivity;
import devel.exesoft.com.zapshop.R;
import devel.exesoft.com.zapshop.controlles.CartController;
import devel.exesoft.com.zapshop.models.Item;

public class ItemAdapter extends BaseAdapter {
    private Context mContext;
    private ItemActivity activity;
    private ArrayList<Item> items;

    public ItemAdapter(ItemActivity activity, ArrayList<Item> items) {
        this.mContext = activity.getApplicationContext();
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
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

        final ViewHolder viewHolder;

        if (convertView == null) {
            view = inflater.inflate(R.layout.item_listview_item, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = (View) convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.imageView.setImageBitmap(items.get(i).getImage());
        viewHolder.textView.setText(items.get(i).getTitle());
        viewHolder.textViewId.setText(String.valueOf(items.get(i).getId()));
        viewHolder.textViewPrice.setText(String.valueOf(items.get(i).getPrice()));
        viewHolder.imageViewCart.setImageResource(R.drawable.ic_shopping_cart_theme_24dp);
        viewHolder.imageViewFlag.setImageBitmap(items.get(i).getCountry());
        viewHolder.imageViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CartController.add();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mContext.startActivity(new Intent(mContext, ItemActivity.class));
            }
        });
        return view;
    }

    private class ViewHolder {
        final ImageView imageView;
        final TextView textView;
        final TextView textViewId;
        final TextView textViewPrice;
        final ImageView imageViewCart;
        final ImageView imageViewFlag;
        ViewHolder(View view) {
            imageView = view.findViewById(R.id.item_listview_item_image);
            textView = view.findViewById(R.id.item_listview_item_descr);
            textViewId  = view.findViewById(R.id.item_id);
            textViewPrice = view.findViewById(R.id.item_price);
            imageViewCart = view.findViewById(R.id.item_cart);
            imageViewFlag  = view.findViewById(R.id.item_listview_country_image);
        }
    }
}
