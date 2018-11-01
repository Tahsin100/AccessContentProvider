package com.tahsin.accesscontentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.tahsin.accesscontentprovider.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class ShowDataActivity extends AppCompatActivity {

    public static final String AUTHORITY = "tahsin.com.testcontentprovider" + ".provider.MovieList";
    public static final String PATH = "/movies";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + PATH );

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        setTitle(R.string.title_movie_list);

        recyclerView = findViewById(R.id.recyclerViewData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        Cursor cursor = getContentResolver().query(CONTENT_URI, null, null, null, null);
        List<Movie> movieList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(0);
                String name = cursor.getString(1);
                String releaseYear = cursor.getString(2);
                Movie movie = new Movie(id, name, releaseYear);
                movieList.add(movie);
            } while (cursor.moveToNext());

            MovieAdapter movieAdapter = new MovieAdapter(this, movieList);
            recyclerView.setAdapter(movieAdapter);
        }
        else {
            Toast.makeText(this, "No data to show.", Toast.LENGTH_SHORT).show();
        }

    }
}
