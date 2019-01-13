package com.iam844.adityajaiswal.curricula.Model;

public class Semester {

    private String semListName;
    private int semListImage;
    private Class semActivity;

    public Semester() {
    }

    public Semester(String semListName, int semListImage, Class semActivity) {
        this.semListName = semListName;
        this.semListImage = semListImage;
        this.semActivity = semActivity;
    }

    public String getSemListName() {
        return semListName;
    }

    public int getSemListImage() {
        return semListImage;
    }

    public Class getSemActivity() {
        return semActivity;
    }
}
