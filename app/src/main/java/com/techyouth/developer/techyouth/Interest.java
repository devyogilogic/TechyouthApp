
package com.techyouth.developer.techyouth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Interest {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("InterestArea")
    @Expose
    private String interestArea;
    @SerializedName("want")
    @Expose
    private String want;

    public String getId() {
        return id;
    }

    public Interest(String id, String interestArea, String want) {
        this.id = id;
        this.interestArea = interestArea;
        this.want = want;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInterestArea() {
        return interestArea;
    }

    public String getWant() {
        return want;
    }

    public void setWant(String want) {
        this.want = want;
    }

    public void setInterestArea(String interestArea) {
        this.interestArea = interestArea;
    }

}
