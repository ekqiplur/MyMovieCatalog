package com.example.ekqi.mymoviecatalog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MovieItem>movieItems;

    public void setMovieItems(ArrayList<MovieItem>movieItems){
        this.movieItems=movieItems;
    }

    public MovieAdapter(Context context){
        this.context = context;
        movieItems = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int i) {
        return movieItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_movie,viewGroup,false);
        }
        MovieItem item = (MovieItem)getItem(i);
        TextView txtJudul = view.findViewById(R.id.txtnama);
        TextView txtDesc = view.findViewById(R.id.txtdescription);
        ImageView imgPhoto = view.findViewById(R.id.img_photo);
        txtJudul.setText(item.getName());
        txtDesc.setText(item.getDescription());
        imgPhoto.setImageResource(item.getPhoto());
        return view;
    }
}
