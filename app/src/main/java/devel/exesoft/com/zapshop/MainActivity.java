package devel.exesoft.com.zapshop;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.GridView;

import devel.exesoft.com.zapshop.adapters.MainCatAdapter;

public class MainActivity extends AppCompatActivity {

    GridView mainCatGridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        toolbar.setTitle(getString(R.string.main_toolbar_title));
        setSupportActionBar(toolbar);
        initMainGrid();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void initMainGrid(){
        mainCatGridview = findViewById(R.id.main_cat_grid);
        String[] items = {"Мтор","Ходовка", "Трансмиссия","Кузов","Шасси"};
        Bitmap[] images = {
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_directions_car_black_24dp),
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_directions_car_black_24dp),
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_directions_car_black_24dp),
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_directions_car_black_24dp),
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_directions_car_black_24dp)
        };
        MainCatAdapter adapter = new MainCatAdapter(MainActivity.this, items, images );
        mainCatGridview.setAdapter(adapter);
    }
}
