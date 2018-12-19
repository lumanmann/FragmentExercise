package com.lumanman.fragmentexercise;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<String> titleList;
    private CellCallback cellCallback;

    public MyAdapter(ArrayList<String> titleList, CellCallback cellCallback) {
        this.titleList = new ArrayList<>(titleList);
        this.cellCallback = cellCallback;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof  MyViewHolder) {
            MyViewHolder myViewHolder = (MyViewHolder)viewHolder;
            myViewHolder.textView.setText(titleList.get(i));
            myViewHolder.setCellCallback(new CellCallback() {
                @Override
                public void cellClicked(int clicked) {
                    if (cellCallback == null) {
                        return;
                    }
                    cellCallback.cellClicked(clicked);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }


}
