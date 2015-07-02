package org.joseblas.model;

/**
 * Created by josetaboada on 30/06/2015.
 */
public class Match {
    private String home;
    private String away;
    private int goalsHome;
    private int goalsAway;


    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public int getGoalsHome() {
        return goalsHome;
    }

    public void setGoalsHome(int goalsHome) {
        this.goalsHome = goalsHome;
    }

    public int getGoalsAway() {
        return goalsAway;
    }

    public void setGoalsAway(int goalsAway) {
        this.goalsAway = goalsAway;
    }

    public Match(String home, String away, String goalsHome, String goalsAway) {
        this.home = home;
        this.away = away;
        this.goalsHome = Integer.parseInt(goalsHome);
        this.goalsAway = Integer.parseInt(goalsAway);
    }

    @Override
    public String toString() {
        return String.format("match[home=%s - %s:%s - %s]", home,goalsHome,goalsAway,away);
    }
}
