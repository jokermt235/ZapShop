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

import devel.exesoft.com.zapshop.ItemActivity;
import devel.exesoft.com.zapshop.R;
import devel.exesoft.com.zapshop.adapters.ItemAdapter;
import devel.exesoft.com.zapshop.http.CustomStringRequest;
import devel.exesoft.com.zapshop.models.Item;

public class ItemController extends AppController {
    private static String TAG = "ItemController";
    public static void getItems(final ItemActivity activity, long collection_id, long brand_id, long model_id){
        try {
            String source = activity.getString(R.string.api_server)+"products";
            JSONObject params = new JSONObject();
            try {
                params.put("collection_id", collection_id);
                params.put("brand_id", brand_id);
                params.put("model_id", model_id);
            }catch (Exception e){
                e.printStackTrace();
            }
            final CustomStringRequest jsonObjectRequest = new CustomStringRequest(source , params ,new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e(TAG, response);
                    if (response != null) {
                        try {
                            JSONObject result = new JSONObject(response);
                            JSONArray items = result.getJSONArray("data");
                            final ArrayList<Item> arrayItems= new ArrayList();
                            for(int i=0;i<items.length(); i++){
                                final Item item = new Item();
                                item.setId(items.getJSONObject(i).getLong("id"));
                                item.setTitle(items.getJSONObject(i).getString("title"));
                                item.setPrice(items.getJSONObject(i).getLong("price"));
                                item.setUnit(items.getJSONObject(i).getString("unit"));
                                String image_url = activity.getString(R.string.api_server)+activity.getString(R.string.image_sub_url)  +
                                        items.getJSONObject(i).getString("image_url") + activity.getString(R.string.token_as_param);

                                ImageRequest imageRequest = new ImageRequest(image_url, new Response.Listener<Bitmap>() {
                                    @Override
                                    public void onResponse(Bitmap response) {
                                        // callback
                                        item.setImage(response);
                                        arrayItems.add(item);
                                        ItemAdapter adapter = new ItemAdapter(activity, arrayItems);
                                        activity.activityItemBinding.itemListview.setAdapter(adapter);
                                    }
                                }, 128, 128, null, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        item.setImage(BitmapFactory.decodeResource(activity.getResources(), R.mipmap.ic_no_image));
                                        arrayItems.add(item);
                                        ItemAdapter adapter = new ItemAdapter(activity, arrayItems);
                                        activity.activityItemBinding.itemListview.setAdapter(adapter);
                                    }
                                });

                                getInstance().getRequestQueue().add(imageRequest);
                            }
                        } catch (Exception excp) {
                            excp.printStackTrace();
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
