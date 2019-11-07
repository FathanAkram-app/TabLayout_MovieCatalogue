package com.fathanpklkt.myapplication;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ListTvShowViewModel extends ViewModel {
    private ArrayList<WatchModel> modelList = new ArrayList<>();

    public void addTvShowModel(String title, String overview, Integer poster){
        this.modelList.add(new WatchModel(title,overview,poster));
    }

    public ArrayList<WatchModel> getModelList(){
        return modelList;
    }
}
