package com.example.ekqi.mymoviecatalog;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class MovieDetail extends AppCompatActivity {

    private TextView txtJudul, txtRating, txtRilis, txtDesc;
    private CircleImageView imgFilm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        MovieItem content = getIntent().getParcelableExtra("MOVIES");

        getSupportActionBar().setTitle(content.getName());

        txtJudul = (TextView)findViewById(R.id.detailJudul);
        txtDesc = (TextView)findViewById(R.id.detailOverview);
        txtRating = (TextView)findViewById(R.id.detailVote);
        txtRilis = (TextView)findViewById(R.id.detailReleaseDate);
        imgFilm = (CircleImageView)findViewById(R.id.imgfilmbg);

        txtJudul.setText(content.getName());
        txtRilis.setText(content.getRilis());

        txtRating.setText(content.getRate()+"/10");
        txtDesc.setText(content.getDescription());

        Picasso.with(this).load(content.getPhoto()).into(imgFilm);
    }
}
