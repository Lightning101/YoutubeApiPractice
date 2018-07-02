package com.apphunters.splashscreen;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import Movies.Movie;
import YoutubeAPI.YoutubeServicer;

public class Links extends AppCompatActivity {

    Intent caller;
    Handler handler;
    ListView listView;
    String movieName;
    public static final int ERROR_MSG_ID = 21;
    public static final int BUTTON_ID = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);
        // Get the Intent that started the activity
        caller = getIntent();
        // Get the movie name off the intent
        movieName = caller.getStringExtra("Movie");
        // Link the variable to actual layout element
        listView = findViewById(R.id.linksListView);
        // Use handler to do aync ui changes
        handler = new Handler();
        runSearch();
    }



    public void searchComplete(List<Movie> movies)
    {
        ArrayAdapter<Movie> moiveAdapter = new ArrayAdapter<Movie>(getApplicationContext(),R.layout.movie_list_layout,movies)
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                if(convertView == null){
                    convertView = getLayoutInflater().inflate(R.layout.movie_list_layout, parent, false);
                }
                ImageView image  = (ImageView) convertView.findViewById(R.id.movie_image);
                TextView title = (TextView) convertView.findViewById(R.id.movie_title);
                TextView description = (TextView) convertView.findViewById(R.id.movie_description);

                Movie selectedMovie = getItem(position);
                Picasso.with(getApplicationContext()).load(selectedMovie.getThumbnailURL()).into(image);
                title.setText(selectedMovie.getTitle());
                description.setText(selectedMovie.getDescription());

                return convertView;
            }
        };
        listView.setAdapter(moiveAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movie movie = (Movie) listView.getItemAtPosition(i);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse(movie.getUrl()));
                startActivity(browserIntent);
            }
        });
    }

    public void setDefaultView()
    {

    }

    public void runSearch()
    {

        Thread networkThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    YoutubeServicer youtubeAPI = new YoutubeServicer(getApplicationContext());

                    final List<Movie> movies = youtubeAPI.search(movieName);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            searchComplete(movies);
                        }
                    });


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        networkThread.start();

    }

}
