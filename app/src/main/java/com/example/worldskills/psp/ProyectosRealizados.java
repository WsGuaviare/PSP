package com.example.worldskills.psp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ProyectosRealizados extends AppCompatActivity {
    Button timeLog,defectLog,projectSummary;
    ImageView volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyectos_realizados);
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

            }
        });
    }
}
