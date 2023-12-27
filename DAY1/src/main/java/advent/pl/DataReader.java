package advent.pl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataReader {

    private DataReader() {
        // do nothing
    }

    public static final Path pathForSmallData = Paths.get("./DAY1/src/main/resources/smallData");
    public static final Path pathForBigData = Paths.get("./DAY1/src/main/resources/bigData");
    public static final Path pathForSmallInputWithDigitNames = Paths.get("./DAY1/src/main/resources/smallInputWithDigitNames");

    public static List<String> getInputLines(Path path) throws IOException {
        return Files.readAllLines(path);
    }
}
