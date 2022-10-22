package AdventOfCode2015;

import java.util.List;

public class Day05 {

    public static int _05_01(final List<String> input) {

        return (int) input.stream()
            .filter(it -> !it.contains("ab"))
            .filter(it -> !it.contains("cd"))
            .filter(it -> !it.contains("pq"))
            .filter(it -> !it.contains("xy"))
            .filter(it -> it.length() >= it.replace("a", "").replace("e", "").replace("i", "").replace("o", "").replace("u", "").length() + 3)
            .filter(it -> {
                for (int i = 0; i < it.length() - 1; i++)
                    if (it.charAt(i) == it.charAt(i + 1))
                        return true;
                return false;
            })
            .count()
        ;

    }

    public static int _05_02(final List<String> input) {

        return (int) input.stream()
            .filter(it -> {
                for (int i = 0; i < it.length() - 2; i++)
                    if (it.charAt(i) == it.charAt(i + 2))
                        return true;
                return false;
            })
            .filter(it -> {
                if (it.length() < 4) return false;
                for (int i = 0; i < it.length() - 3; i++)
                    for (int j = i + 2; j < it.length() - 1; j++)
                        if (it.substring(i, i + 2).equals(it.substring(j, j + 2)))
                            return true;
                return false;
            })
            .count()
        ;

    }

}
