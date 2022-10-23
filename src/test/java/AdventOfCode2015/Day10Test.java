package AdventOfCode2015;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day10Test {

    @Test
    void _10_01_01() throws IOException, URISyntaxException, NoSuchAlgorithmException {
        final var input = Files.readAllLines(Paths.get(getClass().getResource("/10_01").toURI()));

        final var answer = Day10._10_01(input, 5);

        Assertions.assertEquals(6, answer);
    }

    @Test
    void _10_01() throws IOException, URISyntaxException, NoSuchAlgorithmException {
        final var input = Files.readAllLines(Paths.get(getClass().getResource("/10").toURI()));

        final var answer = Day10._10_01(input, 40);

        Assertions.assertEquals(252594, answer);
    }

    @Test
    void _10_02() throws IOException, URISyntaxException, NoSuchAlgorithmException {
        final var input = Files.readAllLines(Paths.get(getClass().getResource("/10").toURI()));

        final var answer = Day10._10_02(input, 50);

        Assertions.assertEquals(3579328, answer);
    }

}
