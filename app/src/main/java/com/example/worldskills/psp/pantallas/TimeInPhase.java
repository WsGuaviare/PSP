package com.example.worldskills.psp.pantallas;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.worldskills.psp.Entidades.TimeLogVo;
import com.example.worldskills.psp.R;
import com.example.worldskills.psp.baseDeDatos.Crud;
import com.example.worldskills.psp.convertTime.ConvertTime;

import java.util.ArrayList;

public class TimeInPhase extends AppCompatActivity {
    TextView planTime,dldTime,codeTime,compileTime,utTime,pmTime,planPorcentaje,dldPorcentaje,codePorcentaje,compilePorcentaje,utPorcentaje,pmPorcentaje;
    EditText estimado;
    Button guardar;
    ArrayList<TimeLogVo> lista;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lista=new ArrayList<>();
        setContentView(R.layout.activity_time_in_phase);
        id=getIntent().getStringExtra("projectId");
        estimado=findViewById(R.id.estimadoId);
        planTime=findViewById(R.id.tiempoTotalPlan);
        dldTime=findViewById(R.id.tiempoTotalDLD);
        codeTime=findViewById(R.id.tiempoTotalCode);
        compileTime=findViewById(R.id.tiempoTotalCompile);
        utTime=findViewById(R.id.tiempoTotalUt);
        pmTime=findViewById(R.id.tiempoTotalPm);
        planPorcentaje=findViewById(R.id.porcentajePlan);
        dldPorcentaje=findViewById(R.id.porcentajeDLD);
        codePorcentaje=findViewById(R.id.porcentajeCode);
        compilePorcentaje=findViewById(R.id.porcentajeCompile);
        utPorcentaje=findViewById(R.id.porcentajeUt);
        pmPorcentaje=findViewById(R.id.porcentajePm);
        guardar=findViewById(R.id.tiempoEstimadoId);
        Crud crud=new Crud(TimeInPhase.this,"psp",null,1);
        crud.consultarTimeLog(this, id, lista);
        String tiempoPlan="00:00:00",tiempoDld="00:00:00",tiempoCode="00:00:00",tiempoCompile="00:00:00",tiempoUt="00:00:00",tiempoPm="00:00:00";
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getPhase().equals("PLAN")){
                ConvertTime convertTime=new ConvertTime();
                String resultado=convertTime.cambiarTiempo(lista.get(i).getStartMinutes(),lista.get(i).getStopMinutes(),Integer.valueOf(lista.get(i).getInterruption()));
                tiempoPlan=convertTime.sumarTime(tiempoPlan,resultado,0);
            }
            else if(lista.get(i).getPhase().equals("DLD")) {
                ConvertTime convertTime = new ConvertTime();
                String resultado = convertTime.cambiarTiempo(lista.get(i).getStartMinutes(), lista.get(i).getStopMinutes(), Integer.valueOf(lista.get(i).getInterruption()));
                tiempoDld = convertTime.sumarTime(tiempoDld, resultado, 0);
            }
            else if(lista.get(i).getPhase().equals("CODE")) {
                ConvertTime convertTime = new ConvertTime();
                String resultado = convertTime.cambiarTiempo(lista.get(i).getStartMinutes(), lista.get(i).getStopMinutes(), Integer.valueOf(lista.get(i).getInterruption()));
                tiempoCode = convertTime.sumarTime(tiempoCode, resultado, 0);
            }
            else if(lista.get(i).getPhase().equals("COMPILE")) {
                ConvertTime convertTime = new ConvertTime();
                String resultado = convertTime.cambiarTiempo(lista.get(i).getStartMinutes(), lista.get(i).getStopMinutes(), Integer.valueOf(lista.get(i).getInterruption()));
                tiempoCompile = convertTime.sumarTime(tiempoCompile, resultado, 0);
            }
            else if(lista.get(i).getPhase().equals("UT")) {
                ConvertTime convertTime = new ConvertTime();
                String resultado = convertTime.cambiarTiempo(lista.get(i).getStartMinutes(), lista.get(i).getStopMinutes(), Integer.valueOf(lista.get(i).getInterruption()));
                tiempoUt = convertTime.sumarTime(tiempoUt, resultado, 0);
            }
            else if(lista.get(i).getPhase().equals("PM")) {
                ConvertTime convertTime = new ConvertTime();
                String resultado = convertTime.cambiarTiempo(lista.get(i).getStartMinutes(), lista.get(i).getStopMinutes(), Integer.valueOf(lista.get(i).getInterruption()));
                tiempoPm = convertTime.sumarTime(tiempoPm, resultado, 0);
            }
        }
        planTime.setText(tiempoPlan);dldTime.setText(tiempoDld);codeTime.setText(tiempoCode);compileTime.setText(tiempoCompile);utTime.setText(tiempoUt);pmTime.setText(tiempoPm);

        final String finalTiempoPlan = tiempoPlan;
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Crud crud=new Crud(TimeInPhase.this,"psp",null,1);
                ContentValues registro=new ContentValues();
                registro.put("tiempoEstimado",estimado.getText().toString());
                ConvertTime convertTime=new ConvertTime();
                //crud.modificar(TimeInPhase.this,"tb_project",id,registro);
                planPorcentaje.setText(String.valueOf(convertTime.cambiarMillis(finalTiempoPlan)*100/Integer.valueOf(estimado.getText().toString())*60000));
            }
        });

    }
}
