package AdventOfCode2015;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day04Test {

    @Test
    void _04_01() throws IOException, URISyntaxException, NoSuchAlgorithmException {

        final var input = Files.readString(Paths.get(getClass().getResource("/04").toURI()));

        final var answer = Day04._04_01(input);

        Assertions.assertEquals(282749, answer);

    }

    @Test
    void _04_02() throws IOException, URISyntaxException, NoSuchAlgorithmException {

        final var input = Files.readString(Paths.get(getClass().getResource("/04").toURI()));

        final var answer = Day04._04_02(input);

        Assertions.assertEquals(9962624, answer);

    }

}
