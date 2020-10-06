package com.joni.dd.killjoni.UserMenu;

/**
 * Created by dd on 08.05.2017.
 */


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User3_3Status {
    @SerializedName("status")
    private String status;
    @SerializedName("online")
    private int online;
    @SerializedName("data")
    private Data data;
    @SerializedName("server_id")
    private String server_id;
    @SerializedName("server_name")
    private String server_name;
    @SerializedName("server_address")
    private String server_address;
    @SerializedName("server_maxslots")
    private String server_maxslots;
    @SerializedName("server_location")
    private String server_location;
    @SerializedName("server_type")
    private String server_type;
    @SerializedName("server_dateblock")
    private String server_dateblock;
    @SerializedName("server_daystoblock")
    private int server_daystoblock;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getServer_id() {
        return server_id;
    }

    public void setServer_id(String server_id) {
        this.server_id = server_id;
    }

    public String getServer_name() {
        return server_name;
    }

    public void setServer_name(String server_name) {
        this.server_name = server_name;
    }

    public String getServer_address() {
        return server_address;
    }

    public void setServer_address(String server_address) {
        this.server_address = server_address;
    }

    public String getServer_maxslots() {
        return server_maxslots;
    }

    public void setServer_maxslots(String server_maxslots) {
        this.server_maxslots = server_maxslots;
    }

    public String getServer_location() {
        return server_location;
    }

    public void setServer_location(String server_location) {
        this.server_location = server_location;
    }

    public String getServer_type() {
        return server_type;
    }

    public void setServer_type(String server_type) {
        this.server_type = server_type;
    }

    public String getServer_dateblock() {
        return server_dateblock;
    }

    public void setServer_dateblock(String server_dateblock) {
        this.server_dateblock = server_dateblock;
    }

    public int getServer_daystoblock() {
        return server_daystoblock;
    }

    public void setServer_daystoblock(int server_daystoblock) {
        this.server_daystoblock = server_daystoblock;
    }

    public static class B {
        @SerializedName("type")
        private String type;
        @SerializedName("ip")
        private String ip;
        @SerializedName("c_port")
        private String c_port;
        @SerializedName("q_port")
        private String q_port;
        @SerializedName("s_port")
        private String s_port;
        @SerializedName("status")
        private int status;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getC_port() {
            return c_port;
        }

        public void setC_port(String c_port) {
            this.c_port = c_port;
        }

        public String getQ_port() {
            return q_port;
        }

        public void setQ_port(String q_port) {
            this.q_port = q_port;
        }

        public String getS_port() {
            return s_port;
        }

        public void setS_port(String s_port) {
            this.s_port = s_port;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }

    public static class S {
        @SerializedName("game")
        private String game;
        @SerializedName("name")
        private String name;
        @SerializedName("map")
        private String map;
        @SerializedName("players")
        private int players;
        @SerializedName("playersmax")
        private int playersmax;
        @SerializedName("password")
        private int password;

        public String getGame() {
            return game;
        }

        public void setGame(String game) {
            this.game = game;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMap() {
            return map;
        }

        public void setMap(String map) {
            this.map = map;
        }

        public int getPlayers() {
            return players;
        }

        public void setPlayers(int players) {
            this.players = players;
        }

        public int getPlayersmax() {
            return playersmax;
        }

        public void setPlayersmax(int playersmax) {
            this.playersmax = playersmax;
        }

        public int getPassword() {
            return password;
        }

        public void setPassword(int password) {
            this.password = password;
        }
    }

    public static class P {
        @SerializedName("pid")
        private int pid;
        @SerializedName("name")
        private String name;
        @SerializedName("score")
        private int score;
        @SerializedName("time")
        private String time;

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    public static class T {
    }

    public static class Data {
        @SerializedName("b")
        private B b;
        @SerializedName("s")
        private S s;
        @SerializedName("p")
        private List<P> p;
        @SerializedName("t")
        private List<T> t;

        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }

        public S getS() {
            return s;
        }

        public void setS(S s) {
            this.s = s;
        }

        public List<P> getP() {
            return p;
        }

        public void setP(List<P> p) {
            this.p = p;
        }

        public List<T> getT() {
            return t;
        }

        public void setT(List<T> t) {
            this.t = t;
        }
    }

}