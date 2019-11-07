package com.fathanpklkt.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvOverview = findViewById(R.id.tv_txt_overview);
        ImageView imgPoster = findViewById(R.id.detailPoster);

        WatchModel watchModel = getIntent().getParcelableExtra(ListMovie.SELECTED_MOVIE);
        tvTitle.setText(watchModel.getTitle());
        tvOverview.setText(watchModel.getOverview());
        imgPoster.setImageResource(watchModel.getPoster());
        setTitle(watchModel.getTitle());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
