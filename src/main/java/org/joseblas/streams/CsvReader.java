package org.joseblas.streams;

import org.apache.log4j.Logger;
import org.joseblas.model.Match;
import org.joseblas.model.Team;
import org.joseblas.model.comparator.TeamComparator;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

public class CsvReader {
    public static final int HOME = 2;
    public static final int AWAY = 3;
    public static final int HOMEGOALS = 4;
    public static final int AWAYGOALS = 5;

    private static final String SEPARATOR = ",";
    private static final Comparator<Team> teamComparator = new TeamComparator();

    private final Reader source;

    public CsvReader(Reader source) {
        this.source = source;
    }

    private static final Logger logger = Logger.getLogger(CsvReader.class);

    public List<Team> read() {
        List<Team> teams = new ArrayList<>();
        BufferedReader reader = new BufferedReader(source);
        //Change original data to matches
        // and then create team instance per match (map)
        reader.lines().skip(1)
                .map(line -> line.split(SEPARATOR))
                .map(splitted -> new Match(
                                splitted[HOME],
                                splitted[AWAY],
                                splitted[HOMEGOALS],
                                splitted[AWAYGOALS])
                )
                .forEach(match -> Team.add(teams, match))
        ;
        logger.debug("lines read");

        //Group by teams instances
        Map<String, List<Team>> collect = teams.stream().collect(
                Collectors.groupingBy(p ->
                                p.getTeam()
                )
        );

        // classification not ordered.
        List<Team> totalPoints = new ArrayList<>();
        //reduce.
        for (String k : collect.keySet()) {
            Team accumulator = collect.get(k).stream().reduce(new Team(k),
                    (sum, p) -> {
                        return sum.add(p);
                    }
            );
            totalPoints.add(accumulator);
        }
        //Ordered clasification by points.
        Collections.sort(totalPoints, teamComparator);

        return totalPoints;
    }


}
