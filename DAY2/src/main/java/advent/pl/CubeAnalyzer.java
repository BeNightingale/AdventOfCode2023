package advent.pl;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CubeAnalyzer {

    private static final Map<String, Integer> limits = Map.of("red", 12, "green", 13, "blue", 14);

    private CubeAnalyzer() {
        // do nothing
    }

    public static int sumCorrectGamesIds(List<String> lineList) {
        final List<String> goodGames = new ArrayList<>();
        lineList
                .forEach(line -> {
                            final String[] array = line.split(":");
                            array[0] = array[0].replace("Game ", ""); // array[0] = number of game
                            boolean flag = Arrays.stream(array[1].split(";"))
                                    .allMatch(game ->
                                            Arrays.stream(game.split(","))
                                                    .allMatch(elem -> {
                                                                String[] pair = elem.split(" ");
                                                                return limits.get(pair[2]) >= Integer.parseInt(pair[1]);
                                                            }
                                                    )
                                    );
                            if (flag) {
                                goodGames.add(array[0]);
                            }
                        }
                );
        return goodGames.stream().mapToInt(Integer::parseInt).sum();
    }

    public static int sumGamePowers(List<String> lineList) {
        final List<Integer> gamePowers = new ArrayList<>();
        lineList
                .forEach(line -> {
                            final String[] array = line.split(":");
                            final Map<String, List<Integer>> map = Map.of(
                                    "green", new ArrayList<>(),
                                    "blue", new ArrayList<>(),
                                    "red", new ArrayList<>());
                            Arrays.stream(array[1].split(";"))
                                    .forEach(part -> Arrays.stream(part.split(","))
                                            .forEach(elem -> {
                                                        final String[] draw = elem.split(" ");
                                                        map.get(draw[2]).add(Integer.parseInt(draw[1]));
                                                    }
                                            )
                                    );
                            gamePowers.add(map.values()
                                    .stream()
                                    .filter(CollectionUtils::isNotEmpty)
                                    .map(col -> col.stream().mapToInt(i -> i).max())
                                    .map(op -> op.orElse(0))
                                    .reduce((j, k) -> j * k).orElse(0));
                        }
                );
        return gamePowers.stream().mapToInt(i -> i).sum();
    }
}
