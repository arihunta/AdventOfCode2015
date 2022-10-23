package AdventOfCode2015;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day01Test {

    @Test
    void _01_01() throws IOException, URISyntaxException {
        final var input = Files.readString(Paths.get(getClass().getResource("/01").toURI()));

        final var answer = Day01._01_01(input);

        Assertions.assertEquals(74, answer);
    }

    @Test
    void _01_02() throws IOException, URISyntaxException {
        final var input = Files.readString(Paths.get(getClass().getResource("/01").toURI()));

        final var answer = Day01._01_02(input);

        Assertions.assertEquals(1795, answer);
    }

}
