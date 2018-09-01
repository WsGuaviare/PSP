package com.example.worldskills.psp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.worldskills.psp.Adaptadores.AdapterProject;
import com.example.worldskills.psp.pantallas.DefectLog;
import com.example.worldskills.psp.pantallas.ProjectPlanSummary;
import com.example.worldskills.psp.pantallas.TimeLog;

import java.util.ArrayList;

public class ProyectosRealizados extends AppCompatActivity {
    ArrayList<String> lista;
    RecyclerView recycler;
    AdapterProject adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyectos_realizados);
        lista=new ArrayList<>();
        for(int i=0;i<50;i++){
            lista.add("#"+i);
        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter=new AdapterProject(lista);
        recycler.setAdapter(adapter);
    }
}
