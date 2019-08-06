
package com.techyouth.developer.techyouth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListPost {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("post")
    @Expose
    private String post;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("timeanddate")
    @Expose
    private String timeanddate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTimeanddate() {
        return timeanddate;
    }

    public void setTimeanddate(String timeanddate) {
        this.timeanddate = timeanddate;
    }

}
