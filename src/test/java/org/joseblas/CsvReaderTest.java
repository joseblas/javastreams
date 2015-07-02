package org.joseblas;

import org.joseblas.model.Team;
import org.joseblas.streams.AnalysePremier;
import org.joseblas.streams.CsvReader;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class CsvReaderTest extends TestBase {

    @Test
    public void checkLiverpool() throws InterruptedException {
        CsvReader csvReader = createCsvReader("PremierLeague1314.csv");
        List<Team> records = csvReader.read();
        assertEquals("Liverpool", 1, AnalysePremier.distance(records, "Liverpool"));
    }

    @Test
      public void checkChelsea() throws InterruptedException {
        CsvReader csvReader = createCsvReader("PremierLeague1314.csv");
        List<Team> records = csvReader.read();
        assertEquals("chelsea", 3, AnalysePremier.distance(records, "Chelsea"));
    }

    @Test
    public void checkCrystalPalace() throws InterruptedException {
        CsvReader csvReader = createCsvReader("PremierLeague1314.csv");
        List<Team> records = csvReader.read();
        assertEquals("Crystal Palace", 87, AnalysePremier.distance(records, "Crystal Palace"));
    }

    @Test
    public void checkCardiff() throws InterruptedException {
        CsvReader csvReader = createCsvReader("PremierLeague1314.csv");
        List<Team> records = csvReader.read();
        assertEquals("Cardiff", 167, AnalysePremier.distance(records, "Cardiff"));
    }

}