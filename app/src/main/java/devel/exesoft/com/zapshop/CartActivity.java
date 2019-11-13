package devel.exesoft.com.zapshop;

import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import devel.exesoft.com.zapshop.databinding.ActivityCartBinding;
import devel.exesoft.com.zapshop.view_model.CartViewModel;

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
