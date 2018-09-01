package com.example.worldskills.psp.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.worldskills.psp.R;

import java.util.ArrayList;

public class AdapterProject extends RecyclerView.Adapter<AdapterProject.listViewHolder> implements View.OnClickListener{
    ArrayList<String> lista;
    private View.OnClickListener listener;

    public AdapterProject(ArrayList<String> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public AdapterProject.listViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list,null,false);
        return new listViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProject.listViewHolder listViewHolder, int i) {
        listViewHolder.project.setText(lista.get(i));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }

    }

    class listViewHolder extends RecyclerView.ViewHolder {
        TextView project;
        public listViewHolder(@NonNull View itemView) {
            super(itemView);
            project=itemView.findViewById(R.id.projectId);
        }
    }
}
