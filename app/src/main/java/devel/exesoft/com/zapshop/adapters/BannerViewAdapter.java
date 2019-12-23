package devel.exesoft.com.zapshop.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

import devel.exesoft.com.zapshop.MainActivity;
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


    public BannerViewAdapter(MainActivity activity, ArrayList<Banner> items){
        context = activity;
        this.items = items;
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        if(items.size() > 0){
            viewHolder.imageViewBackground.setImageBitmap(items.get(position).getImage());
            viewHolder.textViewDescription.setText(items.get(position).getTitle());
        }
    }

    @Override
    public int getCount() {
        return items.size();
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
