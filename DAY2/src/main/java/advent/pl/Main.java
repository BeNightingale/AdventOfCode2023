package advent.pl;

import java.io.IOException;

import static advent.pl.CubeAnalyzer.sumCorrectGamesIds;
import static advent.pl.CubeAnalyzer.sumGamePowers;

public class Main {

    public static void main(String[] args) throws IOException {


        System.out.println("Sum of ids of correct games for small data = "
                + sumCorrectGamesIds(Reader.getInputLines(DataResource.pathForSmallData)));
        System.out.println("Sum of ids of correct games for big data = "
                + sumCorrectGamesIds(Reader.getInputLines(DataResource.pathForBigData)));
        System.out.println("Sum of game powers for small data = "
                + sumGamePowers(Reader.getInputLines(DataResource.pathForSmallData)));
        System.out.println("Sum of ids of game powers for big data = "
                + sumGamePowers(Reader.getInputLines(DataResource.pathForBigData)));
    }
}