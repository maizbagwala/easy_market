package com.dexterapps.easymarket.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dexterapps.easymarket.R;
import com.dexterapps.easymarket.model.Category;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context;
    ArrayList<Category> categories;
    boolean isGrid;

    public CategoryAdapter(Context context, ArrayList<Category> categories, boolean isGrid) {
        this.context = context;
        this.categories = categories;
        this.isGrid = isGrid;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        if (isGrid) {

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_grid_item, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_item, parent, false);

        }

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
