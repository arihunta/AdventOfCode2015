package AdventOfCode2015;

import java.util.List;
import java.util.regex.Pattern;

public class Day06 {

    public static int _06_01(final List<String> input) {

        var pattern = Pattern.compile("(\\d*),(\\d*) through (\\d*),(\\d*)");

        final boolean[][] lights = new boolean[1000][1000];

        for (final String line : input) {

            var matcher = pattern.matcher(line);

            if (matcher.find()) {

                var x_start = Integer.parseInt(matcher.group(1));
                var y_start = Integer.parseInt(matcher.group(2));
                var x_end = Integer.parseInt(matcher.group(3));
                var y_end = Integer.parseInt(matcher.group(4));

                for (int i = x_start; i <= x_end; i++) {
                    for (int j = y_start; j <= y_end; j++) {
                        if (line.startsWith("turn on")) {
                            lights[i][j] = true;
                        }
                        else if (line.startsWith("turn off")) {
                            lights[i][j] = false;
                        }
                        else {
                            lights[i][j] = !lights[i][j];
                        }
                    }
                }

            }

        }

        int count = 0;
        for (int i = 0; i < lights.length; i++) {
            for (int j = 0; j < lights[i].length; j++) {
                if (lights[i][j]) count++;
            }
        }

        return count;

    }

    public static int _06_02(final List<String> input) {

        var pattern = Pattern.compile("(\\d*),(\\d*) through (\\d*),(\\d*)");

        final int[][] lights = new int[1000][1000];

        for (final String line : input) {

            var matcher = pattern.matcher(line);

            if (matcher.find()) {

                var x_start = Integer.parseInt(matcher.group(1));
                var y_start = Integer.parseInt(matcher.group(2));
                var x_end = Integer.parseInt(matcher.group(3));
                var y_end = Integer.parseInt(matcher.group(4));

                for (int i = x_start; i <= x_end; i++) {
                    for (int j = y_start; j <= y_end; j++) {
                        if (line.startsWith("turn on")) {
                            lights[i][j]++;
                        }
                        else if (line.startsWith("turn off")) {
                            lights[i][j] = lights[i][j] == 0 ? 0 : lights[i][j] - 1;
                        }
                        else {
                            lights[i][j] = lights[i][j] + 2;
                        }
                    }
                }

            }

        }

        int count = 0;
        for (int i = 0; i < lights.length; i++) {
            for (int j = 0; j < lights[i].length; j++) {
                count += lights[i][j];
            }
        }

        return count;

    }

}
