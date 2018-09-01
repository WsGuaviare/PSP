package com.example.worldskills.psp.pantallas;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.sax.StartElementListener;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.worldskills.psp.R;
import com.example.worldskills.psp.baseDeDatos.Crud;
import com.example.worldskills.psp.convertTime.ConvertTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.util.Date;

public class TimeLog extends AppCompatActivity {
    Spinner phase;
    EditText etstart, etstop,interrupciones,delta,descripcion;
    Button start,stop,registrar;
    DateFormat horas = new SimpleDateFormat("HH:mm:ss");//formato para traer la hora
    DateFormat days = new SimpleDateFormat("yyyy/MM/dd");//formato para traer la fecha
    String phaseBd;//tomamos el valor del spinner
    String startBd;//tomamos la hora en la que se inicio
    String stopBD;//tomamos la hora en la que finalizo
    String startDias;
    String stopDias;
    String interrupcionesBd;
    String deltaBd;
    String commentsBd;
    String projectId;
    ConvertTime convertir = new ConvertTime();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_log);
        projectId=getIntent().getStringExtra("projectId");
        phase = findViewById(R.id.phase);
        etstart = findViewById(R.id.etstart);
        etstop = findViewById(R.id.etstop);
        interrupciones = findViewById(R.id.interrupciones);
        delta = findViewById(R.id.delta);
        descripcion = findViewById(R.id.descripcion);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        registrar = findViewById(R.id.registrar);

        etstop.setEnabled(false);
        etstart.setEnabled(false);
        delta.setEnabled(false);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registro();
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarStart();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarStop();
            }
        });


        //creamos el adapdador para el spinner
        ArrayAdapter<CharSequence> lista = ArrayAdapter.createFromResource(this,R.array.phase_array,android.R.layout.simple_spinner_item);
        phase.setAdapter(lista);

        phase.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                phaseBd = String.valueOf(parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void registro() {
        commentsBd = descripcion.getText().toString();

        if (phaseBd.trim().equals("none") || startBd.trim().equals("") || stopBD.trim().equals("") || deltaBd.trim().equals("")){
            Toast.makeText(getApplicationContext(),"Algún campo requerido esta vacio",Toast.LENGTH_SHORT).show();
        }else {
            AlertDialog.Builder alert = new AlertDialog.Builder(TimeLog.this);
            alert
                    .setTitle("Todos los campos son correctos?")
                    .setCancelable(false)
                    .setMessage("Phase: "+phaseBd+"\nStart: "+ startBd + "\nStop: "+stopBD + "\nInterruption: "+ interrupcionesBd + "\nDelta: "+deltaBd+"\nComments:" +commentsBd)
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Crud crud=new Crud(TimeLog.this,"psp",null,1);
                            ContentValues registro=new ContentValues();
                            Toast.makeText(getApplicationContext(),projectId,Toast.LENGTH_SHORT).show();
                            registro.put("phase",phaseBd);registro.put("startDays",startDias);registro.put("startMinutes",startBd);registro.put("interruption",interrupcionesBd);registro.put("stopDays",stopDias);registro.put("stopMinutes",stopBD);registro.put("comments",commentsBd);registro.put("idProject",projectId);
                            crud.insertar(TimeLog.this,"tb_timeLog",registro);
                            etstart.setText("");etstop.setText("");interrupciones.setText("");delta.setText("");descripcion.setText("");
                            startDias="";startBd="";stopBD="";stopDias="";interrupcionesBd="";deltaBd="";commentsBd="";
                            start.setEnabled(true);stop.setEnabled(true);
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //nada
                        }
                    });
            AlertDialog mostrar = alert.create();
            mostrar.show();
        }
    }

    private void asignarStop() {
        if (interrupciones.getText().toString().trim().equals("")){
            interrupciones.setText("0");
            interrupciones.setEnabled(false);
        }else{
            Date date=new Date();
            String dias = days.format(date.getTime());
            String tiempo = horas.format(date.getTime());
            stopBD = tiempo;
            stopDias=dias;
            interrupcionesBd = interrupciones.getText().toString();
            int interrupcionesDato = Integer.parseInt(interrupciones.getText().toString());
            etstop.setText(dias+" "+tiempo);
            String resultado = convertir.cambiarTiempo(startBd,stopBD,interrupcionesDato);
            deltaBd = resultado;
            delta.setText(resultado);
        }
        stop.setEnabled(false);
    }


    private void asignarStart() {
        Date date=new Date();
        String dias = days.format(date.getTime());
        String tiempo = horas.format(date.getTime());
        startBd = tiempo;
        startDias=dias;
        etstart.setText(dias+" "+tiempo);
        start.setEnabled(false);
    }
}
