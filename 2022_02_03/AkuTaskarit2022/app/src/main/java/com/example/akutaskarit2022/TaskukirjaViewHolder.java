package com.example.akutaskarit2022;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class TaskukirjaViewHolder extends RecyclerView.ViewHolder {
    private final TextView TaskukirjaNroItemView;
    private final TextView TaskukirjaNimiItemView;
    private final Button infoButton;


    private TaskukirjaViewHolder(View itemView) {
        super(itemView);
        TaskukirjaNroItemView = itemView.findViewById(R.id.textViewNro);
        TaskukirjaNimiItemView=itemView.findViewById(R.id.textViewnimi);
        infoButton=itemView.findViewById(R.id.buttonInfo);
    }

    public void bind(Taskukirja taskukirja) {

        String nro= taskukirja.getNumber();
        String nimi=taskukirja.getName();
        Log.d("TaskukirjaViewHolder", "Arvot: "+nro+" "+nimi);

        TaskukirjaNroItemView.setText(nro);
        TaskukirjaNimiItemView.setText(nimi);
    }

    static TaskukirjaViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new TaskukirjaViewHolder(view);
    }

    public Button getInfoButton(){
        return this.infoButton;
    }
}
