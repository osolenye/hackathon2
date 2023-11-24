package com.example.hackathon2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.hackathon2.Data.Window;

import java.util.ArrayList;

public class DetailsActivity2 extends AppCompatActivity {
    ArrayList<Window> windows = WindowsActivity.windows;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2);

        EditText editText_details = findViewById(R.id.editText_details);

        int id = getIntent().getIntExtra("id", -1);

        Window win = windows.get(id);

        Window window = new Window(); // Ваш объект Window

// Формируем строку с человеческими названиями и значениями полей
        String displayText = "ID: " + window.getId() + "\n" +
                "Номер Arduino: " + window.getNumArduino() + "\n" +
                "Имя: " + window.getName() + "\n" +
                "Температура: " + window.getTemperature() + "\n" +
                "Влажность: " + window.getVlazhnost() + "\n" +
                "Газ: " + window.getGaz() + "\n" +
                "Окна открыты: " + window.isWindowsAreOpened() + "\n" +
                "Окна заблокированы: " + window.isWindowsAreBlocked() + "\n" +
                "ID устройства: " + window.getIdDevice() + "\n" +
                "ID пользователя: " + window.getUser();

// Устанавливаем сформированную строку в EditText
        editText_details.setText(displayText);

    }
}