package com.fathanpklkt.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private ArrayList<WatchModel> modelList;

    private OnItemClickListener mItemClickListener;

    public ListMovieAdapter(Context context, ArrayList<WatchModel> modelList){
        this.mContext = context;
        this.modelList = modelList;
    }

    public void updateList(ArrayList<WatchModel> modelList){
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
            final WatchModel model = getItem(position);
            ViewHolder genericViewHolder = (ViewHolder) holder;

            genericViewHolder.itemTxtTitle.setText(model.getTitle());

            if(model.getOverview().length()>50){
                genericViewHolder.itemTxtOverview.setText(model.getOverview().substring(0,49)+" ...");
            }else{
                genericViewHolder.itemTxtOverview.setText(model.getOverview());
            }

            genericViewHolder.imgPoster.setImageResource(model.getPoster());
        }


    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener){
        this.mItemClickListener = mItemClickListener;
    }

    private WatchModel getItem(int position) {
        return modelList.get(position);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position,WatchModel model);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPoster;
        private TextView itemTxtTitle, itemTxtOverview;
        public ViewHolder(final View itemView){
            super(itemView);

            imgPoster = itemView.findViewById(R.id.img_poster);
            itemTxtTitle = itemView.findViewById(R.id.item_txt_title);
            itemTxtOverview = itemView.findViewById(R.id.item_txt_overview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView,getAdapterPosition(), modelList.get(getAdapterPosition()));
                }
            });

        }
    }
}
