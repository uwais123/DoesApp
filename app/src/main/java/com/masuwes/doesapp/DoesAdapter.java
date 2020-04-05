package com.masuwes.doesapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DoesAdapter extends RecyclerView.Adapter<DoesAdapter.MyViewHolder> {

    Context context;
    ArrayList<MyDoes> myDoes;

    public DoesAdapter(Context c, ArrayList<MyDoes> p) {
        context = c;
        myDoes = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_does, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.titledoes.setText(myDoes.get(position).getTitledoes());
        holder.descdoes.setText(myDoes.get(position).getDescdoes());
        holder.datedoes.setText(myDoes.get(position).getDatedoes());

        final String getTitleDoes = myDoes.get(position).getTitledoes();
        final String getDescDoes = myDoes.get(position).getDescdoes();
        final String getDateDoes = myDoes.get(position).getDatedoes();
        final String getKeyDoes = myDoes.get(position).getKeydoes();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(context, EditTaskDoes.class);
                I.putExtra("titledoes", getTitleDoes);
                I.putExtra("descdoes", getDescDoes);
                I.putExtra("datedoes", getDateDoes);
                I.putExtra("keydoes", getKeyDoes);
                context.startActivity(I);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myDoes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titledoes, descdoes, datedoes, keydoes;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titledoes = itemView.findViewById(R.id.titleDoes);
            descdoes = itemView.findViewById(R.id.descDoes);
            datedoes = itemView.findViewById(R.id.dateDoes);
        }
    }
}
