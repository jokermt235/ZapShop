package devel.exesoft.com.zapshop.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import devel.exesoft.com.zapshop.CartActivity;
import devel.exesoft.com.zapshop.R;
import devel.exesoft.com.zapshop.models.Cart;

public class CartRecyclerAdapter extends RecyclerView.Adapter<CartRecyclerAdapter.VH> {

    private ArrayList<Cart> carts;
    private Context mContext;
    private CartActivity activity;

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.model_spinner_item, viewGroup, false);
        VH vh = new VH(v);
        return vh;
    }

    public CartRecyclerAdapter(CartActivity activity, ArrayList<Cart> carts){
        this.carts  = carts;
        this.mContext  = activity.getApplicationContext();
        this.activity = activity;
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        vh.textView.setText(carts.get(i).getItem_title());
        vh.textViewId.setText(String.valueOf(carts.get(i).getItem_id()));
    }

    @Override
    public int getItemCount() {
        return carts.size();
    }

    public class VH extends RecyclerView.ViewHolder{
        public TextView textView;
        public TextView textViewId;
        public VH(View v) {
            super(v);
            textView = v.findViewById(R.id.cart_item_title);
            textViewId = v.findViewById(R.id.cart_item_id);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Intent intent = new Intent(mContext, ItemActivity.class);
                    intent.putExtra("collection_id",activity.collection_id);
                    intent.putExtra("brand_id", activity.brand_id);
                    intent.putExtra("model_id", Integer.valueOf(textViewId.getText().toString()));
                    mContext.startActivity(intent);*/
                }
            });
        }
    }
}
