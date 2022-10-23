package AdventOfCode2015;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day10 {

    public static int _10_01(final List<String> input, final int numberOfIterations) {
        var number = input.get(0);
        for (int i = 0; i < numberOfIterations; i++) {
            number = lookSay(number);
        }
        return number.length();
    }

    private static String lookSay(final String input) {
        final Queue<Integer> letters = new LinkedList<>();
        Arrays.stream(input.split("")).forEach(letter -> letters.add(Integer.parseInt(letter)));

        final StringBuffer answer = new StringBuffer();
        int count = 1;
        int current = letters.remove();
        while (!letters.isEmpty()) {
            if (letters.peek() != current) {
                answer.append(String.valueOf(count));
                answer.append(String.valueOf(current));
                count = 0;
            }
            current = letters.remove();
            count++;
        }

        answer.append(String.valueOf(count));
        answer.append(String.valueOf(current));

        return answer.toString();
    }

    public static int _10_02(final List<String> input, final int numberOfIterations) {
        var number = input.get(0);
        for (int i = 0; i < numberOfIterations; i++) {
            number = lookSay(number);
        }
        return number.length();
    }

}
