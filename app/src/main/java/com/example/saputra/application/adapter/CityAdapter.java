package com.example.saputra.application.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saputra.application.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Verdiyanto Saputra on 13/05/2017.
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private ArrayList<City> cities;
    private Context context;

    public CityAdapter(Context context,ArrayList<City> cities) {
        this.cities= cities;
        this.context = context;
    }

    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CityAdapter.ViewHolder holder, int position) {
        holder.city_name.setText(cities.get(position).getCityName());
        Picasso.with(context).load(cities.get(position).getImageUrl()).resize(240, 120).into(holder.city_image);
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView city_name;
        private ImageView city_image;
        public ViewHolder(View view) {
            super(view);

            city_name = (TextView)view.findViewById(R.id.tv_city);
            city_image = (ImageView) view.findViewById(R.id.img_city);
        }
    }
}
