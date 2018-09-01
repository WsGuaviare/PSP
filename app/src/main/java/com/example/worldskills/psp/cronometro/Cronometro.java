package com.example.worldskills.psp.cronometro;

import android.os.SystemClock;
import android.widget.Chronometer;

public class Cronometro {

    Boolean running = false; //con esta variable sabemos si el chronometro esta iniciaizado
    long detenerse;// la utilizamos para detener el chronometro


    //iniciamos el chronometro
    public void iniciarChronometro(Chronometer chronometro){
        if (running){
            chronometro.setBase(SystemClock.elapsedRealtime() - detenerse);
            chronometro.start();
            running = true;
        }

    }

    //pausamos el chronometro
    public void pausarChronometro(Chronometer chronometro){
        chronometro.stop();
        detenerse = SystemClock.elapsedRealtime() - chronometro.getBase();
        running = false;
    }

    //reiniciamos el Chronometro
    public void reiniciarChronometro(Chronometer chronometro){
        chronometro.setBase(SystemClock.elapsedRealtime());
        detenerse = 0;
        chronometro.stop();
    }
}
