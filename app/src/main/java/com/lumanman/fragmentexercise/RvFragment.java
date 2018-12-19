package com.lumanman.fragmentexercise;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class RvFragment extends Fragment {
    public RecyclerView rv;
    private Context context;
    private RvCallBack rvCallBack;

    interface RvCallBack{
        public void getClickedText(String text);
    }

    public RvFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rv, container, false);
        rv = view.findViewById(R.id.rv);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false);

        final ArrayList<String> titleList = new ArrayList<>();
        titleList.add("Title A");
        titleList.add("Title B");
        titleList.add("Title C");
        titleList.add("Title D");
        titleList.add("Title E");
        titleList.add("Title F");
        titleList.add("Title G");

        MyAdapter myAdapter = new MyAdapter(titleList, new CellCallback() {
            @Override
            public void cellClicked(int clicked) {
                if (rvCallBack == null) {
                    return;
                }
                rvCallBack.getClickedText(titleList.get(clicked));

            }
        });

        rv.setLayoutManager(layoutManager);
        rv.setAdapter(myAdapter);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setRvCallBack(RvCallBack rvCallBack) {
        this.rvCallBack = rvCallBack;
    }


}
