package com.example.hackathon2.forRecyclerView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathon2.R;

import org.w3c.dom.Text;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView textView_arduinoNumber;
    TextView textView_windowName;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        textView_arduinoNumber = itemView.findViewById(R.id.textView_arduinoNumber);
        textView_windowName = itemView.findViewById(R.id.textView_windowName);
    }
}
