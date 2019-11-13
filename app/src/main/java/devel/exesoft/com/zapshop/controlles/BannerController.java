package devel.exesoft.com.zapshop.controlles;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import devel.exesoft.com.zapshop.MainActivity;
import devel.exesoft.com.zapshop.R;
import devel.exesoft.com.zapshop.adapters.BrandGridAdapter;
import devel.exesoft.com.zapshop.http.CustomStringRequest;
import devel.exesoft.com.zapshop.models.Banner;
import devel.exesoft.com.zapshop.models.Brand;

public class BannerController extends AppController {
    private static  String TAG = "BannerController";
    public static void banners(final MainActivity activity) {
        try{
            String source = activity.getString(R.string.api_server)+"promos";
            final CustomStringRequest jsonObjectRequest = new CustomStringRequest(source, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e(TAG, response);
                    if (response != null) {
                        try {
                            JSONObject result = new JSONObject(response);
                            JSONArray banners = result.getJSONArray("data");
                            final ArrayList<Banner> arrayBanners= new ArrayList();
                            for(int i=0;i<banners.length(); i++){
                                final Banner banner = new Banner();
                                banner.setId(banners.getJSONObject(i).getLong("id"));
                                banner.setTitle(banners.getJSONObject(i).getString("title"));
                                String image_url = activity.getString(R.string.api_server)+activity.getString(R.string.image_sub_url)  +
                                        banners.getJSONObject(i).getString("image_url") + activity.getString(R.string.token_as_param);
                                Log.e(TAG, image_url);
                                ImageRequest imageRequest = new ImageRequest(image_url, new Response.Listener<Bitmap>() {
                                    @Override
                                    public void onResponse(Bitmap response) {
                                        // callback
                                        banner.setImage(response);
                                        arrayBanners.add(banner);
                                        //BrandGridAdapter adapter = new BrandGridAdapter(activity, arrayBrands);
                                        //activity.activityBrandBinding.brandGrid.setAdapter(adapter);
                                    }
                                }, 0, 0, null, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        //brand.setImage(BitmapFactory.decodeResource(activity.getResources(), R.mipmap.ic_no_image));
                                        //arrayBrands.add(brand);
                                        //BrandGridAdapter adapter = new BrandGridAdapter(activity, arrayBrands);
                                        //activity.activityBrandBinding.brandGrid.setAdapter(adapter);
                                    }
                                });

                                getInstance().getRequestQueue().add(imageRequest);
                            }
                        } catch (Exception excp) {
                            Log.e(TAG, excp.toString());
                        }
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    this.onErrorResponse(error);
                    error.printStackTrace();
                }
            });

            getInstance().getRequestQueue().add(jsonObjectRequest);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
