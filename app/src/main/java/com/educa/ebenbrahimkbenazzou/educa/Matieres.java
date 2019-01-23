package com.educa.ebenbrahimkbenazzou.educa;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matieres extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_matieres, container, false);
        ListView listView = (ListView) view.findViewById(R.id.lsCour);
        ArrayList<Integer> data = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 11, 12, 13, 14, 15, 16, 17));
        MyAdapter adapter = new MyAdapter(getContext(), data);
        listView.setAdapter(adapter);
        return view;
    }
}

class MyAdapter extends ArrayAdapter {

    List list;

    public MyAdapter(Context context, List objects) {
        super(context, 0, objects);
        list = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.viewcours, parent, false);
        }

        return convertView;
    }
}