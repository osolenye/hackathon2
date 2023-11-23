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

public class RegistrationActivity extends AppCompatActivity {
    static String name;
    static String password;


    Button button_registration;
    EditText editText_name;
    EditText editText_password;
    EditText getEditText_password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        button_registration = findViewById(R.id.button_registration);
        editText_name = findViewById(R.id.editText_name_reg);
        editText_password = findViewById(R.id.editText_password_reg);
        getEditText_password2 = findViewById(R.id.editText_password_reg2);


        button_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText_name.getText().toString().isEmpty() || editText_password.getText().toString().isEmpty() ||
                        getEditText_password2.getText().toString().isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Заполните все поля!", Toast.LENGTH_SHORT).show();
                } else if(!editText_password.getText().toString().equals(getEditText_password2.getText().toString())) {
                    Toast.makeText(RegistrationActivity.this, "Пароли должны совпадать!", Toast.LENGTH_SHORT).show();
                }
                else {
                    name = editText_name.getText().toString();
                    password = editText_password.getText().toString();
                    Registrate(name, password);
                }
            }
        });


    }

    private void Registrate(String name, String password) {
        String url = "http://makarovv25.pythonanywhere.com/api/register/";

        RequestQueue queue = Volley.newRequestQueue(RegistrationActivity.this);


        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // inside on response method we are
                // hiding our progress bar
                // and setting data to edit text as empty

                // on below line we are displaying a success toast message.
                Toast.makeText(RegistrationActivity.this, "Вы зарегистрированы", Toast.LENGTH_SHORT).show();
                try {
                    // on below line we are parsing the response
                    // to json object to extract data from it.
                    JSONObject respObj = new JSONObject(response);

                    // below are the strings which we
                    // extract from our json object.
//                    String name = respObj.getString("name");
//                    String job = respObj.getString("job");
                    String id = respObj.getString("message");
                    Toast.makeText(RegistrationActivity.this, id, Toast.LENGTH_SHORT).show();


//                    Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
//                    startActivity(intent);
//                    finish();
                    // on below line we are setting this string s to our text view.
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(RegistrationActivity.this, "Не удалось зарегистрироваться: " + error, Toast.LENGTH_SHORT).show();
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
                params.put("password2", password);

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