package AdventOfCode2015;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day05Test {

    @Test
    void _05_01() throws IOException, URISyntaxException, NoSuchAlgorithmException {
        final var input = Files.readAllLines(Paths.get(getClass().getResource("/05").toURI()));

        final var answer = Day05._05_01(input);

        Assertions.assertEquals(236, answer);
    }

    @Test
    void _05_02() throws IOException, URISyntaxException, NoSuchAlgorithmException {
        final var input = Files.readAllLines(Paths.get(getClass().getResource("/05").toURI()));

        final var answer = Day05._05_02(input);

        Assertions.assertEquals(51, answer);
    }

}
