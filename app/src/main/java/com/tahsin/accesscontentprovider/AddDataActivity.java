package com.tahsin.accesscontentprovider;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Tahsin Rahman
 * on 31,October,2018
 */
public class AddDataActivity extends AppCompatActivity {

    @BindView(R.id.editTextMovieName)
    EditText editTextMovieName;
    @BindView(R.id.editTextReleaseYear)
    EditText editTextReleaseYear;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        setTitle(R.string.title_add_movies);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.buttonSave)
    void onButtonClick () {

        storeMoviesToProvider();

    }

    private void storeMoviesToProvider() {

        String name = editTextMovieName.getText().toString();
        String year = editTextReleaseYear.getText().toString();

        if (TextUtils.isEmpty(name) && TextUtils.isEmpty(year))
            Toast.makeText(this, "Please fill up all the fields.", Toast.LENGTH_SHORT).show();
        else {

            String AUTHORITY = "tahsin.com.testcontentprovider.provider.MovieList";
            String PATH = "/movies";
            Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + PATH);
            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("release_year", year);
            Uri putUri = getContentResolver().insert(CONTENT_URI, values);

            if(putUri != null)
                Toast.makeText(this, "Data submission successful", Toast.LENGTH_SHORT).show();
            else {
                Toast.makeText(this, "Invalid uri!", Toast.LENGTH_SHORT).show();

            }
        }

        finish();
    }

}
