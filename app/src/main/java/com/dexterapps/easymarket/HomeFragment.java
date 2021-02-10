package com.dexterapps.easymarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dexterapps.easymarket.Adapter.CategoryAdapter;
import com.dexterapps.easymarket.Adapter.ProductAdapter;
import com.dexterapps.easymarket.model.Category;
import com.dexterapps.easymarket.model.Product;
import com.dexterapps.easymarket.utils.Functions;
import com.jama.carouselview.CarouselView;
import com.jama.carouselview.enums.IndicatorAnimationType;
import com.jama.carouselview.enums.OffsetType;

import java.util.ArrayList;
import java.util.Objects;

public class HomeFragment extends Fragment {
    CarouselView carouselView;
    RecyclerView recyclerView_category, recyclerView_product;
    CategoryAdapter categoryAdapter;
    ProductAdapter productAdapter;
    int[] images = {R.drawable.i1,
            R.drawable.i2};

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        ArrayList<Category> category = new ArrayList<>();
        ArrayList<Product> product = new ArrayList<>();

        category.add(new Category("1", "", "maiz"));
        category.add(new Category("2", "", "maiz"));
        category.add(new Category("3", "", "maiz"));
        category.add(new Category("4", "", "maiz"));
        category.add(new Category("5", "", "maiz"));


        product.add(new Product("1", "maiz", "maiz", "12", "741"));
        product.add(new Product("2", "maiz", "maiz", "12", "741"));
        product.add(new Product("3", "maiz", "maiz", "12", "741"));
        product.add(new Product("4", "maiz", "maiz", "12", "741"));
        product.add(new Product("5", "maiz", "maiz", "12", "741"));

        recyclerView_category = view.findViewById(R.id.rv_category);
        recyclerView_product = view.findViewById(R.id.rv_products);
        categoryAdapter = new CategoryAdapter(getContext(), category, true);
        productAdapter = new ProductAdapter(getContext(), product);


        carouselView = view.findViewById(R.id.c_top);
        showCarousel();

        recyclerView_category.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recyclerView_category.setAdapter(categoryAdapter);

        recyclerView_product.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView_product.setAdapter(productAdapter);

        view.findViewById(R.id.tv_products_new_offer).startAnimation(Functions.BlinkAnimation());
        view.findViewById(R.id.tv_category_view_all).setOnClickListener(v -> {
            startActivity(new Intent(getContext(), CategoryActivity.class));
            Functions.FadeAnimation(Objects.requireNonNull(getActivity()));

        });
//        Functions.AddStrike(view.findViewById(R.id.tv_products_new_offer));
        return view;
    }

    void showCarousel() {
        carouselView.setSize(images.length);
        carouselView.setResource(R.layout.image_carousel_item);
        carouselView.setAutoPlay(true);
        carouselView.hideIndicator(true);
        carouselView.setIndicatorAnimationType(IndicatorAnimationType.THIN_WORM);
        carouselView.setCarouselOffset(OffsetType.CENTER);
        carouselView.setCarouselViewListener((view1, position) -> {
            // Example here is setting up a full image carousel
            ImageView imageView = view1.findViewById(R.id.imageView);
//            imageView.setImageDrawable(getResources().getDrawable(images[position]));
            imageView.setImageDrawable(ResourcesCompat.getDrawable(Objects.requireNonNull(getContext()).getResources(), images[position], getContext().getTheme()));

        });
        // After you finish setting up, show the CarouselView
        carouselView.show();

    }
}