package com.dexterapps.easymarket;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dexterapps.easymarket.Adapter.ProductAdapter;
import com.dexterapps.easymarket.model.Product;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter productAdapterforsearch;
    TextInputEditText search_et;
    ArrayList<Product> newproduct = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recyclerView = findViewById(R.id.rv_search);
        search_et = findViewById(R.id.search_et);

        ArrayList<Product> product = new ArrayList<>();


        product.add(new Product("1", "maiz", "maiz", "12", "741"));
        product.add(new Product("2", "maiz", "maiz", "12", "741"));
        product.add(new Product("3", "maiz", "maiz", "12", "741"));
        product.add(new Product("4", "maiz", "maiz", "12", "741"));
        product.add(new Product("5", "maiz", "maiz", "12", "741"));


        productAdapterforsearch = new ProductAdapter(this, product);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(productAdapterforsearch);

        search_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {

                newproduct.clear();
                for (Product pro :
                        product) {
                    if (pro.getTitle().toLowerCase().contains(editable.toString())) {
                        newproduct.add(pro);
                    }
                }
//                productAdapterforsearch = new ProductAdapter(SearchActivity.this, newproduct);
//                recyclerView.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
//                recyclerView.setAdapter(productAdapterforsearch);
//                productAdapterforsearch.notifyDataSetChanged();

//                productAdapterforsearch = new ProductAdapter(SearchActivity.this, newproduct);
//                recyclerView.setAdapter(productAdapterforsearch);
//                recyclerView.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
//                productAdapterforsearch.notifyDataSetChanged();
            }
        });
    }
}