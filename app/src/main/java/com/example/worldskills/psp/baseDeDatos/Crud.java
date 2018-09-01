package com.example.worldskills.psp.baseDeDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.worldskills.psp.Entidades.DefectsLogVo;
import com.example.worldskills.psp.Entidades.ProjectVo;
import com.example.worldskills.psp.Entidades.TimeLogVo;
import com.example.worldskills.psp.pantallas.TimeLog;

import java.util.ArrayList;

public class Crud extends SQLiteOpenHelper {
    ArrayList<ProjectVo> listaProject;
    ArrayList<TimeLogVo> listaTimeLog;
    ArrayList<DefectsLogVo> listaDefectLog;
    public Crud(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_project(idProject integer primary key autoincrement,nombre text,tiempoEstimado int)");
        db.execSQL("create table tb_timeLog(idTime integer primary key autoincrement,phase text,startDays text,startMinutes text,interruption integer,stopDays text,stopMinutes text,Comments text,idProject integer)");
        db.execSQL("create table tb_defectLog(idDefect integer primary key autoincrement,dateDays text,dateMinutes text,type text,phaseInject text,phaseRemove text,fixTime text,defectDescription text,idTime integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tb_project");
        db.execSQL("drop table if exists tb_timeLog");
        db.execSQL("drop table if exists tb_defectLog");
        db.execSQL("create table tb_project(idProject integer primary key autoincrement,nombre text,tiempoEstimado integer)");
        db.execSQL("create table tb_timeLog(idTime integer primary key autoincrement,phase text,startDays text,startMinutes text,interruption integer,stopDays text,stopMinutes text,Comments text,idProject integer)");
        db.execSQL("create table tb_defectLog(idDefect integer primary key autoincrement,dateDays text,dateMinutes text,type text,phaseInject text,phaseRemove text,fixTime text,defectDescription text,idTime integer)");
    }
    public void insertar(Context context, String table, ContentValues registro){
        Crud crud=new Crud(context,"psp",null,1);
        SQLiteDatabase db=crud.getWritableDatabase();
        db.insert(table,null,registro);
    }
    public void modificar(Context context,String table,String id,ContentValues registro){
        Crud crud=new Crud(context,"psp",null,1);
        SQLiteDatabase db=crud.getWritableDatabase();
        db.update(table,registro,"id="+id,null);
    }
    public void consultarProject(Context context, ArrayList<ProjectVo> listaProject){
        this.listaProject=listaProject;
        Crud crud=new Crud(context,"psp",null,1);
        SQLiteDatabase db=crud.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from tb_project",null);
        while (cursor.moveToNext()){
            listaProject.add(new ProjectVo(cursor.getString(1),cursor.getString(2)));
        }
        cursor.close();
    }
    public void consultarTimeLog(Context context,String id,ArrayList<TimeLogVo> listaTimeLog){
        this.listaTimeLog=listaTimeLog;
        Crud crud=new Crud(context,"psp",null,1);
        SQLiteDatabase db=crud.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from tb_timeLog where idProject="+id,null);
        while (cursor.moveToNext()){
            listaTimeLog.add(new TimeLogVo(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8)));
        }
        cursor.close();

    }
    public void consultarDefectsLog(Context context,ArrayList<DefectsLogVo> listaDefectLog){
        this.listaDefectLog=listaDefectLog;
        Crud crud=new Crud(context,"psp",null,1);
        SQLiteDatabase db=crud.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from tb_defectLog",null);
        while (cursor.moveToNext()){
            listaDefectLog.add(new DefectsLogVo(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8)));
        }
        cursor.close();
    }
}
