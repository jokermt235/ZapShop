package devel.exesoft.com.zapshop;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ListView;

import devel.exesoft.com.zapshop.adapters.BrandGridAdapter;
import devel.exesoft.com.zapshop.adapters.ItemAdapter;

public class ItemActivity extends AppCompatActivity {

    public ListView itemListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        toolbar.setTitle(getString(R.string.main_toolbar_title));
        setSupportActionBar(toolbar);
        initItemList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void initItemList(){
        itemListView = findViewById(R.id.item_listview);
        String[] items = {"Хонда","Мазда", "БМВ","VW","Лексус"};
        Bitmap[] images = {
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_brand_dummy_image),
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_brand_dummy_image),
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_brand_dummy_image),
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_brand_dummy_image),
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_brand_dummy_image)
        };
        ItemAdapter adapter = new ItemAdapter(ItemActivity.this, items, images );
        itemListView.setAdapter(adapter);
    }
}
