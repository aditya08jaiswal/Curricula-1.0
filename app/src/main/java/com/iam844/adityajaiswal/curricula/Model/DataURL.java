package com.iam844.adityajaiswal.curricula.Model;

public class DataURL {

    private String mName;
    private String mURL;

    public DataURL() {
    }

    public DataURL(String mName, String mURL) {
        this.mName = mName;
        this.mURL = mURL;
    }

    public DataURL(String mName) {
        this.mName = mName;
    }

    public String getmName() {
        return mName;
    }

    public String getmURL() {
        return mURL;
    }

}
