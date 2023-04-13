package com.shou.imageannotation.po;

public class Annotation {
    private int annotationID;
    private int imageID;
    private int annotaterID;
    private String annotationDate;
    private String annotationResult;
    private int checkerID;
    private String checkDate;
    private String checkOpinion;
    private int checkResult;

    public Annotation() {
    }

    public Annotation(int annotationID, int imageID, int annotaterID, String annotationDate,
                      String annotationResult, int checkerID, String checkDate, String checkOpinion, int checkResult) {
        this.annotationID = annotationID;
        this.imageID = imageID;
        this.annotaterID = annotaterID;
        this.annotationDate = annotationDate;
        this.annotationResult = annotationResult;
        this.checkerID = checkerID;
        this.checkDate = checkDate;
        this.checkOpinion = checkOpinion;
        this.checkResult = checkResult;
    }

    public int getAnnotationID() {
        return annotationID;
    }

    public void setAnnotationID(int annotationID) {
        this.annotationID = annotationID;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public int getAnnotaterID() {
        return annotaterID;
    }

    public void setAnnotaterID(int annotaterID) {
        this.annotaterID = annotaterID;
    }

    public String getAnnotationDate() {
        return annotationDate;
    }

    public void setAnnotationDate(String annotationDate) {
        this.annotationDate = annotationDate;
    }

    public String getAnnotationResult() {
        return annotationResult;
    }

    public void setAnnotationResult(String annotationResult) {
        this.annotationResult = annotationResult;
    }

    public int getCheckerID() {
        return checkerID;
    }

    public void setCheckerID(int checkerID) {
        this.checkerID = checkerID;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckOpinion() {
        return checkOpinion;
    }

    public void setCheckOpinion(String checkOpinion) {
        this.checkOpinion = checkOpinion;
    }

    public int getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(int checkResult) {
        this.checkResult = checkResult;
    }
}
