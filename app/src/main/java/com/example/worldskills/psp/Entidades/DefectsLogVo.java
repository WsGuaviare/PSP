package com.example.worldskills.psp.Entidades;

public class DefectsLogVo {
    String date,type,phaseInjected,phaseRemoved,fixTime,defectDescription,idTime;

    public DefectsLogVo(String date, String type, String phaseInjected, String phaseRemoved, String fixTime, String defectDescription,String idTime) {
        this.date = date;
        this.type = type;
        this.phaseInjected = phaseInjected;
        this.phaseRemoved = phaseRemoved;
        this.fixTime = fixTime;
        this.defectDescription = defectDescription;
        this.idTime=idTime;
    }

    public String getIdTime() {
        return idTime;
    }

    public void setIdTime(String idTime) {
        this.idTime = idTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhaseInjected() {
        return phaseInjected;
    }

    public void setPhaseInjected(String phaseInjected) {
        this.phaseInjected = phaseInjected;
    }

    public String getPhaseRemoved() {
        return phaseRemoved;
    }

    public void setPhaseRemoved(String phaseRemoved) {
        this.phaseRemoved = phaseRemoved;
    }

    public String getFixTime() {
        return fixTime;
    }

    public void setFixTime(String fixTime) {
        this.fixTime = fixTime;
    }

    public String getDefectDescription() {
        return defectDescription;
    }

    public void setDefectDescription(String defectDescription) {
        this.defectDescription = defectDescription;
    }
}
