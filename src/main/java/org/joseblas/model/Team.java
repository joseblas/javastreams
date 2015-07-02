package org.joseblas.model;

import java.util.List;

/**
 * Created by josetaboada on 30/06/2015.
 */
public class Team {
    private String team;
    private Integer wins = 0;
    private Integer draw = 0;
    private Integer lose = 0;
    private Integer points = 0;

    public Team(String team) {
        this.team = team;
    }


    public String getTeam() {
        return team;
    }

    public Team setTeam(String team) {
        this.team = team;
        return this;
    }

    public Integer getPoints() {
        return points;
    }

    public Team setPoints(Integer poIntegers) {
        this.points = poIntegers;
        return this;
    }

    public static Team createWin(String team){
        return new Team(team)
                .setPoints(3)
                .setWins(1);

    }

    private static Team createLose(String team) {
        return new Team(team)
                .setLose(1);
    }

    public static Team createDraw(String team){
        return new Team(team)
                .setPoints(1)
                .setDraw(1);
    }

    //maping data
    public static void add(List<Team> list, Match match){
        if(match.getGoalsHome() > match.getGoalsAway()){
            list.add(createWin(match.getHome()));
            list.add(createLose(match.getAway()));
        }else if(match.getGoalsHome() < match.getGoalsAway()){
            list.add(createWin(match.getAway()));
            list.add(createLose(match.getHome()));
        }else{
            list.add(createDraw(match.getHome()));
            list.add(createDraw(match.getAway()));
        }
    }



    public Integer getWins() {
        return wins;
    }

    public Team setWins(Integer wins) {
        this.wins = wins;
        return this;
    }

    public Integer getDraw() {
        return draw;
    }

    public Team setDraw(Integer draw) {
        this.draw = draw;
        return this;
    }

    public Integer getLose() {
        return lose;
    }

    public Team setLose(Integer lose) {
        this.lose = lose;
        return this;
    }




    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Point{");
        sb.append("team='").append(team).append('\'');
        sb.append(", lose=").append(lose);
        sb.append(", draw=").append(draw);
        sb.append(", wins=").append(wins);
        sb.append(", points=").append(points);
        sb.append('}');
        return sb.toString();
    }

    //reduce function
    public Team add(Team team) {
        this.points += team.getPoints();
        this.draw += team.getDraw();
        this.wins += team.getWins();
        this.lose += team.getLose();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        return !(this.team != null ? !this.team.equals(team.team) : team.team != null);

    }

    @Override
    public int hashCode() {
        return team != null ? team.hashCode() : 0;
    }

    public Team removeMatch() {
        if(wins > 0){
           wins--;
            points -= 3;
        }else if(draw > 0 ){
            draw--;
            points -= 1;
        }else{
            throw new IllegalArgumentException("Impossible to remove points");
        }
        return this;

    }
}
