package com.example.studyapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyNewAdapter extends RecyclerView.Adapter<MyNewAdapter.ViewHolder> {
    RecyclerView recyclerView;
    Context context;
    ArrayList<String> items;
    ArrayList<String> urls;

    public void update(String name,String url)
    {
        items.add(name);
        urls.add(url);
        notifyDataSetChanged();

    }

    public MyNewAdapter(RecyclerView recyclerView,Context context,ArrayList<String> items,ArrayList<String> urls){
        this.urls=urls;
        this.recyclerView=recyclerView;
        this.context=context;
        this.items=items;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameOfFile.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameOfFile;
        public ViewHolder(View itemView){
            super(itemView);
            nameOfFile=itemView.findViewById(R.id.nameOfFile);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=recyclerView.getChildLayoutPosition(view);
                    Intent intent=new Intent();
                    intent.setType(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(urls.get(position)));
                    context.startActivity(intent);

                }
            });


        }
    }
}
