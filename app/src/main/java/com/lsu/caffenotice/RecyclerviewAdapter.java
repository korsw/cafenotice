package com.lsu.caffenotice;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHodler> {

    private ArrayList<String> mData = null;

    public class ViewHodler extends RecyclerView.ViewHolder{
        ImageView logo;

        ViewHodler(View itemView){
            super(itemView);

            logo = itemView.findViewById(R.id.logoView);
        }
    }

    RecyclerviewAdapter(ArrayList<String> list){
        mData = list;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
