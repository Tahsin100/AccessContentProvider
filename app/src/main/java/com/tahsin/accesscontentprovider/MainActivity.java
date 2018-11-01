package com.tahsin.accesscontentprovider;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.buttonAddMovies) Button buttonAddMovies;
    @BindView(R.id.buttonShowMovies) Button buttonShowMovies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.buttonAddMovies, R.id.buttonShowMovies})
    void onButtonClick (View v) {

        switch (v.getId()){

            case R.id.buttonAddMovies:
                startActivity(new Intent(MainActivity.this, AddDataActivity.class));
                break;
            case R.id.buttonShowMovies:
                startActivity(new Intent(MainActivity.this, ShowDataActivity.class));
                break;
        }

    }

}
