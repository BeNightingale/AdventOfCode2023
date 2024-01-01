package advent.pl;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DataResource {

    private DataResource() {
        // do nothing
    }

    public static final Path pathForSmallData = Paths.get("./DAY2/src/main/resources/smallData");
    public static final Path pathForBigData = Paths.get("./DAY2/src/main/resources/bigData");
}
