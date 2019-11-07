package com.fathanpklkt.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ListMovie extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListMovieAdapter mAdapter;

    private ArrayList<WatchModel> modelList = new ArrayList<>();
    public static final String SELECTED_MOVIE = "selected_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);
        findViews();
        setAdapter();
    }

    private void findViews(){
        recyclerView = findViewById(R.id.recycler_view);
    }

    private void setAdapter(){

        modelList.add(new WatchModel(getResources().getString(R.string.title_a_star), getString(R.string.overview_a_star),R.drawable.poster_a_star));
        modelList.add(new WatchModel(getResources().getString(R.string.title_aquaman), getResources().getString(R.string.overview_aquaman),R.drawable.poster_aquaman));
        modelList.add(new WatchModel(getResources().getString(R.string.title_avengerinfinity), getResources().getString(R.string.overview_avengerinfinity),R.drawable.poster_avengerinfinity));
        modelList.add(new WatchModel(getResources().getString(R.string.title_birdbox), getResources().getString(R.string.overview_birdbox),R.drawable.poster_birdbox));
        modelList.add(new WatchModel(getResources().getString(R.string.title_bohemian), getResources().getString(R.string.overview_bohemian),R.drawable.poster_bohemian));
        modelList.add(new WatchModel(getResources().getString(R.string.title_bumblebee), getResources().getString(R.string.overview_bumblebee),R.drawable.poster_bumblebee));
        modelList.add(new WatchModel(getResources().getString(R.string.title_creed), getResources().getString(R.string.overview_creed),R.drawable.poster_creed));
        modelList.add(new WatchModel(getResources().getString(R.string.title_deadpool), getResources().getString(R.string.overview_deadpool),R.drawable.poster_deadpool));
        modelList.add(new WatchModel(getResources().getString(R.string.title_dragon), getResources().getString(R.string.overview_dragon),R.drawable.poster_dragon));
        modelList.add(new WatchModel(getResources().getString(R.string.title_dragonball), getResources().getString(R.string.overview_dragonball),R.drawable.poster_dragonball));
        modelList.add(new WatchModel(getResources().getString(R.string.title_glass), getResources().getString(R.string.overview_glass),R.drawable.poster_glass));
        modelList.add(new WatchModel(getResources().getString(R.string.title_hunterkiller), getResources().getString(R.string.overview_hunterkiller),R.drawable.poster_hunterkiller));
        modelList.add(new WatchModel(getResources().getString(R.string.title_marrypopins), getResources().getString(R.string.overview_marrypopins),R.drawable.poster_marrypopins));
        modelList.add(new WatchModel(getResources().getString(R.string.title_mortalengine), getResources().getString(R.string.overview_mortalengine),R.drawable.poster_mortalengine));
        modelList.add(new WatchModel(getResources().getString(R.string.title_preman), getResources().getString(R.string.overview_preman),R.drawable.poster_preman));
        modelList.add(new WatchModel(getResources().getString(R.string.title_robinhood), getResources().getString(R.string.overview_robinhood),R.drawable.poster_robinhood));
        modelList.add(new WatchModel(getResources().getString(R.string.title_spiderman), getResources().getString(R.string.overview_spiderman),R.drawable.poster_spiderman));
        modelList.add(new WatchModel(getResources().getString(R.string.title_thegirl), getResources().getString(R.string.overview_thegirl),R.drawable.poster_thegirl));
        modelList.add(new WatchModel(getResources().getString(R.string.title_themule), getResources().getString(R.string.overview_themule),R.drawable.poster_themule));
        modelList.add(new WatchModel(getResources().getString(R.string.title_venom), getResources().getString(R.string.overview_venom),R.drawable.poster_venom));

        mAdapter = new ListMovieAdapter(ListMovie.this,modelList);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        mAdapter.SetOnItemClickListener(new ListMovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, WatchModel model) {

            }
        });
    }
}
