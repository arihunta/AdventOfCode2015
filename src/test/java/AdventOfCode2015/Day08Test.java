package AdventOfCode2015;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day08Test {

    @Test
    void _08_01_01() throws IOException, URISyntaxException, NoSuchAlgorithmException {

        final var input = Files.readAllLines(Paths.get(getClass().getResource("/08_01").toURI()));

        final var answer = Day08._08_01(input);

        Assertions.assertEquals(12, answer);

    }

    @Test
    void _08_01() throws IOException, URISyntaxException, NoSuchAlgorithmException {

        final var input = Files.readAllLines(Paths.get(getClass().getResource("/08").toURI()));

        final var answer = Day08._08_01(input);

        Assertions.assertEquals(1371, answer);

    }

    @Test
    void _08_02() throws IOException, URISyntaxException, NoSuchAlgorithmException {

        final var input = Files.readAllLines(Paths.get(getClass().getResource("/08").toURI()));

        final var answer = Day08._08_02(input);

        Assertions.assertEquals(2117, answer);

    }

}
