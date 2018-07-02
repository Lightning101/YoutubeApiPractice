package com.apphunters.splashscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import Movies.AFIMovies;

public class MainActivity extends AppCompatActivity {
    public static final String DEVELOPER_KEY = "AIzaSyC2xjKyd5GRyhxxu9cGTwQ5mOFQ5nYkZcA";

    ListView listView;
    ArrayAdapter<String> listAdapter;
    ArrayList<String> options ;
    private AFIMovies movieGenerator;
    private static final String OPTIONS_KEY = "Movie_List";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        movieGenerator = new AFIMovies();

        if (savedInstanceState != null) {

            options = savedInstanceState.getStringArrayList(OPTIONS_KEY);
        }else
        {
            options = new ArrayList<>();

            movieGenerator.chooseFilmList();

            for(int i = 0; i<5; i++)
            {
                options.add( movieGenerator.getFilm(movieGenerator.getFilmNumber(i)));
            }
        }


        listAdapter = new ArrayAdapter<String>(this,R.layout.list_layout,options);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Links.class);

                intent.putExtra("Movie", (String)listView.getItemAtPosition(position));
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(OPTIONS_KEY,options);
    }
}
