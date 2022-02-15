package com.example.akutaskarit2022;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.google.android.material.snackbar.Snackbar;

public class TaskukirjaListAdapter  extends ListAdapter<Taskukirja, TaskukirjaViewHolder> {
    private final String TAG = "Miksan softa - adapter";
    private Taskukirja taskukirja;
    public TaskukirjaListAdapter(@NonNull DiffUtil.ItemCallback<Taskukirja> diffCallback) {
        super(diffCallback);
        taskukirja=null;
    }

    @Override
    public TaskukirjaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TaskukirjaViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(TaskukirjaViewHolder holder, int position) {

        Taskukirja current = getItem(position);
        Log.d(TAG, "onBindViewHolder() -  "+ current.getNumber());
        holder.bind(current);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskukirja=current;
                Snackbar.make(v, "Valittiin:"+current.getNumber(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button button = holder.getInfoButton();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskukirja=current;
                Snackbar.make(view, "Nappulaa painettu:"+current.getNumber(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    public Taskukirja getTaskukirja(){
        return taskukirja;
    }
    static class TaskukirjaDiff extends DiffUtil.ItemCallback<Taskukirja> {

        @Override
        public boolean areItemsTheSame(@NonNull Taskukirja oldItem, @NonNull Taskukirja newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Taskukirja oldItem, @NonNull Taskukirja newItem) {
            return oldItem.getNumber().equals(newItem.getNumber());
        }
    }
}