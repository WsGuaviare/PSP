package com.example.worldskills.psp.pantallas;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.worldskills.psp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.util.Date;

public class TimeLog extends AppCompatActivity {
    Spinner phase;
    EditText etstart, etstop,interrupciones,delta,descripcion;
    Button start,stop,registrar;
    DateFormat horas = new SimpleDateFormat("HH:mm:ss");

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
                horaStart();
            }
        });


        //creamos el adapdador para el spinner
        ArrayAdapter<CharSequence> lista = ArrayAdapter.createFromResource(this,R.array.phase_array,android.R.layout.simple_spinner_item);
        phase.setAdapter(lista);
    }

    private void horaStart() {
        

    }
}
