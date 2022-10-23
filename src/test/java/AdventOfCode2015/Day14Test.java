package AdventOfCode2015;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day14Test {

    @Test
    void _14_01() throws IOException, URISyntaxException, NoSuchAlgorithmException {
        final var input = Files.readAllLines(Paths.get(getClass().getResource("/14").toURI()));

        final var answer = Day14._14_01(input);

        Assertions.assertEquals(2640, answer);
    }

    @Test
    void _14_02() throws IOException, URISyntaxException, NoSuchAlgorithmException {
        final var input = Files.readAllLines(Paths.get(getClass().getResource("/14").toURI()));

        final var answer = Day14._14_02(input);

        Assertions.assertEquals(1102, answer);
    }

}
