package com.example.worldskills.psp;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.worldskills.psp.Adaptadores.AdapterProject;
import com.example.worldskills.psp.Entidades.ProjectVo;
import com.example.worldskills.psp.baseDeDatos.Crud;
import com.example.worldskills.psp.pantallas.DefectLog;
import com.example.worldskills.psp.pantallas.Menu;
import com.example.worldskills.psp.pantallas.ProjectPlanSummary;
import com.example.worldskills.psp.pantallas.TimeLog;

import java.util.ArrayList;

public class ProyectosRealizados extends AppCompatActivity {
    ArrayList<ProjectVo> lista;
    RecyclerView recycler;
    AdapterProject adapter;
    Button crearProject;
    EditText projectName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyectos_realizados);
        projectName=findViewById(R.id.projectNameId);
        crearProject=findViewById(R.id.crearProject);
        recycler=findViewById(R.id.contenedor);
        lista=new ArrayList<>();
        adaptador();
        crearProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lista=new ArrayList<>();
                Crud crud=new Crud(ProyectosRealizados.this,"psp",null,1);
                ContentValues registro = new ContentValues();
                registro.put("nombre",projectName.getText().toString());
                registro.put("tiempoEstimado","0");
                crud.insertar(ProyectosRealizados.this,"tb_project",registro);
                adaptador();
                projectName.setText("");
            }
        });
    }
    public void adaptador(){
        Crud crud=new Crud(this,"psp",null,1);
        crud.consultarProject(this,lista);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter=new AdapterProject(lista);
        recycler.setAdapter(adapter);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProyectosRealizados.this,Menu.class);
                intent.putExtra("projectId",String.valueOf((recycler.getChildAdapterPosition(v))+1));
                Toast.makeText(ProyectosRealizados.this,String.valueOf((recycler.getChildAdapterPosition(v))+1),Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }

}
