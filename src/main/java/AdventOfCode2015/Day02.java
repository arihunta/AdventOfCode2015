package AdventOfCode2015;

import java.util.Arrays;
import java.util.List;

public class Day02 {

    public static int _02_01(final List<String> input) {

        return input.stream().map(it -> it.split("x"))
                .map(it -> Arrays.stream(it).mapToInt(str -> Integer.parseInt(str)).sorted().toArray())
                .map(it -> new int[] { it[0] * it[1], it[0] * it[2], it[1] * it[2] })
                .map(it -> Arrays.stream(it).sorted().toArray())
                .mapToInt(it -> 3 * it[0] + 2 * it[1] + 2 * it[2])
                .sum();

    }

    public static int _02_02(final List<String> input) {

        return input.stream().map(it -> it.split("x"))
                .map(it -> Arrays.stream(it).mapToInt(str -> Integer.parseInt(str)).sorted().toArray())
                .mapToInt(it -> it[0] * it[1] * it[2] + 2 * (it[0] + it[1])).sum();

    }

}
