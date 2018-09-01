package com.example.worldskills.psp.pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.worldskills.psp.R;

public class ProjectPlanSummary extends AppCompatActivity {
    Button timeInPhase,defectsInjectedInPhase,defectsRemovedInPhase;
    ImageView volver;
    String projectId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_plan_summary);
        projectId=getIntent().getStringExtra("projectId");
        volver=findViewById(R.id.volverId);
        timeInPhase=findViewById(R.id.timeInPhaseId);
        defectsInjectedInPhase=findViewById(R.id.defectInPhaseId);
        defectsRemovedInPhase=findViewById(R.id.defectRemovedInPhaseId);
        timeInPhase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProjectPlanSummary.this,TimeInPhase.class);
                intent.putExtra("projectId",projectId);
                startActivity(intent);
            }
        });
        defectsInjectedInPhase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProjectPlanSummary.this,DefectsInjectedInPhase.class);
                intent.putExtra("projectId",projectId);
                startActivity(intent);
            }
        });
        defectsRemovedInPhase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProjectPlanSummary.this,DefectsRemovedInPhase.class);
                intent.putExtra("projectId",projectId);
                startActivity(intent);
            }
        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
