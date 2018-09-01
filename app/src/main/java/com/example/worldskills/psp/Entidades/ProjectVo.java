package com.example.worldskills.psp.Entidades;

public class ProjectVo {
    String nombre,tiempoEstimado;

    public ProjectVo(String nombre, String tiempoEstimado) {
        this.nombre = nombre;
        this.tiempoEstimado = tiempoEstimado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(String tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }
}
