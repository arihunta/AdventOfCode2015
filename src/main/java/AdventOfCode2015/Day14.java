package AdventOfCode2015;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Data;

public class Day14 {

    public static int _14_01(final List<String> input) {
        final Pattern pattern = Pattern
                .compile("\\w+ can fly (\\d+) km/s for (\\d+) seconds, but then must rest for (\\d+) seconds\\.");
        return input.stream().mapToInt(line -> {
            final Matcher matcher = pattern.matcher(line);
            matcher.find();
            final var speed = Integer.parseInt(matcher.group(1));
            final var flyTime = Integer.parseInt(matcher.group(2));
            final var restTime = Integer.parseInt(matcher.group(3));
            final var fullCyclesCompleted = 2503 / (flyTime + restTime);
            final var totalSeconds = fullCyclesCompleted * flyTime + Math.min(flyTime, 2503 % (flyTime + restTime));
            return totalSeconds * speed;
        }).max().orElse(0);
    }

    @Data
    private static class Reindeer {
        private final String name;
        private final int speed;
        private final int flyTime;
        private final int restTime;
        private int currentPosition = 0;
        private boolean isFlying = true;
        private int nextStateChange = 0;
        private int score = 0;
    }

    public static int _14_02(final List<String> input) {
        final Pattern pattern = Pattern
                .compile("(\\w+) can fly (\\d+) km/s for (\\d+) seconds, but then must rest for (\\d+) seconds\\.");
        final var reindeers = input.stream().map(line -> {
            final Matcher matcher = pattern.matcher(line);
            matcher.find();
            var r = new Reindeer(matcher.group(1), Integer.parseInt(matcher.group(2)),
                    Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)));
            r.setNextStateChange(r.flyTime);
            return r;
        }).collect(Collectors.toList());

        System.out.println(reindeers);

        IntStream.rangeClosed(1, 2503).forEach(idx -> {
            final var maxPos = reindeers.stream().mapToInt(reindeer -> {
                if (reindeer.isFlying)
                    reindeer.currentPosition += reindeer.speed;
                if (reindeer.nextStateChange == idx) {
                    reindeer.isFlying = !reindeer.isFlying;
                    reindeer.nextStateChange = reindeer.isFlying ? idx + reindeer.flyTime : idx + reindeer.restTime;
                }
                return reindeer.currentPosition;
            }).max().orElse(0);
            reindeers.forEach(reindeer -> {
                if (reindeer.currentPosition == maxPos)
                    reindeer.score++;
            });
        });
        reindeers.sort(Comparator.comparingInt(it -> it.score));
        System.out.println(reindeers);
        return reindeers.get(reindeers.size() - 1).score;
    }

}
