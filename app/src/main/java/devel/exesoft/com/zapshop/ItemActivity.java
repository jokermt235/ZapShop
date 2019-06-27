package devel.exesoft.com.zapshop;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import devel.exesoft.com.zapshop.controlles.ItemController;
import devel.exesoft.com.zapshop.databinding.ActivityItemBinding;
import devel.exesoft.com.zapshop.view_model.ItemViewModel;

public class ItemActivity extends AppCompatActivity {

    public ItemViewModel itemViewModel;

    public ActivityItemBinding activityItemBinding;

    public long collection_id;

    public long model_id;

    public long brand_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityItemBinding = DataBindingUtil.setContentView(this, R.layout.activity_item);
        collection_id = getIntent().getLongExtra("collection_id",1);
        model_id = getIntent().getLongExtra("model_id",1);
        brand_id  = getIntent().getLongExtra("brand_id",1);
        itemViewModel = new ItemViewModel(this);
        activityItemBinding.setViewModel(itemViewModel);
        activityItemBinding.mainToolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        setSupportActionBar(activityItemBinding.mainToolbar);
        ItemController.getItems(this, collection_id, brand_id, model_id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
