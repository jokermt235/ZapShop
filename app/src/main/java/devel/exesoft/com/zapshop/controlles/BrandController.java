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

import devel.exesoft.com.zapshop.BrandActivity;
import devel.exesoft.com.zapshop.R;
import devel.exesoft.com.zapshop.adapters.BrandGridAdapter;
import devel.exesoft.com.zapshop.http.CustomStringRequest;
import devel.exesoft.com.zapshop.models.Brand;

public class BrandController extends AppController {
    private static String TAG = "BrandController";
    public static void getBrands(final BrandActivity activity){
        try {
            String source = activity.getString(R.string.api_server)+"brands";
            final CustomStringRequest jsonObjectRequest = new CustomStringRequest(source, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e(TAG, response);
                    if (response != null) {
                        try {
                            JSONObject result = new JSONObject(response);
                            JSONArray brands = result.getJSONArray("data");
                            final ArrayList<Brand> arrayBrands= new ArrayList();
                            for(int i=0;i<brands.length(); i++){
                                final Brand brand = new Brand();
                                brand.setId(brands.getJSONObject(i).getLong("id"));
                                brand.setTitle(brands.getJSONObject(i).getString("title"));
                                String image_url = activity.getString(R.string.api_server)+activity.getString(R.string.image_sub_url)  +
                                        brands.getJSONObject(i).getString("image_url") + activity.getString(R.string.token_as_param) ;
                                Log.e(TAG, image_url);
                                ImageRequest imageRequest = new ImageRequest(image_url, new Response.Listener<Bitmap>() {
                                    @Override
                                    public void onResponse(Bitmap response) {
                                        // callback
                                        brand.setImage(response);
                                        arrayBrands.add(brand);
                                        BrandGridAdapter adapter = new BrandGridAdapter(activity, arrayBrands);
                                        activity.activityBrandBinding.brandGrid.setAdapter(adapter);
                                    }
                                }, 128, 128, null, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        brand.setImage(BitmapFactory.decodeResource(activity.getResources(), R.mipmap.ic_no_image));
                                        arrayBrands.add(brand);
                                        BrandGridAdapter adapter = new BrandGridAdapter(activity, arrayBrands);
                                        activity.activityBrandBinding.brandGrid.setAdapter(adapter);
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
                    Log.e(TAG, error.toString());
                }
            });

            getInstance().getRequestQueue().add(jsonObjectRequest);
        }catch (Exception e){
            Log.d(TAG, e.getStackTrace().toString());
        }
    }
}
