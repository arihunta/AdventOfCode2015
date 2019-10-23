package AdventOfCode2015;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdventOfCode2015 {

    public static int _01_01(final String input) {

        var up = input.chars().filter(it -> it == '(').count();
        var down = input.chars().filter(it -> it == ')').count();
        return (int) (up - down);

    }

    public static int _01_02(final String input) {

        int currentFloor = 0;

        for (int i = 0; i < input.length(); i++) {

            currentFloor += input.charAt(i) == '(' ? 1 : -1;

            if (currentFloor == -1)
                return i + 1;

        }

        return 0;

    }

    public static int _02_01(final List<String> input) {

        return input.stream().map(it -> it.split("x"))
                .map(it -> Arrays.stream(it).mapToInt(str -> Integer.parseInt(str)).sorted().toArray())
                .map(it -> new int[] { it[0] * it[1], it[0] * it[2], it[1] * it[2] })
                .map(it -> Arrays.stream(it).sorted().toArray()).mapToInt(it -> 3 * it[0] + 2 * it[1] + 2 * it[2])
                .sum();

    }

    public static int _02_02(final List<String> input) {

        return input.stream().map(it -> it.split("x"))
                .map(it -> Arrays.stream(it).mapToInt(str -> Integer.parseInt(str)).sorted().toArray())
                .mapToInt(it -> it[0] * it[1] * it[2] + 2 * (it[0] + it[1])).sum();

    }

    public static int _03_01(final String input) {

        var houses = new HashSet<String>();

        int x = 0;
        int y = 0;
        houses.add(x + "," + y);

        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
            case '<':
                x--;
                break;
            case '>':
                x++;
                break;
            case 'v':
                y--;
                break;
            case '^':
                y++;
                break;
            }
            houses.add(x + "," + y);
        }

        return houses.size();

    }

    public static int _03_02(String input) {

        var houses = new HashSet<String>();

        var coords = new int[][] { { 0, 0 }, { 0, 0 } };

        var santa = 0;

        houses.add(Arrays.toString(coords[0]));

        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
            case '<':
                coords[santa][0]--;
                break;
            case '>':
                coords[santa][0]++;
                break;
            case 'v':
                coords[santa][1]--;
                break;
            case '^':
                coords[santa][1]++;
                break;
            }
            houses.add(Arrays.toString(coords[santa]));
            santa = 1 - santa;
        }

        return houses.size();

    }

    public static int _04_01(String input) throws NoSuchAlgorithmException {

        int suffix = 0;

        while (true) {

            final var alg = MessageDigest.getInstance("MD5");
            final String hashString = String.format("%s%d", input, suffix);
            final byte[] digest = alg.digest(hashString.getBytes());

            final String hash = IntStream
                .range(0, digest.length)
                .boxed()
                .map(it -> String.format("%02x", digest[it]))
                .collect(Collectors.joining())
            ;

            if (hash.startsWith("00000")) {
                return suffix;
            }

            suffix++;

        }

    }

    public static int _04_02(String input) throws NoSuchAlgorithmException {

        int suffix = 0;

        while (true) {

            final var alg = MessageDigest.getInstance("MD5");
            final String hashString = String.format("%s%d", input, suffix);
            final byte[] digest = alg.digest(hashString.getBytes());

            final String hash = IntStream
                .range(0, digest.length)
                .boxed()
                .map(it -> String.format("%02x", digest[it]))
                .collect(Collectors.joining())
            ;

            if (hash.startsWith("000000")) {
                return suffix;
            }

            suffix++;

        }

    }

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
