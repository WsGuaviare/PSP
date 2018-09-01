package com.example.worldskills.psp.convertTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ConvertTime {
    String [] timeStart,timeEnd;
    DateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
    public String cambiarTiempo(Date dateStart,Date dateEnd,int interruption){
        timeStart=dateFormat.format(dateStart).split(":");
        timeEnd=dateFormat.format(dateEnd).split(":");
        int resultado=-1;
        int horas1=((Integer.valueOf(timeStart[0]))/(60*60000))%24;
        int horas2=((Integer.valueOf(timeEnd[0]))/(60*60000))%24;
        int min1=((Integer.valueOf(timeStart[1]))/(60000))%60;
        int min2=((Integer.valueOf(timeEnd[1]))/(60000))%60;
        int seg1=((Integer.valueOf(timeStart[2]))/(1000))%60;
        int seg2=((Integer.valueOf(timeEnd[2]))/(1000))%60;
        int millis1=horas1+min1+seg1;
        int millis2=horas2+min2+seg2;
        if(millis2<millis1 && (millis2-millis1)>(interruption*60000)) {
            resultado = (millis2 - millis1) - (interruption * 60000);
        }else return "Algun dato no cumple las condiciones";
        return cambiarMillis(resultado);

    }
    private String  cambiarMillis(int resultado){



        return "";
    }
}
