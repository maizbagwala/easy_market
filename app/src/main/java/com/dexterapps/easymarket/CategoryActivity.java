package com.dexterapps.easymarket;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dexterapps.easymarket.Adapter.CategoryAdapter;
import com.dexterapps.easymarket.model.Category;
import com.dexterapps.easymarket.utils.Functions;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    CategoryAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        recyclerView = findViewById(R.id.rv_category);
        findViewById(R.id.back_btn).setOnClickListener(v -> onBackPressed());

        ArrayList<Category> category = new ArrayList<>();

        category.add(new Category("1", "", "maiz"));
        category.add(new Category("2", "", "maiz"));
        category.add(new Category("3", "", "maiz"));
        category.add(new Category("4", "", "maiz"));
        category.add(new Category("5", "", "maiz"));
        adapter = new CategoryAdapter(this, category, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        Functions.FadeAnimation(this);
    }
}