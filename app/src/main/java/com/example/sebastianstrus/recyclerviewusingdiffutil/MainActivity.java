package com.example.sebastianstrus.recyclerviewusingdiffutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    //vidgets
    private Button btnAddPerson;

    // variables
    private ArrayList<Person> mPersons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: started");
        addPeople();

        initializeVariables();

        setListeners();

        initRecyclerView();
    }

    private void initializeVariables() {
        btnAddPerson = findViewById(R.id.id_add_person_button);
    }

    private void setListeners() {
        btnAddPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewPerson(new Person("Sebastian", "https://scontent.fgse1-1.fna.fbcdn.net/v/t1.0-1/p160x160/11822377_10207249342662960_1428027601653512940_n.jpg?_nc_cat=105&oh=746ad4d23f1eead94f0bceaaa99d0ffa&oe=5C569EDD"));
            }
        });
    }

    private void addPeople() {
        Log.d(TAG, "initImageBitmaps: preparing bitmapds");
        for(int i=0; i<6; i++){
            mPersons.add(new Person("MyName" + i,"http://placehold.it/120x120&text=image" + i));
        }
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recycler view");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mPersons, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public void addNewPerson(Person person) {
        mPersons.add(person);

    }
}