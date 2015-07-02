package org.joseblas.streams;

import org.apache.log4j.Logger;
import org.joseblas.model.Team;

import java.util.Collections;
import java.util.List;

/**
 * Created by josetaboada on 01/07/2015.
 */
public class AnalysePremier {

    private static final Logger logger = Logger.getLogger(AnalysePremier.class);

    public static void show(List<Team> teams){
        for(Team team : teams){
            logger.info("team " + team.getTeam() + ":" + team.getPoints());

        }
    }

    public static int distance(List<Team> teams, String team){
        return distance(teams,team,0);
    }
    private static int distance(List<Team> teams, String team, int distance){

        int position = teams.indexOf(new Team(team));

        if(position == 0){
            logger.debug("Basic case. End of recursion.");
            return distance;
        }
        // increasing distance, not yet leading the listing!
        distance++;
        Team actual = teams.get(position);
        // get the first team above our selected team
        Team previousTeam = teams.get(position - 1);
        // remove a match: win or draw
        previousTeam.removeMatch();
        if(actual.getPoints()> previousTeam.getPoints()){
            logger.info(String.format( "swaping positions %s over %s", actual.getTeam(), previousTeam.getTeam()));
            Collections.swap(teams,position-1, position);
        }

        return distance(teams, team, distance);
    }






}
