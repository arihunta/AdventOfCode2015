package AdventOfCode2015;

import java.util.List;
import java.util.stream.Collectors;

public class Day08 {

    public static int _08_01(final List<String> input) {
        return input.stream()
                .map(line -> line.length() - line.replaceAll("^\"", "")
                        .replaceAll("\"$", "")
                        .replaceAll("\\\\x[0-9a-f]{2}", "'")
                        .replace("\\\"", "\"")
                        .replace("\\\\", "\\")
                        .length())
                .collect(Collectors.summingInt(it -> it));
    }

    public static int _08_02(final List<String> input) {
        return input.stream()
                .map(line -> 2 + line.replace("\\", "\\\\")
                        .replace("\"", "\\\"")
                        .length() - line.length())
                .collect(Collectors.summingInt(it -> it));
    }

}
