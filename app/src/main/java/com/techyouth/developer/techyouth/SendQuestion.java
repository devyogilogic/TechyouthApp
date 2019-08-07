
package com.techyouth.developer.techyouth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendQuestion {

    @SerializedName("post")
    @Expose
    private String post;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("status")
    @Expose
    private String status;

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
