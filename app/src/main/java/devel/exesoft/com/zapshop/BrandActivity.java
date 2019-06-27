package devel.exesoft.com.zapshop;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import devel.exesoft.com.zapshop.controlles.BrandController;
import devel.exesoft.com.zapshop.databinding.ActivityBrandBinding;
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
}
