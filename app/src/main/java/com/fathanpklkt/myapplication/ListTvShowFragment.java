package com.fathanpklkt.myapplication;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListTvShowFragment extends Fragment {
    private ListTvShowViewModel mViewModel;
    private ListMovieAdapter mAdapter;

    public static ListTvShowFragment newInstance(){
        return new ListTvShowFragment();
    }


    public ListTvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        mViewModel = ViewModelProviders.of(this).get(ListTvShowViewModel.class);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_arrow), getString(R.string.tv_overview_arrow),R.drawable.tv_poster_arrow);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_doom_patrol), getString(R.string.tv_overview_doom_patrol),R.drawable.tv_poster_doom_patrol);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_dragon_ball), getString(R.string.tv_overview_dragon_ball),R.drawable.tv_poster_dragon_ball);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_fairytail), getString(R.string.tv_overview_fairytail),R.drawable.tv_poster_fairytail);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_family_guy), getString(R.string.tv_overview_family_guy),R.drawable.tv_poster_family_guy);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_flash), getString(R.string.tv_overview_flash),R.drawable.tv_poster_flash);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_god), getString(R.string.tv_overview_god),R.drawable.tv_poster_god);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_gotham), getString(R.string.tv_overview_gotham),R.drawable.tv_poster_gotham);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_grey_anatomy), getString(R.string.tv_overview_grey_anatomy),R.drawable.tv_poster_grey_anatomy);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_hanna), getString(R.string.tv_overview_hanna),R.drawable.tv_poster_hanna);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_iron_fist), getString(R.string.tv_overview_iron_fist),R.drawable.tv_poster_iron_fist);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_naruto_shipudden), getString(R.string.tv_overview_naruto_shipudden),R.drawable.tv_poster_naruto_shipudden);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_ncis), getString(R.string.tv_overview_ncis),R.drawable.tv_poster_ncis);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_riverdale), getString(R.string.tv_overview_riverdale),R.drawable.tv_poster_riverdale);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_shameless), getString(R.string.tv_overview_shameless),R.drawable.tv_poster_shameless);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_supergirl), getString(R.string.tv_overview_supergirl),R.drawable.tv_poster_supergirl);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_supernatural), getString(R.string.tv_overview_supernatural),R.drawable.tv_poster_supernatural);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_the_simpson), getString(R.string.tv_overview_the_simpson),R.drawable.tv_poster_the_simpson);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_the_umbrella), getString(R.string.tv_overview_the_umbrella),R.drawable.tv_poster_the_umbrella);
        mViewModel.addTvShowModel(getResources().getString(R.string.tv_title_the_walking_dead), getString(R.string.tv_overview_the_walking_dead),R.drawable.tv_poster_the_walking_dead);
        mAdapter = new ListMovieAdapter(view.getContext(),mViewModel.getModelList());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        mAdapter.SetOnItemClickListener(new ListMovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, WatchModel model) {
                Intent inn = new Intent(view.getContext(), DetailActivity.class);
                inn.putExtra(ListMovie.SELECTED_MOVIE,model);
                startActivity(inn);
            }
        });
    }
}
