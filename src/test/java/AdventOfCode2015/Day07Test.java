package AdventOfCode2015;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day07Test {

    @Test
    void _07_01() throws IOException, URISyntaxException, NoSuchAlgorithmException {
        final var input = Files.readAllLines(Paths.get(getClass().getResource("/07").toURI()));

        final var answer = Day07._07_01(input);

        Assertions.assertEquals(16076, answer);
    }

    @Test
    void _07_02() throws IOException, URISyntaxException, NoSuchAlgorithmException {
        final var input = Files.readAllLines(Paths.get(getClass().getResource("/07").toURI()));

        final var answer = Day07._07_02(input);

        Assertions.assertEquals(2797, answer);
    }

}
