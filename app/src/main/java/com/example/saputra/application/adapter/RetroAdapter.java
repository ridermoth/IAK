package com.example.saputra.application.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saputra.application.HomeActivity;
import com.example.saputra.application.R;
import com.example.saputra.application.RetroActivity;
import com.example.saputra.application.model.ExampleRetro;
import com.example.saputra.application.model.HomeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Verdiyanto Saputra on 17/05/2017.
 */

public class RetroAdapter extends RecyclerView.Adapter<RetroAdapter.ViewHolder> {

    private List<ExampleRetro> mRetroModels;
    private Context mContext;

    public RetroAdapter(List<ExampleRetro> mRetroModels, Context context) {
        this.mRetroModels = mRetroModels;
        this.mContext = context;
    }

    @Override
    public RetroAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_home_view, parent, false);
        return new RetroAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RetroAdapter.ViewHolder holder, int position) {

        ExampleRetro retroModel = mRetroModels.get(position);

        holder.textView1.setText(retroModel.getJudul());
        holder.textView2.setText(retroModel.getTentang());
        holder.textView3.setText(retroModel.getIsi());

        if(retroModel.getTentang().equals("Love")){
            holder.cardView.setCardBackgroundColor(Color.parseColor("#FFC0CB"));
        }
    }

    @Override
    public int getItemCount() {
        return mRetroModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView1, textView2, textView3;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView1 = (TextView) itemView.findViewById(R.id.tv_judul);
            textView2 = (TextView) itemView.findViewById(R.id.tv_tentang);
            textView3 = (TextView) itemView.findViewById(R.id.tv_isi);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if(v.getId() == R.id.card_view){
                Intent intent = new Intent(mContext.getApplicationContext(), RetroActivity.class);
                intent.putExtra("judul", ((TextView) v.findViewById(R.id.tv_judul)).getText());
                intent.putExtra("tentang", ((TextView) v.findViewById(R.id.tv_tentang)).getText());
                intent.putExtra("isi", ((TextView) v.findViewById(R.id.tv_isi)).getText());
                mContext.startActivity(intent);
            }
        }
    }
}
