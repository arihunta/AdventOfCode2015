package AdventOfCode2015;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day11Test {

    @Test
    void _11_01() throws IOException, URISyntaxException, NoSuchAlgorithmException {
        final var input = Files.readAllLines(Paths.get(getClass().getResource("/11").toURI()));

        final var answer = Day11._11_01(input);

        Assertions.assertEquals("cqjxxyzz", answer);
    }

    @Test
    void _11_02() throws IOException, URISyntaxException, NoSuchAlgorithmException {
        final var input = Files.readAllLines(Paths.get(getClass().getResource("/11").toURI()));

        final var answer = Day11._11_02(input);

        Assertions.assertEquals("cqkaabcc", answer);
    }

}
