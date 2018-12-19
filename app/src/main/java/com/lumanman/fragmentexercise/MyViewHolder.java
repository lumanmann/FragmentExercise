package com.lumanman.fragmentexercise;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    private CellCallback cellCallback;

    public  MyViewHolder(View view) {
        super(view);
        textView = view.findViewById(R.id.textView2);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cellCallback == null) {
                    return;
                }
                cellCallback.cellClicked(getLayoutPosition());
            }
        });

    }

    public void setCellCallback(CellCallback cellCallback){
        this.cellCallback = cellCallback;
    }
}