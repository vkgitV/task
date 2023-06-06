package com.example.recyclerusingvolley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

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
import java.util.List;

public  class MainActivity extends AppCompatActivity {
    List<PostModel> postList=new ArrayList<>();
    String url="https://jsonplaceholder.typicode.com/posts";
    PostAdapter adapter;
    List<PostModel> filterList=new ArrayList<>();

RecyclerView recyclerView;
EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        search=findViewById(R.id.search);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                filterList.clear();
                if (s.toString().isEmpty()){
                    recyclerView.setAdapter(new PostAdapter(getApplicationContext(),postList));
                    adapter.notifyDataSetChanged();
                }
                else{
                    Filter(s.toString());
                }

            }
        });
        
        GetData();
    }

    private void Filter(String text) {

        for (PostModel post:postList){
            if (Integer.toString(post.getUserId()).equals(text)){
                filterList.add(post);
            }
        }
        recyclerView.setAdapter(new PostAdapter(getApplicationContext(),filterList));
        adapter.notifyDataSetChanged();
    }

    private void GetData() {

        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("loading.....");
        progressDialog.show();


        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {



                for(int i=0;i<=response.length();i++){


                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        postList.add(new PostModel(
                                jsonObject.getInt("userId"),
                                jsonObject.getString("title"),jsonObject.getString("body")
                        ));

                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                    adapter= new PostAdapter(getApplicationContext(),postList);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        requestQueue.add(jsonArrayRequest);
    }

}