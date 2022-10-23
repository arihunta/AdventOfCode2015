package AdventOfCode2015;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day13Test {

    @Test
    void _13_01_01() throws IOException, URISyntaxException, NoSuchAlgorithmException {
        final var input = Files.readAllLines(Paths.get(getClass().getResource("/13_01").toURI()));

        final var answer = Day13._13_01(input);

        Assertions.assertEquals(330, answer);
    }

    @Test
    void _13_01() throws IOException, URISyntaxException, NoSuchAlgorithmException {
        final var input = Files.readAllLines(Paths.get(getClass().getResource("/13").toURI()));

        final var answer = Day13._13_01(input);

        Assertions.assertEquals(664, answer);
    }

    @Test
    void _13_02() throws IOException, URISyntaxException, NoSuchAlgorithmException {
        final var input = Files.readAllLines(Paths.get(getClass().getResource("/13").toURI()));

        final var answer = Day13._13_02(input);

        Assertions.assertEquals(640, answer);
    }

}
