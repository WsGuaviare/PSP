package com.example.worldskills.psp.Entidades;

public class TimeLogVo {
    String phase,startDays,StartMinutes,interruption,stopDays,stopMinutes,comments,idProject;

    public TimeLogVo(String phase, String startDays, String startMinutes, String interruption, String stopDays, String stopMinutes, String comments, String idProject) {
        this.phase = phase;
        this.startDays = startDays;
        StartMinutes = startMinutes;
        this.interruption = interruption;
        this.stopDays = stopDays;
        this.stopMinutes = stopMinutes;
        this.comments = comments;
        this.idProject = idProject;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getStartDays() {
        return startDays;
    }

    public void setStartDays(String startDays) {
        this.startDays = startDays;
    }

    public String getStartMinutes() {
        return StartMinutes;
    }

    public void setStartMinutes(String startMinutes) {
        StartMinutes = startMinutes;
    }

    public String getInterruption() {
        return interruption;
    }

    public void setInterruption(String interruption) {
        this.interruption = interruption;
    }

    public String getStopDays() {
        return stopDays;
    }

    public void setStopDays(String stopDays) {
        this.stopDays = stopDays;
    }

    public String getStopMinutes() {
        return stopMinutes;
    }

    public void setStopMinutes(String stopMinutes) {
        this.stopMinutes = stopMinutes;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getIdProject() {
        return idProject;
    }

    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }
}
