package com.example.worldskills.psp.convertTime;

import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ConvertTime {
    String [] timeStart,timeEnd;
    DateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
    public String cambiarTiempo(String dateStart,String dateEnd,int interruption){
        timeStart=(dateStart).split(":");
        timeEnd=(dateEnd).split(":");
        int horas1=((Integer.valueOf(timeStart[0]))*(60*60000));
        int horas2=((Integer.valueOf(timeEnd[0]))*(60*60000));
        int min1=((Integer.valueOf(timeStart[1]))*(60000));
        int min2=((Integer.valueOf(timeEnd[1]))*(60000));
        int seg1=((Integer.valueOf(timeStart[2]))*(1000));
        int seg2=((Integer.valueOf(timeEnd[2]))*(1000));
        int resultado=-1;
        int millis1=horas1+min1+seg1;
        int millis2=horas2+min2+seg2;
        Log.d("verificar",String.valueOf(millis2)+"  "+String.valueOf(millis1));
        if(millis2<millis1 && (millis2-millis1)>(interruption*60000)) {
            resultado = (millis2 - millis1) - (interruption * 60000);
        }else return "Algun dato no cumple las condiciones";
        return cambiarMillis(resultado);

    }
    private String  cambiarMillis(int resultado){
        int horas=((Integer.valueOf(resultado))/(60*60000))%24;
        int min=((Integer.valueOf(resultado))/(60000))%60;
        int seg=((Integer.valueOf(resultado))/(1000))%60;
        String hour=String.format("%02d",horas);
        String minutes=String.format("%02d",min);
        String seconds=String.format("%02d",seg);


        return hour+":"+minutes+":"+seconds;
    }
}
