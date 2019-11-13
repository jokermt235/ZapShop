package devel.exesoft.com.zapshop;

import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import devel.exesoft.com.zapshop.controlles.CategoryController;
import devel.exesoft.com.zapshop.databinding.ActivityMainBinding;
import devel.exesoft.com.zapshop.view_model.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivty";

    public MainViewModel mainViewModel;

    public ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new MainViewModel(this);
        activityMainBinding.setViewModel(mainViewModel);
        activityMainBinding.executePendingBindings();
        activityMainBinding.mainToolbar.setTitle(getString(R.string.main_toolbar_title));
        activityMainBinding.mainToolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        setSupportActionBar(activityMainBinding.mainToolbar);
        initNavogationAction();
        CategoryController.getCategories(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void initDrawerMenu(){
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, activityMainBinding.drawerLayout, activityMainBinding.mainToolbar, R.string.app_name, R.string.app_name);

        //drawer.setDrawerListener(toggle);
        activityMainBinding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId  = item.getItemId();
        switch (itemId){
            case R.id.main_toolbar_cart: mainViewModel.onCartItemClicked();break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void initNavogationAction(){
        activityMainBinding.mainToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityMainBinding.drawerLayout.openDrawer(Gravity.START);
            }
        });
    }
}
