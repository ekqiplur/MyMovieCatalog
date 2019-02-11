package com.example.ekqi.mymoviecatalog;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    String[] judulFilm;
    String[] Descript, rilis, rate;
    TypedArray Phoster;
    MovieAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new MovieAdapter(this);
        listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MovieItem item = new MovieItem();
                item.setName(judulFilm[i]);
                item.setDescription(Descript[i]);
                item.setRate(rate[i]);
                item.setRilis(rilis[i]);
                item.setPhoto(Phoster.getResourceId(i, -1));
                Intent detailIntent = new Intent(MainActivity.this, MovieDetail.class);
                detailIntent.putExtra("MOVIES",item);
                startActivity(detailIntent);
            }
        });
    }

    private void prepare() {
        judulFilm = getResources().getStringArray(R.array.judulfilm);
        Descript = getResources().getStringArray(R.array.description);
        Phoster = getResources().obtainTypedArray(R.array.poster);
        rilis = getResources().getStringArray(R.array.tangal_rilis);
        rate = getResources().getStringArray(R.array.rating);
    }

    private void addItem() {
        ArrayList<MovieItem> movieItems = new ArrayList<>();

        for (int i = 0; i < judulFilm.length; i++) {
            MovieItem item = new MovieItem();
            item.setPhoto(Phoster.getResourceId(i, -1));
            item.setName(judulFilm[i]);
            item.setDescription(Descript[i]);
            movieItems.add(item);
        }

        adapter.setMovieItems(movieItems);
    }
}
