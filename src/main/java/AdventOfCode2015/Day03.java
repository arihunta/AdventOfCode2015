package AdventOfCode2015;

import java.util.Arrays;
import java.util.HashSet;

public class Day03 {

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

    public static int _03_02(final String input) {

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

}
