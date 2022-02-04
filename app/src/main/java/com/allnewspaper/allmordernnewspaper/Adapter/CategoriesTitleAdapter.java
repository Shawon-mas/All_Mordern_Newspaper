package com.allnewspaper.allmordernnewspaper.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.allnewspaper.allmordernnewspaper.Model.CategoriesTitle;
import com.allnewspaper.allmordernnewspaper.R;

import java.util.ArrayList;

public class CategoriesTitleAdapter extends RecyclerView.Adapter<CategoriesTitleAdapter.ListHolder> {
    ArrayList<CategoriesTitle> categoriesTitles;
    private static ClickListener clickListener;

    public CategoriesTitleAdapter(ArrayList<CategoriesTitle> categoriesTitles) {
        this.categoriesTitles = categoriesTitles;
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_list_vie,parent,false);
        ListHolder listHolder=new ListHolder(view);
        return listHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder holder, int position) {
        CategoriesTitle categoriesTitle=categoriesTitles.get(position);

        holder.imageView.setImageResource(categoriesTitle.getCategoriesImage());
        holder.textView.setText(categoriesTitle.getCategoriesTitle());


    }

    @Override
    public int getItemCount() {
        return categoriesTitles.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;

        public ListHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.categories_image);
            textView = itemView.findViewById(R.id.categories_title);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(),view);

        }
    }
    public interface ClickListener{
        void onItemClick(int position,View view);

    }
    public void setOnItemClickListener(ClickListener clickListener){
        CategoriesTitleAdapter.clickListener=clickListener;
    }

}