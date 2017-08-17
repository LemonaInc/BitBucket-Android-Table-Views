package vfs.com.androidtableviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerAdapter mRecyclerAdapter;
    private ArrayList<Repository> repositoryList;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_View);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);


        //repositoryList = new ArrayList<>();
        //repositoryList.add(new Repository("Bob", "Jim","Hello World","Hello Sky"));
        //repositoryList.add(new Repository("Bob", "Jim","Hello World","Hello Sky"));
        // repositoryList.add(new Repository("Bob", "Jim","Hello World","Hello Sky"));
        //repositoryList.add(new Repository("Bob", "Jim","Hello World","Hello Sky"));

//        mRecyclerAdapter = new RecyclerAdapter(repositoryList);
//        mRecyclerView.setAdapter(mRecyclerAdapter);

         RequestQueue queue = Volley.newRequestQueue(this);

       // private String userusername;
         String urlString = "https://api.bitbucket.org/2.0/repositories/OutBully";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlString, new Response.Listener<String>() {
            @Override



            public void onResponse(String response) {
                Log.i("MainActivity", "OnResponse");

                ArrayList<Repository> repositories = new ArrayList<>();

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("values");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject repositoryJSON = jsonArray.getJSONObject(i);
                        String name = repositoryJSON.getString("name");
                        repositories.add(new Repository(name, "CommitsLink", "lastUpdated", "avatarLink"));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                mRecyclerAdapter = new RecyclerAdapter(repositories);
                mRecyclerView.setAdapter(mRecyclerAdapter);

            }



        },

            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("MainActivity", "OnResponse");
                }
            })
        {

                @Override
                public Map<String, String> getHeaders () throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    String credentials = "username.password";
                    String auth = "Basic" + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                    params.put("Authorization", auth);
                    return params;

                }
            };

           queue.add(stringRequest);



    }


}


