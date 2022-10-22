package AdventOfCode2015;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day02Test {

    @Test
    void _02_01() throws IOException, URISyntaxException {

        final var input = Files.readAllLines(Paths.get(getClass().getResource("/02").toURI()));

        final var answer = Day02._02_01(input);

        Assertions.assertEquals(1606483, answer);

    }

    @Test
    void _02_02() throws IOException, URISyntaxException {

        final var input = Files.readAllLines(Paths.get(getClass().getResource("/02").toURI()));

        final var answer = Day02._02_02(input);

        System.out.println(answer);

        Assertions.assertEquals(3842356, answer);

    }

}
