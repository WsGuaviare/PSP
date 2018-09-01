package com.example.worldskills.psp.Entidades;

public class DefectsLogVo {
    String dateDays,dateMinutes,type,phaseInjected,phaseRemoved,fixTime,defectDescription,idTime;

    public DefectsLogVo(String dateDays, String dateMinutes, String type, String phaseInjected, String phaseRemoved, String fixTime, String defectDescription, String idTime) {
        this.dateDays = dateDays;
        this.dateMinutes = dateMinutes;
        this.type = type;
        this.phaseInjected = phaseInjected;
        this.phaseRemoved = phaseRemoved;
        this.fixTime = fixTime;
        this.defectDescription = defectDescription;
        this.idTime = idTime;
    }

    public String getDateDays() {
        return dateDays;
    }

    public void setDateDays(String dateDays) {
        this.dateDays = dateDays;
    }

    public String getDateMinutes() {
        return dateMinutes;
    }

    public void setDateMinutes(String dateMinutes) {
        this.dateMinutes = dateMinutes;
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

    public String getIdTime() {
        return idTime;
    }

    public void setIdTime(String idTime) {
        this.idTime = idTime;
    }
}
