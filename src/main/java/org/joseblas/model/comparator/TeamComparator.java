package org.joseblas.model.comparator;

import org.joseblas.model.Team;

import java.util.Comparator;

/**
 * Created by josetaboada on 02/07/2015.
 */
public class TeamComparator implements Comparator<Team> {

    @Override
    public int compare(Team o1, Team o2) {
        return o2.getPoints().compareTo(o1.getPoints());
    }
}
