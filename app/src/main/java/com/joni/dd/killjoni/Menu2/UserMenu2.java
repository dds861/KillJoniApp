package com.joni.dd.killjoni.Menu2;

/**
 * Created by dd on 03.05.2017.
 */

public class UserMenu2 {

    //Frags Variables
    private String eventTime;
    private String killerLastName;
    private String victimLastName;
    private String weapon;
    private String headshot;

    //Frags contructer
    public UserMenu2(String eventTime, String killerLastName, String victimLastName, String weapon, String headshot) {
        this.eventTime      = eventTime;
        this.killerLastName = killerLastName;
        this.victimLastName = victimLastName;
        this.weapon         = weapon;
        this.headshot       = headshot;
    }

    //Getters and Setters

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getKillerLastName() {
        return killerLastName;
    }

    public void setKillerLastName(String killerLastName) {
        this.killerLastName = killerLastName;
    }

    public String getVictimLastName() {
        return victimLastName;
    }

    public void setVictimLastName(String victimLastName) {
        this.victimLastName = victimLastName;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getHeadshot() {
        return headshot;
    }

    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }


}
