package devel.exesoft.com.zapshop;

import androidx.appcompat.app.AppCompatActivity;
import devel.exesoft.com.zapshop.controlles.CustomerController;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;

public class SplashScreen extends AppCompatActivity {

    private String android_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        android_id = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        CustomerController.setCustomer(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public String getDeviceId(){
        return android_id;
    }
}
