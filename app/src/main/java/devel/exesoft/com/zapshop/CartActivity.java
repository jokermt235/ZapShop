package devel.exesoft.com.zapshop;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import devel.exesoft.com.zapshop.databinding.ActivityCartBinding;
import devel.exesoft.com.zapshop.databinding.ActivityMainBinding;
import devel.exesoft.com.zapshop.view_model.CartViewModel;
import devel.exesoft.com.zapshop.view_model.MainViewModel;

public class CartActivity extends AppCompatActivity {

    public CartViewModel cartViewModel;

    public ActivityCartBinding activityCartBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCartBinding = DataBindingUtil.setContentView(this, R.layout.activity_cart);
        cartViewModel = new CartViewModel(this);
        activityCartBinding.setViewModel(cartViewModel);
        setSupportActionBar(activityCartBinding.mainToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
