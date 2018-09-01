package com.example.worldskills.psp.pantallas;

import android.os.SystemClock;
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
    String phaseBd;
    String startBd;//tomamos la hora en la que se inicio
    String stopBD;//tomamos la hora en la que finalizo
    ConvertTime convertir = new ConvertTime();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_log);
        phase = findViewById(R.id.phase);
        etstart = findViewById(R.id.etstart);
        etstop = findViewById(R.id.etstop);
        interrupciones = findViewById(R.id.interrupciones);
        delta = findViewById(R.id.delta);
        descripcion = findViewById(R.id.descripcion);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        registrar = findViewById(R.id.registrar);

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
                Toast.makeText(getApplicationContext(),""+phaseBd,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






    }

    private void asignarStop() {
        Date date=new Date();
        String dias = days.format(date.getTime());
        String tiempo = horas.format(date.getTime());
        stopBD = tiempo;
        int interrupcionesDato = Integer.parseInt(interrupciones.getText().toString());
        etstop.setText(dias+" "+tiempo);
        String resultado = convertir.cambiarTiempo(startBd,stopBD,interrupcionesDato);
        delta.setText(resultado);
    }


    private void asignarStart() {
        Date date=new Date();
        String dias = days.format(date.getTime());
        String tiempo = horas.format(date.getTime());
        startBd = tiempo;
        etstart.setText(dias+" "+tiempo);
    }
}
