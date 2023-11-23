package com.example.hackathon2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity {
    static String access;
    Button button_login;
    EditText editText_name;
    EditText editText_password;
    String name;
    String password;
    Button button_goToWindows;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button_login = findViewById(R.id.button_login);
        editText_name = findViewById(R.id.editText_name);
        editText_password = findViewById(R.id.editText_password);
        button_goToWindows = findViewById(R.id.button_goToWindows);
        button_goToWindows.setVisibility(View.GONE);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText_name.getText().toString().isEmpty() || editText_password.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Заполните оба поля!", Toast.LENGTH_SHORT).show();
                } else {
                    name = editText_name.getText().toString();
                    password = editText_password.getText().toString();
                    Login(name, password);
                }
            }
        });
        button_goToWindows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, WindowsActivity.class);
                startActivity(intent);
            }
        });
    }

    public void Login(String name, String password) {
        String url = "http://makarovv25.pythonanywhere.com/api/token/";

        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // inside on response method we are
                // hiding our progress bar
                // and setting data to edit text as empty


                // on below line we are displaying a success toast message.
                Toast.makeText(LoginActivity.this, "Вы вошли", Toast.LENGTH_SHORT).show();
                try {
                    // on below line we are parsing the response
                    // to json object to extract data from it.
                    JSONObject respObj = new JSONObject(response);

                    // below are the strings which we
                    // extract from our json object.
                    access = respObj.getString("access");

                    // on below line we are setting this string s to our text view.
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                button_goToWindows.setVisibility(View.VISIBLE);
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(LoginActivity.this, "ошибка: " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // below line we are creating a map for
                // storing our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("username", name);
                params.put("password", password);

                // at last we are
                // returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }

}