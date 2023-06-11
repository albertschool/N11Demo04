package com.example.n11demo04.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.n11demo04.R;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int images[];
    String stringsList[];
    LayoutInflater inflater;

    public CustomAdapter(Context context, int[] images, String[] stringsList) {
        this.context = context;
        this.images = images;
        this.stringsList = stringsList;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return stringsList.length;
    }

    @Override
    public Object getItem(int position) {
        return stringsList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.custom_lv_layout, parent, false);
        ImageView img = (ImageView) view.findViewById(R.id.iV);
        TextView str = (TextView) view.findViewById(R.id.tV);
        str.setText(stringsList[i]);
        img.setImageResource(images[i]);
        return view;
    }
}
