package com.example.sebastianstrus.recyclerviewusingdiffutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    // variables
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: started");
        initImageBitmaps();

        initRecyclerView();
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmapds");
        for(int i=0; i<20; i++){
            mImageUrls.add("http://placehold.it/120x120&text=image" + i);
            mNames.add("MyName" + i);
        }
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recycler view");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, mImageUrls, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}