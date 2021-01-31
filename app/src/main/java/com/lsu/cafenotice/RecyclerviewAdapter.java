package com.lsu.cafenotice;

import android.content.Context;
import android.view.LayoutInflater;
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

            //logo = itemView.findViewById(R.id.logoView);
        }
    }

    RecyclerviewAdapter(ArrayList<String> list){
        mData = list;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.activity_recyclerview_item, parent, false);
        ViewHodler VH = new RecyclerviewAdapter.ViewHodler(view);

        return VH;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {
        //gra text = mData.get(position);
        //holder.logo.setImageIcon();

    }

    @Override
    public int getItemCount() {
        return  mData.size();
    }
}
