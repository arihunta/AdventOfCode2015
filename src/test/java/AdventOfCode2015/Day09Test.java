package AdventOfCode2015;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class Day09Test {

    @Test
    void _09_01() throws IOException, URISyntaxException, NoSuchAlgorithmException {

        final var input = Files.readAllLines(Paths.get(getClass().getResource("/09").toURI()));

        final var answer = Day09._09_01(input);

        Assertions.assertEquals(251, answer);

    }

    @Test
    void _09_02() throws IOException, URISyntaxException, NoSuchAlgorithmException {

        final var input = Files.readAllLines(Paths.get(getClass().getResource("/09").toURI()));

        final var answer = Day09._09_02(input);

        Assertions.assertEquals(898, answer);

    }

}
