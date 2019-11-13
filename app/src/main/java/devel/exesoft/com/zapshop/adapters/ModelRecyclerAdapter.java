package devel.exesoft.com.zapshop.adapters;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import devel.exesoft.com.zapshop.BrandActivity;
import devel.exesoft.com.zapshop.ItemActivity;
import devel.exesoft.com.zapshop.R;
import devel.exesoft.com.zapshop.models.Model;

public class ModelRecyclerAdapter extends RecyclerView.Adapter<ModelRecyclerAdapter.VH> {

    private ArrayList<Model> models;
    private Context mContext;
    private BrandActivity activity;

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.model_spinner_item, viewGroup, false);
        VH vh = new VH(v);
        return vh;
    }

    public ModelRecyclerAdapter(BrandActivity activity, ArrayList<Model> models){
        this.models  = models;
        this.mContext  = activity.getApplicationContext();
        this.activity = activity;
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        vh.textView.setText(models.get(i).getTitle());
        vh.textViewId.setText(String.valueOf(models.get(i).getId()));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class VH extends RecyclerView.ViewHolder{
        public TextView textView;
        public TextView textViewId;
        public VH(View v) {
            super(v);
            textView = v.findViewById(R.id.model_title);
            textViewId = v.findViewById(R.id.model_id);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ItemActivity.class);
                    intent.putExtra("collection_id",activity.collection_id);
                    intent.putExtra("brand_id", activity.brand_id);
                    intent.putExtra("model_id", Integer.valueOf(textViewId.getText().toString()));
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
