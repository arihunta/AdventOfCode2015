package AdventOfCode2015;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day12Test {

    @Test
    void _12_01() throws IOException, URISyntaxException, NoSuchAlgorithmException {
        final var input = Files.readAllLines(Paths.get(getClass().getResource("/12").toURI()));

        final var answer = Day12._12_01(input);

        Assertions.assertEquals(111754, answer);
    }

    @Test
    void _12_02() throws IOException, URISyntaxException, NoSuchAlgorithmException {
        final var input = Files.readAllLines(Paths.get(getClass().getResource("/12").toURI()));

        final var answer = Day12._12_02(input);

        Assertions.assertEquals(65402, answer);
    }

}
