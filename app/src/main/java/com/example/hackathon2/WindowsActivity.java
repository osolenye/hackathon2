package com.example.hackathon2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.hackathon2.Data.Window;
//import com.example.hackathon2.databinding.ActivityMainBinding;
import com.example.hackathon2.Data.WindowLV;
import com.example.hackathon2.databinding.ActivityMainBinding;
import com.example.hackathon2.databinding.ActivityWindowsBinding;
import com.example.hackathon2.forListView.WindowAdapter;
import com.example.hackathon2.forRecyclerView.MyAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WindowsActivity extends AppCompatActivity {
    ActivityWindowsBinding binding;
//    ListView listView = findViewById(R.id.listView);
    public static ArrayList<Window> windows = new ArrayList<Window>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWindowsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String token = LoginActivity.access; // Получите токен из нужного места, если это необходимо

        String url = "https://makarovv25.pythonanywhere.com/api/current-user-devices/";

        RequestQueue queue = Volley.newRequestQueue(this);

        // Создайте GET запрос с использованием JsonObjectRequest
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<Window> windows = new ArrayList<Window>();
                        ArrayList<WindowLV> windowLVS = new ArrayList<WindowLV>();
                        // Обработка успешного ответа от сервера
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                if (jsonObject.length() == 0) {
                                    continue;
                                }




                                int id = jsonObject.getInt("id");
                                String numArduino = jsonObject.getString("numArduino");
                                String name = jsonObject.getString("name");
                                double temperature = jsonObject.getDouble("temperature");
                                double vlazhnost = jsonObject.getDouble("vlazhnost");
                                double gaz = jsonObject.getDouble("gaz");
                                boolean windowsAreOpened = jsonObject.getBoolean("windowsAreOpened");
                                boolean windowsAreBlocked = jsonObject.getBoolean("windowsAreBlocked");
                                int idDevice = jsonObject.getInt("idDevice");
                                int user = jsonObject.getInt("user");

                                // Создаем новый объект Window и добавляем его в список
                                Window window = new Window(id, numArduino, name, temperature, vlazhnost, gaz, windowsAreOpened,
                                        windowsAreBlocked, idDevice, user);
                                windows.add(window);

                                WindowLV windowLV = new WindowLV(name, numArduino);
                                windowLVS.add(windowLV);
                            }
                            WindowAdapter windowAdapter = new WindowAdapter(WindowsActivity.this, windowLVS);

                            binding.listView.setAdapter(windowAdapter);
                            binding.listView.setClickable(true);
                            binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(WindowsActivity.this, DetailsActivity2.class);
                                    intent.putExtra("id", position);
                                    startActivity(intent);
                                }
                            });

                            Toast.makeText(WindowsActivity.this, "Количество объектов Window: " + windows.size(), Toast.LENGTH_SHORT).show();

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