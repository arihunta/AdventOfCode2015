package AdventOfCode2015;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day13 {

    public static int _13_01(final List<String> input) {
        final Pattern pattern = Pattern
                .compile("([\\w]+) would (lose|gain) ([\\d]+) happiness units by sitting next to ([\\w]+)\\.");
        final Set<String> people = new HashSet<>();
        final Map<String, Map<String, Integer>> happinessChanges = new HashMap<>();
        input.forEach(line -> {
            final Matcher matcher = pattern.matcher(line);
            matcher.find();
            final var person1 = matcher.group(1);
            final var person2 = matcher.group(4);
            var distance = (matcher.group(2).equals("lose") ? -1 : 1) * (Integer.parseInt(matcher.group(3)));
            happinessChanges.compute(person1, (k, map) -> {
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put(person2, distance);
                return map;
            });
            people.add(person1);
            people.add(person2);
        });
        System.out.println(happinessChanges);
        people.remove("Alice");
        return findLongestSubtree("Alice", people, happinessChanges);
    }

    private static int findLongestSubtree(final String start, final Set<String> unvisited,
            final Map<String, Map<String, Integer>> distances) {
        return unvisited.stream().mapToInt(next -> {
            final var newUnvisited = new HashSet<>(unvisited);
            newUnvisited.remove(next);
            return distances.get(start).get(next) + distances.get(next).get(start)
                    + findLongestSubtree(next, newUnvisited, distances);
        }).max().orElseGet(() -> distances.get(start).get("Alice") + distances.get("Alice").get(start));
    }

    public static int _13_02(final List<String> input) {
        final Pattern pattern = Pattern
                .compile("([\\w]+) would (lose|gain) ([\\d]+) happiness units by sitting next to ([\\w]+)\\.");
        final Set<String> people = new HashSet<>();
        final Map<String, Map<String, Integer>> happinessChanges = new HashMap<>();
        input.forEach(line -> {
            final Matcher matcher = pattern.matcher(line);
            matcher.find();
            final var person1 = matcher.group(1);
            final var person2 = matcher.group(4);
            var distance = (matcher.group(2).equals("lose") ? -1 : 1) * (Integer.parseInt(matcher.group(3)));
            happinessChanges.compute(person1, (k, map) -> {
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put(person2, distance);
                return map;
            });
            people.add(person1);
            people.add(person2);
        });
        happinessChanges.values().forEach(it -> it.put("Me", 0));
        happinessChanges.put("Me", people.stream().collect(Collectors.toMap(it -> it, it -> 0)));
        people.add("Me");
        System.out.println(happinessChanges);
        people.remove("Alice");
        return findLongestSubtree("Alice", people, happinessChanges);
    }

}
