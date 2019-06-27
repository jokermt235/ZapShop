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
import devel.exesoft.com.zapshop.adapters.MainCatAdapter;
import devel.exesoft.com.zapshop.http.CustomStringRequest;
import devel.exesoft.com.zapshop.models.Collection;

public class CategoryController extends  AppController{
    private static String TAG = "CategoryController";
    public static void getCategories(final MainActivity activity){
        try {
            String source = activity.getString(R.string.api_server)+"collections";
            final CustomStringRequest jsonObjectRequest = new CustomStringRequest(source, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e(TAG, response);
                    if (response != null) {
                        try {
                            JSONObject result = new JSONObject(response);
                            JSONArray collections = result.getJSONArray("data");
                            final ArrayList<Collection> arrayCollections= new ArrayList();
                            final String[] items = new String[collections.length()];
                            final Bitmap[] images = new Bitmap[collections.length()];
                            for(int i=0;i<collections.length(); i++){
                                String image_url = activity.getString(R.string.api_server)+activity.getString(R.string.image_sub_url)  +
                                collections.getJSONObject(i).getString("image_url") + activity.getString(R.string.token_as_param) ;

                                final Collection collection = new Collection();
                                collection.setId(collections.getJSONObject(i).getLong("id"));
                                collection.setTitle(collections.getJSONObject(i).getString("title"));
                                ImageRequest imageRequest = new ImageRequest(image_url, new Response.Listener<Bitmap>() {
                                    @Override
                                    public void onResponse(Bitmap response) {
                                        // callback
                                        //arrayImages.add(response);
                                        collection.setImage(response);
                                        arrayCollections.add(collection);
                                        MainCatAdapter adapter = new MainCatAdapter(activity, arrayCollections);
                                        activity.activityMainBinding.mainCatGrid.setAdapter(adapter);
                                    }
                                }, 128, 128, null, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        collection.setImage(BitmapFactory.decodeResource(activity.getResources(), R.mipmap.ic_no_image));
                                        arrayCollections.add(collection);
                                        MainCatAdapter adapter = new MainCatAdapter(activity, arrayCollections);
                                        activity.activityMainBinding.mainCatGrid.setAdapter(adapter);
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
