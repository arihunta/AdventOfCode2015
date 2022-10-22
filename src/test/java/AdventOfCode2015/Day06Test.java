package AdventOfCode2015;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day06Test {

    @Test
    void _06_01() throws IOException, URISyntaxException, NoSuchAlgorithmException {

        final var input = Files.readAllLines(Paths.get(getClass().getResource("/06").toURI()));

        final var answer = Day06._06_01(input);

        Assertions.assertEquals(377891, answer);

    }

    @Test
    void _06_02() throws IOException, URISyntaxException, NoSuchAlgorithmException {

        final var input = Files.readAllLines(Paths.get(getClass().getResource("/06").toURI()));

        final var answer = Day06._06_02(input);

        Assertions.assertEquals(14110788, answer);

    }

}
