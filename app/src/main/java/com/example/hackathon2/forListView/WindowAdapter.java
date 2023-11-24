package com.example.hackathon2.forListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hackathon2.Data.Window;
import com.example.hackathon2.Data.WindowLV;
import com.example.hackathon2.R;
//import com.example.hackathon2.R;

import java.util.ArrayList;

public class WindowAdapter extends ArrayAdapter<WindowLV> {
    public WindowAdapter(Context context, ArrayList<WindowLV> windowLVArrayList) {
        super(context, R.layout.item_view, windowLVArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        WindowLV windowLV = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_view, parent, false);
        }

        TextView textView_arduinoNumber = convertView.findViewById(R.id.textView_arduinoNumber);
        TextView textView_windowName = convertView.findViewById(R.id.textView_windowName);

        textView_windowName.setText(windowLV.getName());
        textView_arduinoNumber.setText(windowLV.getNumArduino());

        return convertView; // Возвращаем обновленное представление элемента списка
    }
}


