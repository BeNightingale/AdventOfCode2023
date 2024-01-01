package advent.pl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Reader {

    private Reader() {
        // do nothing
    }

    public static List<String> getInputLines(Path path) throws IOException {
        return Files.readAllLines(path);
    }
}
