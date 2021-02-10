package com.dexterapps.easymarket;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.dexterapps.easymarket.network.ApiRequest;
import com.dexterapps.easymarket.utils.Functions;
import com.dexterapps.easymarket.utils.Variables;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    EditText et_mobile, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_mobile = findViewById(R.id.et_mobile);
        et_password = findViewById(R.id.et_password);


        findViewById(R.id.login_btn).setOnClickListener(v -> {

            JSONObject parameters = new JSONObject();
            try {
                parameters.put("username", et_mobile.getText().toString());
                parameters.put("password", et_password.getText().toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            Functions.Show_Dialog(this);

            HashMap<String, String> headers = new HashMap<>();
            headers.put("Auth", "value");

            ApiRequest.Call_Api(this, Request.Method.POST, Variables.LOGIN_URL, parameters, response -> {
                Functions.Cancel_Dialog();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.get("error_id") != null) {
                        int response_id = (int) jsonObject.get("error_id");
                        if (response_id == 0) {
                            startActivity(new Intent(this, MainActivity.class));
                            finish();
                        }
                        Toast.makeText(this, "" + jsonObject.get("error_msg"), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }, headers);


        });
    }
}