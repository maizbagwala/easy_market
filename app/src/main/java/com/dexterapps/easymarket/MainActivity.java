package com.dexterapps.easymarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.android.volley.Request;
import com.dexterapps.easymarket.network.ApiRequest;
import com.dexterapps.easymarket.utils.Functions;
import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        navigationView = findViewById(R.id.nav_view1);
        drawerLayout = findViewById(R.id.drawer_layout);


        loadFragment(new HomeFragment());
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjE2ODc1MjQ5MDhhMGUzZTg5MzIwM2E2MjdmMzMwZTA5NWI4ZWU3NmM2OGMyY2U0ZWNlMjExOWIwZDBjOGI5NDQ4YjE2NmQ1N2JmNDZiMTJlIn0.eyJhdWQiOiIxIiwianRpIjoiMTY4NzUyNDkwOGEwZTNlODkzMjAzYTYyN2YzMzBlMDk1YjhlZTc2YzY4YzJjZTRlY2UyMTE5YjBkMGM4Yjk0NDhiMTY2ZDU3YmY0NmIxMmUiLCJpYXQiOjE2MTE1ODA0NzEsIm5iZiI6MTYxMTU4MDQ3MSwiZXhwIjoxNjQzMTE2NDcxLCJzdWIiOiIyMCIsInNjb3BlcyI6W119.OGf0fYKPVeYJO2sJstOZq1Rk1HALRcDtdBvTYaa63zSzLxxlqDL6KZlvKp7yGQP5Zaf9lDXIYgbZ71CkUQ0-3KCIxWBxmOPUrfnMZT_whkMxtEbgRICAL6YTrxpSpNag6yMfRQkr1mOUo3T1xhAXufnVT7O1fXftTdHcC6MXYbz4OT3tcgUQ5b-ZGOzMleYH7XMTMG1LV_EwHZxokx0eBkWCZPmsY70D16owS1Q_OMJHGfhh3Oyg07F-XWkRYIALaVi-FimUQnlr4Hl8jNcpacU894DoSKMeZ1mgSDtuguLRWdZrGjiJeYkKlBeGhGmaRWHiLaTFBrLW_bMKM-m5Bm2UMGB461hp_NEHkdq8oKIYh16C7dGmNXmi6BXhjrmksiq9AvFVHJlupMU1gmp0aJgvVHv1rpesfHn2d2WXQlnmVgLmiLttzKQnS2rrYi3YXYd2KKkQb8luK0GSbaVipMQtCH85U28yfuBcC96iDv05FABnQQtBgupoE-l5QXvzBevX36bIrrj8hAZ6QlCMWYRAa9FX4FMSwLzg8IZGefX2PA3yh_VXwZAehuOH1e080Yhq-NtTVnccN3-o2EH7VVVCrf11AHOlYcB3Gr_v7UPbtJd_dzqXzYWtOx9gruWZRU3984AzUbvw_2h6ZeHHxbZgu4O6eGTDILpDKk3nzS8");
        ApiRequest.Call_Api(this, Request.Method.GET, "https://neubought.com/api/v1/carts/20", null, response -> {
        }, headers);


        findViewById(R.id.nav_btn).setOnClickListener(v -> {
            ((DrawerLayout) findViewById(R.id.drawer_layout)).openDrawer(Gravity.LEFT);

//            Snackbar.make(v, "maiz is gajjab", Snackbar.LENGTH_LONG).show();

        });
        findViewById(R.id.search_btn).setOnClickListener(v -> {
            startActivity(new Intent(this, SearchActivity.class));
        });

        findViewById(R.id.nav_home).setOnClickListener(v -> {
            loadFragment(new HomeFragment());
        });
        findViewById(R.id.nav_category).setOnClickListener(v -> {
//            loadFragment(new CategoryFragment());
            if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                drawerLayout.closeDrawer(Gravity.LEFT);
            }
            startActivity(new Intent(this, CategoryActivity.class));
            Functions.FadeAnimation(this);
        });
        findViewById(R.id.nav_notification).setOnClickListener(v -> {

        });
        findViewById(R.id.nav_offer).setOnClickListener(v -> {

        });
        findViewById(R.id.nav_term).setOnClickListener(v -> {

        });

        findViewById(R.id.cart_btn).setOnClickListener(v -> {
            startActivity(new Intent(this, CartActivity.class));
        });


    }

    public void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frag_container, fragment, null) // gets the second animations
                .addToBackStack(null)
                .commit();
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
    }
}