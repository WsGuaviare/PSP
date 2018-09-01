package com.example.worldskills.psp.pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.worldskills.psp.ProyectosRealizados;
import com.example.worldskills.psp.R;

public class Menu extends AppCompatActivity {
    Button timeLog,defectLog,projectSummary;
    ImageView volver;
    String projectName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        projectName=getIntent().getStringExtra("projectId");
        timeLog=findViewById(R.id.timeLogId);
        defectLog=findViewById(R.id.defectLogId);
        projectSummary=findViewById(R.id.projectSummaryId);
        volver=findViewById(R.id.volver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        timeLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this, TimeLog.class);
                intent.putExtra("projectId",projectName);
                startActivity(intent);
            }
        });
        defectLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this, DefectLog.class);
                intent.putExtra("projectId",projectName);
                startActivity(intent);
            }
        });
        projectSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this, ProjectPlanSummary.class);
                intent.putExtra("projectId",projectName);
                startActivity(intent);
            }
        });
    }
}
