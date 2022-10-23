package AdventOfCode2015;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.swing.GroupLayout.Group;

public class Day09 {

	public static int _09_01(final List<String> input) {
		final Pattern pattern = Pattern.compile("([\\w]+) to ([\\w]+) = ([\\d]+)");
		final Set<String> cities = new HashSet<>();
		final Map<String, Map<String, Integer>> distances = new HashMap<>();
		input.stream().forEach(line -> {
			final Matcher matcher = pattern.matcher(line);
			matcher.find();
			System.out.println(matcher);
			final var city1 = matcher.group(1);
			final var city2 = matcher.group(2);
			var distance = Integer.parseInt(matcher.group(3));
			distances.compute(city1, (k, map) -> {
				if (map == null) {
					map = new HashMap<String, Integer>();
				}
				map.put(city2, distance);
				return map;
			});
			distances.compute(city2, (k, map) -> {
				if (map == null) {
					map = new HashMap<String, Integer>();
				}
				map.put(city1, distance);
				return map;
			});
			cities.add(city1);
			cities.add(city2);
		});

		distances.put("start", cities.stream().collect(Collectors.toMap(it -> it, it -> 0)));

		System.out.println(distances);
		return findShortestSubtree("start", cities, distances);
	}

	private static int findShortestSubtree(final String start, final Set<String> unvisited,
			final Map<String, Map<String, Integer>> distances) {
		return unvisited.stream().mapToInt(next -> {
			final var newUnvisited = new HashSet<>(unvisited);
			newUnvisited.remove(next);
			return distances.get(start).get(next) + findShortestSubtree(next, newUnvisited, distances);
		}).min().orElse(0);
	}
	

	private static int findLongestSubtree(final String start, final Set<String> unvisited,
			final Map<String, Map<String, Integer>> distances) {
		return unvisited.stream().mapToInt(next -> {
			final var newUnvisited = new HashSet<>(unvisited);
			newUnvisited.remove(next);
			return distances.get(start).get(next) + findLongestSubtree(next, newUnvisited, distances);
		}).max().orElse(0);
	}

	public static int _09_02(final List<String> input) {
		final Pattern pattern = Pattern.compile("([\\w]+) to ([\\w]+) = ([\\d]+)");
		final Set<String> cities = new HashSet<>();
		final Map<String, Map<String, Integer>> distances = new HashMap<>();
		input.stream().forEach(line -> {
			final Matcher matcher = pattern.matcher(line);
			matcher.find();
			System.out.println(matcher);
			final var city1 = matcher.group(1);
			final var city2 = matcher.group(2);
			var distance = Integer.parseInt(matcher.group(3));
			distances.compute(city1, (k, map) -> {
				if (map == null) {
					map = new HashMap<String, Integer>();
				}
				map.put(city2, distance);
				return map;
			});
			distances.compute(city2, (k, map) -> {
				if (map == null) {
					map = new HashMap<String, Integer>();
				}
				map.put(city1, distance);
				return map;
			});
			cities.add(city1);
			cities.add(city2);
		});

		distances.put("start", cities.stream().collect(Collectors.toMap(it -> it, it -> 0)));

		System.out.println(distances);
		return findLongestSubtree("start", cities, distances);
	}

}
