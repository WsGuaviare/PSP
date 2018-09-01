package com.example.worldskills.psp.Entidades;

public class TimeLogVo {
    String phase,start,interruption,stop,comments,idProject;

    public TimeLogVo(String phase, String start, String interruption, String stop, String comments,String idProject) {
        this.phase = phase;
        this.start = start;
        this.interruption = interruption;
        this.stop = stop;
        this.comments = comments;
        this.idProject=idProject;
    }

    public String getIdProject() {
        return idProject;
    }

    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getInterruption() {
        return interruption;
    }

    public void setInterruption(String interruption) {
        this.interruption = interruption;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
