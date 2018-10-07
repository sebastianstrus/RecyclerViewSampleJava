package com.example.sebastianstrus.recyclerviewusingdiffutil;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Person> mPersons = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<Person> mPersons, Context mContext) {
        this.mPersons = mPersons;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mPersons.get(position).getImageUrl())
                .into(holder.imageIV);

        holder.nameTV.setText(mPersons.get(position).getName());

        holder.buttonX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clickedon: " + mPersons.get(position).getName());
                Toast.makeText(mContext, "XXX " + mPersons.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPersons.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageIV;
        TextView nameTV;
        Button buttonX;


        RelativeLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageIV = itemView.findViewById(R.id.id_imageView);
            nameTV = itemView.findViewById(R.id.id_taxtview);

            buttonX = itemView.findViewById(R.id.id_buttonX);


        }
    }
}
