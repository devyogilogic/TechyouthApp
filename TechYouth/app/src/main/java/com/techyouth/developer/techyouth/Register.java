
package com.techyouth.developer.techyouth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Register {

    @SerializedName("emailid")
    @Expose
    private String emailid;
    @SerializedName("userid")
    @Expose
    private String userid;
    @SerializedName("want")
    @Expose
    private String want;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("status")
    @Expose
    private String status;

    public String getEmail() {
        return emailid;
    }

    public void setEmail(String emailid) {
        this.emailid = emailid;
    }

    public Register(String email, String want, String username, String password) {
        this.emailid = emailid;
        this.want = want;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }
    public String getWant() { return want; }

    public void setWant(String want) { this.want = want; }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
