package devel.exesoft.com.zapshop;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

import devel.exesoft.com.zapshop.controlles.BrandController;
import devel.exesoft.com.zapshop.databinding.ActivityBrandBinding;
import devel.exesoft.com.zapshop.models.Model;
import devel.exesoft.com.zapshop.view_model.BrandViewModel;

public class BrandActivity extends AppCompatActivity {

    public BrandViewModel brandViewModel;

    public ActivityBrandBinding activityBrandBinding;

    public long collection_id;

    public long brand_id;

    public long model_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBrandBinding = DataBindingUtil.setContentView(this, R.layout.activity_brand);
        collection_id = getIntent().getLongExtra("collection_id",1);
        brandViewModel = new BrandViewModel(this);
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
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                //Toast.makeText(getApplicationContext(), "HELLO ITEM",Toast.LENGTH_LONG).show();
                return true;
            }
        });
        MenuInflater inflater = popup.getMenuInflater();
        Menu menu = popup.getMenu();
        for (Model arrayModel: arrayModels) {
            menu.add(arrayModel.getTitle());
        }
        inflater.inflate(R.menu.menu_dropdown, menu);
        popup.show();
    }
}
