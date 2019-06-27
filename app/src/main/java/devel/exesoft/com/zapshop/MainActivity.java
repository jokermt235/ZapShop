package devel.exesoft.com.zapshop;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import devel.exesoft.com.zapshop.controlles.CategoryController;
import devel.exesoft.com.zapshop.databinding.ActivityMainBinding;
import devel.exesoft.com.zapshop.view_model.MainViewModel;

public class MainActivity extends AppCompatActivity {

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
        CategoryController.getCategories(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
