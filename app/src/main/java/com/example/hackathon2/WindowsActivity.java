package com.example.hackathon2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class WindowsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windows);

        sendGETRequestWithToken(LoginActivity.access);
    }



    public void sendGETRequestWithToken(String token) {
        String url = "http://makarovv25.pythonanywhere.com/api/current-user-devices/";

        RequestQueue queue = Volley.newRequestQueue(this);

        // Создайте GET запрос с использованием JsonObjectRequest
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Обработка успешного ответа от сервера
                        try {
                            JSONObject jsonObject = response.getJSONObject(0);
                            Toast.makeText(WindowsActivity.this, "huy" + jsonObject.getString("name"), Toast.LENGTH_SHORT).show();


                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Обработка ошибки
                        Toast.makeText(WindowsActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                // Создайте заголовок Authorization с Bearer token
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer " + token);
                return headers;
            }
        };

        // Добавьте запрос в очередь
        queue.add(request);
    }
}