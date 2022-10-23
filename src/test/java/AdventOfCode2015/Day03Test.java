package AdventOfCode2015;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day03Test {

    @Test
    void _03_01() throws IOException, URISyntaxException {
        final var input = Files.readString(Paths.get(getClass().getResource("/03").toURI()));

        final var answer = Day03._03_01(input);

        Assertions.assertEquals(2565, answer);
    }

    @Test
    void _03_02() throws IOException, URISyntaxException {
        final var input = Files.readString(Paths.get(getClass().getResource("/03").toURI()));

        final var answer = Day03._03_02(input);

        Assertions.assertEquals(2639, answer);
    }

}
