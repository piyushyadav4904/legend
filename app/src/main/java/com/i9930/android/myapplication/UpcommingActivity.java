package com.i9930.android.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class UpcommingActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private ArrayList<UpcomingModel> list;
    private UpcomingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcomming);
        list=new ArrayList<UpcomingModel>();
        progressBar = findViewById(R.id.progress_cart);
        RecyclerView recyclerView = findViewById(R.id.recycler_cart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UpcomingAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }
    @Override
    protected void onResume() {
        super.onResume();

        getCartListReq();

    }

    private void getCartListReq() {
        RequestQueue Rq= Volley.newRequestQueue(this);
        progressBar.setVisibility(View.VISIBLE);


        JsonArrayRequest jar=new JsonArrayRequest(Request.Method.GET, "https://simplifiedcoding.net/demos/marvel/", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject object= response.getJSONObject(i);

                        UpcomingModel dto = new UpcomingModel();
                        dto.setName(object.getString("name"));
                        dto.setDescription(object.getString("bio"));
                        dto.setImage(object.getString("imageurl"));
                        dto.setPrice(object.getString("realname"));
                        dto.setBrand(object.getString("publisher"));

                        list.add(dto);
                        adapter.notifyDataSetChanged();
                        progressBar.setVisibility(View.GONE );
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("piyush ","something wen wrong "+error.getLocalizedMessage());
            }
        });
        Rq.add(jar);

    }
}