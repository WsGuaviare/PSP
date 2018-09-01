package com.example.worldskills.psp.pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.worldskills.psp.R;
import com.example.worldskills.psp.cronometro.Cronometro;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DefectLog extends AppCompatActivity {

    Spinner type,phaseInjected,phaseRemoved;
    Button startc,stop,reset;
    EditText dateCampo;
    Button generar;
    Chronometer chronometroc;
    DateFormat horas = new SimpleDateFormat("HH:mm:ss");//formato para traer la hora
    DateFormat days = new SimpleDateFormat("yyyy/MM/dd");//formato para traer la fecha
    String dateInicio;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defect_log);

        type = findViewById(R.id.type);
        phaseInjected = findViewById(R.id.phase1);
        phaseRemoved = findViewById(R.id.phase2);
        generar = findViewById(R.id.generar);
        dateCampo = findViewById(R.id.datecampo);
        chronometroc = findViewById(R.id.chronometro);
        startc = findViewById(R.id.startc);
        stop = findViewById(R.id.stop);
        reset = findViewById(R.id.reset);

        final Cronometro proceso = new Cronometro();



        startc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso.iniciarChronometro(chronometroc);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso.pausarChronometro(chronometroc);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso.reiniciarChronometro(chronometroc);
            }
        });



        generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generarTiempo();
            }
        });

        //creamos el adapdador para el spinner
        ArrayAdapter<CharSequence> lista = ArrayAdapter.createFromResource(this,R.array.type,android.R.layout.simple_spinner_item);
        type.setAdapter(lista);

        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String.valueOf(parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //creamos el adapdador para el spinner
        ArrayAdapter<CharSequence> phase1 = ArrayAdapter.createFromResource(this,R.array.phase_array,android.R.layout.simple_spinner_item);
        phaseInjected.setAdapter(phase1);

        phaseInjected.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String.valueOf(parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //creamos el adapdador para el spinner
        ArrayAdapter<CharSequence> phase2 = ArrayAdapter.createFromResource(this,R.array.phase_array,android.R.layout.simple_spinner_item);
        phaseRemoved.setAdapter(phase2);

        phaseRemoved.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 String.valueOf(parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void generarTiempo() {
        Date date = new Date();
        String dias = days.format(date.getTime());
        String tiempo = horas.format(date.getTime());
        dateInicio = tiempo;
        dateCampo.setText(dias+" "+tiempo);
    }
}
