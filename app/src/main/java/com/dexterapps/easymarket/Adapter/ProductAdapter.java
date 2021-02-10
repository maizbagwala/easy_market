package com.dexterapps.easymarket.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dexterapps.easymarket.R;
import com.dexterapps.easymarket.model.Product;
import com.dexterapps.easymarket.utils.Functions;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    ArrayList<Product> products;


    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override

    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_list, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.addtocart_btn.setOnClickListener(v -> {
            holder.addtocart_btn.startAnimation(Functions.FadeAnimationButton());
            holder.addtocart_btn.setVisibility(View.GONE);
            holder.linearLayout.setVisibility(View.VISIBLE);

        });

        holder.qty_minus.setOnClickListener(v -> {
            if (holder.qty_txt.getText().equals("1")) {
                holder.addtocart_btn.setVisibility(View.VISIBLE);
                holder.linearLayout.setVisibility(View.GONE);
            } else {

            }
        });


    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView addtocart_btn, qty_txt, qty_plus, qty_minus;
        LinearLayout linearLayout;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            addtocart_btn = itemView.findViewById(R.id.add_to_cart_btn);
            linearLayout = itemView.findViewById(R.id.pm_ll);
            qty_txt = itemView.findViewById(R.id.qty_txt);
            qty_minus = itemView.findViewById(R.id.qty_minus);
            qty_plus = itemView.findViewById(R.id.qty_plus);
        }
    }
}
