package devel.exesoft.com.zapshop.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

import devel.exesoft.com.zapshop.R;
import devel.exesoft.com.zapshop.models.Banner;

public class BannerViewAdapter extends SliderViewAdapter<BannerViewAdapter.SliderAdapterVH> {
    private Context context;
    public ArrayList<Banner> items;
    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_item, null);
        return new SliderAdapterVH(inflate);
    }

    public void setItems(ArrayList<Banner> items){
        this.items = items;

    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        viewHolder.textViewDescription.setText("This is slider item " + position);
        if(items.size() > 0){
            viewHolder.imageViewBackground.setImageBitmap(items.get(position).getImage());
        }
    }

    @Override
    public int getCount() {
        return 0;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.ml_banner_image);
            textViewDescription = itemView.findViewById(R.id.ml_banner_text);
            this.itemView = itemView;
        }
    }
}
