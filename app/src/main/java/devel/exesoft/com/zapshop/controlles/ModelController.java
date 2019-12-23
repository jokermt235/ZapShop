package devel.exesoft.com.zapshop.controlles;

import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import devel.exesoft.com.zapshop.BrandActivity;
import devel.exesoft.com.zapshop.R;
import devel.exesoft.com.zapshop.http.CustomStringRequest;
import devel.exesoft.com.zapshop.models.Model;

public class ModelController extends AppController {
    private static String TAG = "ModelController";
    public static void getModels(final BrandActivity activity, final View view , long brand_id){
        try {
            String source = activity.getString(R.string.api_server)+"models?brand_id="+ String.valueOf(brand_id);
            final CustomStringRequest jsonObjectRequest = new CustomStringRequest(source, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e(TAG, response);
                    if (response != null) {
                        try {
                            JSONObject result = new JSONObject(response);
                            JSONArray models = result.getJSONArray("data");
                            final ArrayList<Model> arrayModels= new ArrayList();
                            for(int i=0;i<models.length(); i++){
                                Model model = new Model();
                                model.setId(models.getJSONObject(i).getLong("id"));
                                model.setTitle(models.getJSONObject(i).getString("title"));
                                model.setBrand_id(models.getJSONObject(i).getLong("brand_id"));
                                arrayModels.add(model);
                            }
                            RecyclerView recyclerView = view.findViewById(R.id.recycler_models);
                            activity.showPopup(view, arrayModels);


                        } catch (Exception excp) {
                            Log.e(TAG, excp.toString());
                        }
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    this.onErrorResponse(error);
                }
            });

            getInstance().getRequestQueue().add(jsonObjectRequest);
        }catch (Exception e){
            Log.d(TAG, e.getStackTrace().toString());
        }
    }
}
