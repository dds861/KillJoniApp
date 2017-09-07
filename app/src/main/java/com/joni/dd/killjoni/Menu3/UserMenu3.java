package com.joni.dd.killjoni.Menu3;

/**
 * Created by dd on 08.05.2017.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserMenu3 {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("online")
    @Expose
    private Integer online;

    @SerializedName("server_id")
    @Expose
    private String serverId;
    @SerializedName("server_name")
    @Expose
    private String serverName;
    @SerializedName("server_address")
    @Expose
    private String serverAddress;
    @SerializedName("server_maxslots")
    @Expose
    private String serverMaxslots;
    @SerializedName("server_location")
    @Expose
    private String serverLocation;
    @SerializedName("server_type")
    @Expose
    private String serverType;
    @SerializedName("server_dateblock")
    @Expose
    private String serverDateblock;
    @SerializedName("server_daystoblock")
    @Expose
    private Integer serverDaystoblock;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }


    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public String getServerMaxslots() {
        return serverMaxslots;
    }

    public void setServerMaxslots(String serverMaxslots) {
        this.serverMaxslots = serverMaxslots;
    }

    public String getServerLocation() {
        return serverLocation;
    }

    public void setServerLocation(String serverLocation) {
        this.serverLocation = serverLocation;
    }

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public String getServerDateblock() {
        return serverDateblock;
    }

    public void setServerDateblock(String serverDateblock) {
        this.serverDateblock = serverDateblock;
    }

    public Integer getServerDaystoblock() {
        return serverDaystoblock;
    }

    public void setServerDaystoblock(Integer serverDaystoblock) {
        this.serverDaystoblock = serverDaystoblock;
    }

}