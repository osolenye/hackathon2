package com.example.hackathon2.forRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathon2.Data.Window;
import com.example.hackathon2.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<Window> windows;

    public MyAdapter(Context context, List<Window> windows) {
        this.context = context;
        this.windows = windows;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textView_arduinoNumber.setText(windows.get(position).getNumArduino());
        holder.textView_windowName.setText(windows.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return windows.size();
    }
}
