package YoutubeAPI;

import android.content.Context;
import android.util.Log;

import com.apphunters.splashscreen.R;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Movies.Movie;

/**
 * Created by sean on 7/2/18.
 */

public class YoutubeServicer {
    private YouTube youtube;
    private YouTube.Search.List query;

    // Your developer key goes here
    public static final String KEY = "";
    public static final String YOUTUBE_BASE_URL = "https://www.youtube.com/watch?v=";

    public YoutubeServicer(Context context) {
        youtube = new YouTube.Builder(new NetHttpTransport(),
                new JacksonFactory(), new HttpRequestInitializer() {
            @Override
            public void initialize(HttpRequest hr) throws IOException {}
        }).setApplicationName(context.getString(R.string.app_name)).build();

        try{
            query = youtube.search().list("id,snippet");
            query.setKey(KEY);
            query.setType("video");
            query.setFields("items(id/videoId,snippet/title,snippet/description,snippet/thumbnails/default/url)");
            query.setMaxResults(5l);
        }catch(IOException e){
            Log.d("YC", "Could not initialize: "+e);
        }
    }

    public List<Movie> search(String keywords) throws IOException {
        query.setQ(keywords);

            SearchListResponse response = query.execute();
            List<SearchResult> results = response.getItems();

            List<Movie> items = new ArrayList<Movie>();
            for(SearchResult result : results){
                Movie item = new Movie();
                item.setTitle(result.getSnippet().getTitle());
                item.setDescription(result.getSnippet().getDescription());
                item.setThumbnailURL(result.getSnippet().getThumbnails().getDefault().getUrl());
                item.setId(result.getId().getVideoId());
                items.add(item);
                item.setUrl(YOUTUBE_BASE_URL+result.getId().getVideoId());
            }return items;

    }
    
}
