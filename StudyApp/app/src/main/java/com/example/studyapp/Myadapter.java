package com.example.studyapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Myadapter extends ArrayAdapter {
    ArrayList<Customview> items;
    String[] urls;
    public Myadapter(Context context, int layout, ArrayList<Customview> items, String[] urls){
         super(context, layout);
         this.items=items;
         this.urls=urls;
    }
    public void update(ArrayList<Customview> results){
        items=new ArrayList<>();
        items.addAll(results);
        notifyDataSetChanged();
    }

    public static class ViewHolder{
        TextView tv1;
        ImageView imageview;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        row=convertView;
        ViewHolder viewHolder;
        if(row==null)
        {
            row= LayoutInflater.from(getContext()).inflate(R.layout.my_list_item,parent,false);
            viewHolder= new ViewHolder();
            viewHolder.imageview=row.findViewById(R.id.image);
            viewHolder.tv1= row.findViewById(R.id.company);
            row.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder) row.getTag();
        }
        viewHolder.imageview.setImageResource(items.get(position).image);
        viewHolder.tv1.setText(items.get(position).companyname);
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openLinksIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urls[position]));
                getContext().startActivity(openLinksIntent);

            }
        });
        return row;
    }
}
