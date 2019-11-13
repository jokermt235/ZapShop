package devel.exesoft.com.zapshop;

import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

import devel.exesoft.com.zapshop.controlles.BrandController;
import devel.exesoft.com.zapshop.controlles.ItemController;
import devel.exesoft.com.zapshop.databinding.ActivityBrandBinding;
import devel.exesoft.com.zapshop.models.Model;
import devel.exesoft.com.zapshop.view_model.BrandViewModel;

public class BrandActivity extends AppCompatActivity {

    public BrandViewModel brandViewModel;

    public ActivityBrandBinding activityBrandBinding;

    public long collection_id;

    public long brand_id;

    public long model_id;

    public BrandActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBrandBinding = DataBindingUtil.setContentView(this, R.layout.activity_brand);
        collection_id = getIntent().getLongExtra("collection_id",1);
        brandViewModel = new BrandViewModel(this);
        activity = this;
        activityBrandBinding.setViewModel(brandViewModel);
        activityBrandBinding.executePendingBindings();
        activityBrandBinding.mainToolbar.setTitle(getString(R.string.brand_title));
        activityBrandBinding.mainToolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        setSupportActionBar(activityBrandBinding.mainToolbar);
        BrandController.getBrands(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void showPopup(View v , ArrayList<Model> arrayModels) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        Menu menu = popup.getMenu();
        int index = 0;
        for (Model arrayModel: arrayModels) {
            menu.add(arrayModel.getTitle());
            menu.getItem(index).setTitleCondensed(String.valueOf(arrayModel.getId()));
            index++;
        }
        inflater.inflate(R.menu.menu_dropdown, menu);
        popup.show();
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(activity, ItemActivity.class);
                intent.putExtra("collection_id",collection_id);
                intent.putExtra("brand_id",brand_id);
                intent.putExtra("model_id", Long.parseLong(String.valueOf(item.getTitleCondensed())));
                activity.startActivity(intent);
                return true;
            }
        });
    }
}
