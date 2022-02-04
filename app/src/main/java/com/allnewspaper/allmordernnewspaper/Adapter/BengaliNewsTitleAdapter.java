package com.allnewspaper.allmordernnewspaper.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.allnewspaper.allmordernnewspaper.Model.BengaliNewsTitle;
import com.allnewspaper.allmordernnewspaper.Model.CategoriesTitle;
import com.allnewspaper.allmordernnewspaper.Model.RecyclerViewInterface;
import com.allnewspaper.allmordernnewspaper.R;

import java.util.ArrayList;

public class BengaliNewsTitleAdapter extends RecyclerView.Adapter<BengaliNewsTitleAdapter.MyViewHolder> {
    Context context;

    int[] image;
    private final RecyclerViewInterface recyclerViewInterface;

    public BengaliNewsTitleAdapter(Context context,  int[] image, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.image = image;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.bengali_news_list,parent,false);
      MyViewHolder myViewHolder=new MyViewHolder(view,recyclerViewInterface);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       holder.imageView.setImageResource(image[position]);


    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView,RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageView=itemView.findViewById(R.id.news_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface!=null)
                    {
                        int pos=getAdapterPosition();
                        if (pos!=RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
