package com.joni.dd.killjoni.UserMenu;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dds86 on 15-Oct-17.
 */

public class User3_4Players {

    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
