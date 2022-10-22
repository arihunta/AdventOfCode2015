package AdventOfCode2015;

public class Day01 {

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

}
