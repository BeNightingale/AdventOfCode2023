package advent.pl;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DataPath {

    private DataPath() {
        // do nothing
    }

    public static final Path pathForSmallData = Paths.get("./DAY1/src/main/resources/smallData");
    public static final Path pathForBigData = Paths.get("./DAY1/src/main/resources/bigData");
    public static final Path pathForSmallInputWithDigitNames = Paths.get("./DAY1/src/main/resources/smallInputWithDigitNames");

}
