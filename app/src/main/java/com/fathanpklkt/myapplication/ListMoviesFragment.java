package com.fathanpklkt.myapplication;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListMoviesFragment extends Fragment {
    private ListMoviesViewModel mViewModel;
    private ListMovieAdapter mAdapter;

    public static ListMoviesFragment newInstance(){
        return new ListMoviesFragment();
    }


    public ListMoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_movies, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        mViewModel = ViewModelProviders.of(this).get(ListMoviesViewModel.class);
        mViewModel.addMovieModel(getResources().getString(R.string.title_a_star), getString(R.string.overview_a_star),R.drawable.poster_a_star);
        mViewModel.addMovieModel(getResources().getString(R.string.title_aquaman), getResources().getString(R.string.overview_aquaman),R.drawable.poster_aquaman);
        mViewModel.addMovieModel(getResources().getString(R.string.title_avengerinfinity), getResources().getString(R.string.overview_avengerinfinity),R.drawable.poster_avengerinfinity);
        mViewModel.addMovieModel(getResources().getString(R.string.title_birdbox), getResources().getString(R.string.overview_birdbox),R.drawable.poster_birdbox);
        mViewModel.addMovieModel(getResources().getString(R.string.title_bohemian), getResources().getString(R.string.overview_bohemian),R.drawable.poster_bohemian);
        mViewModel.addMovieModel(getResources().getString(R.string.title_bumblebee), getResources().getString(R.string.overview_bumblebee),R.drawable.poster_bumblebee);
        mViewModel.addMovieModel(getResources().getString(R.string.title_creed), getResources().getString(R.string.overview_creed),R.drawable.poster_creed);
        mViewModel.addMovieModel(getResources().getString(R.string.title_deadpool), getResources().getString(R.string.overview_deadpool),R.drawable.poster_deadpool);
        mViewModel.addMovieModel(getResources().getString(R.string.title_dragon), getResources().getString(R.string.overview_dragon),R.drawable.poster_dragon);
        mViewModel.addMovieModel(getResources().getString(R.string.title_dragonball), getResources().getString(R.string.overview_dragonball),R.drawable.poster_dragonball);
        mViewModel.addMovieModel(getResources().getString(R.string.title_glass), getResources().getString(R.string.overview_glass),R.drawable.poster_glass);
        mViewModel.addMovieModel(getResources().getString(R.string.title_hunterkiller), getResources().getString(R.string.overview_hunterkiller),R.drawable.poster_hunterkiller);
        mViewModel.addMovieModel(getResources().getString(R.string.title_marrypopins), getResources().getString(R.string.overview_marrypopins),R.drawable.poster_marrypopins);
        mViewModel.addMovieModel(getResources().getString(R.string.title_mortalengine), getResources().getString(R.string.overview_mortalengine),R.drawable.poster_mortalengine);
        mViewModel.addMovieModel(getResources().getString(R.string.title_preman), getResources().getString(R.string.overview_preman),R.drawable.poster_preman);
        mViewModel.addMovieModel(getResources().getString(R.string.title_robinhood), getResources().getString(R.string.overview_robinhood),R.drawable.poster_robinhood);
        mViewModel.addMovieModel(getResources().getString(R.string.title_spiderman), getResources().getString(R.string.overview_spiderman),R.drawable.poster_spiderman);
        mViewModel.addMovieModel(getResources().getString(R.string.title_thegirl), getResources().getString(R.string.overview_thegirl),R.drawable.poster_thegirl);
        mViewModel.addMovieModel(getResources().getString(R.string.title_themule), getResources().getString(R.string.overview_themule),R.drawable.poster_themule);
        mViewModel.addMovieModel(getResources().getString(R.string.title_venom), getResources().getString(R.string.overview_venom),R.drawable.poster_venom);

        mAdapter = new ListMovieAdapter(view.getContext(),mViewModel.getModelList());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);

        mAdapter.SetOnItemClickListener(new ListMovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, WatchModel model) {
                Intent det = new Intent(view.getContext(), DetailActivity.class);
                det.putExtra(ListMovie.SELECTED_MOVIE,model);
                startActivity(det);
            }
        });
    }
}
