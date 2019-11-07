package com.fathanpklkt.myapplication;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ListMoviesViewModel extends ViewModel {
    private ArrayList<WatchModel> modelList = new ArrayList<>();

    public void addMovieModel(String title, String overview, Integer poster){
        this.modelList.add(new WatchModel(title,overview,poster));
    }

    public ArrayList<WatchModel> getModelList(){
        return modelList;
    }
}
