package AdventOfCode2015;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.google.common.collect.Range;

public class Day11 {

    public static String _11_01(final List<String> input) {
        var passwort = input.get(0);
        do {
            passwort = increment(passwort);
        } while (!isValid(passwort));
        return passwort;
    }

    private static boolean isValid(final String passwort) {
        // check for forbidden chars
        if (passwort.contains("i") || passwort.contains("o") || passwort.contains("l"))
            return false;
        // check for a straight
        if (!IntStream.rangeClosed(0, passwort.length() - 3)
                .anyMatch(idx -> {
                    var current = passwort.charAt(idx);
                    var next = passwort.charAt(idx + 1);
                    var third = passwort.charAt(idx + 2);
                    return (next == current + 1) && (third == current + 2);
                }))
            return false;

        final List<Integer> pairs = new ArrayList<>();
        for (int i = 0; i < passwort.length() - 1; i++) {
            if (passwort.charAt(i) == passwort.charAt(i + 1))
                pairs.add(i);
        }
        return pairs.size() >= 3 || (pairs.size() == 2
                && (Math.abs(pairs.get(0) - pairs.get(1)) != 1));
    }

    private static String increment(final String passwort) {
        String newValue = "";
        boolean carry = true;
        for (int currentChar = passwort.length() - 1; currentChar >= 0; currentChar = currentChar - 1) {
            int currentCharVal = passwort.charAt(currentChar);
            if (carry) {
                currentCharVal++;
                carry = false;
            }
            ;
            if (currentCharVal > 122) {
                currentCharVal = 97;
                carry = true;
            }
            newValue = ((char) currentCharVal) + newValue;
        }
        return (carry ? "a" : "") + newValue;
    }

    public static String _11_02(final List<String> input) {
        var passwort = input.get(0);
        do {
            passwort = increment(passwort);
        } while (!isValid(passwort));
        do {
            passwort = increment(passwort);
        } while (!isValid(passwort));
        return passwort;
    }

}
