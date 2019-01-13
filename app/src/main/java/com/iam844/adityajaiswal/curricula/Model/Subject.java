package com.iam844.adityajaiswal.curricula.Model;

public class Subject {

    private String subListName;
    private int subListImage;
    private Class subActivity;

    public Subject(String subListName, int subListImage, Class subActivity) {
        this.subListName = subListName;
        this.subListImage = subListImage;
        this.subActivity = subActivity;
    }

    public String getSubListName() {
        return subListName;
    }

    public int getSubListImage() {
        return subListImage;
    }

    public Class getSubActivity() {
        return subActivity;
    }
}
