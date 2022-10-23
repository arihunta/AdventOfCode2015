package AdventOfCode2015;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day04 {

    public static int _04_01(final String input) throws NoSuchAlgorithmException {

        int suffix = 0;

        while (true) {

            final var alg = MessageDigest.getInstance("MD5");
            final String hashString = String.format("%s%d", input, suffix);
            final byte[] digest = alg.digest(hashString.getBytes());

            final String hash = IntStream
                    .range(0, digest.length)
                    .boxed()
                    .map(it -> String.format("%02x", digest[it]))
                    .collect(Collectors.joining());

            if (hash.startsWith("00000")) {
                return suffix;
            }

            suffix++;

        }

    }

    public static int _04_02(final String input) throws NoSuchAlgorithmException {

        int suffix = 0;

        while (true) {

            final var alg = MessageDigest.getInstance("MD5");
            final String hashString = String.format("%s%d", input, suffix);
            final byte[] digest = alg.digest(hashString.getBytes());

            final String hash = IntStream
                    .range(0, digest.length)
                    .boxed()
                    .map(it -> String.format("%02x", digest[it]))
                    .collect(Collectors.joining());

            if (hash.startsWith("000000")) {
                return suffix;
            }

            suffix++;

        }

    }

}
