package com.example.akutaskarit2022;

import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class TaskukirjaListAdapter  extends ListAdapter<Taskukirja, TaskukirjaViewHolder> {
    private final String TAG = "Miksan softa - adapter";
    public TaskukirjaListAdapter(@NonNull DiffUtil.ItemCallback<Taskukirja> diffCallback) {
        super(diffCallback);
    }

    @Override
    public TaskukirjaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TaskukirjaViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(TaskukirjaViewHolder holder, int position) {

        Taskukirja current = getItem(position);
        Log.d(TAG, "onBindViewHolder() -  "+ current.getNumber());
        holder.bind(current.getNumber()+ " "+ current.getName());
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