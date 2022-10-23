package AdventOfCode2015;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONObject;

public class Day12 {

    public static int _12_01(final List<String> input) {
        final Pattern pattern = Pattern.compile("\\-?\\d+");
        final Matcher matcher = pattern.matcher(input.get(0));
        int count = 0;
        while (matcher.find()) {
            count += Integer.parseInt(matcher.group());
        }
        return count;
    }

    public static int _12_02(final List<String> input) {
        JSONObject jo = new JSONObject(input.get(0));
        return sum(jo);
    }

    private static int sum(final Object obj) {
        if (obj instanceof JSONObject) {
            final var jsonObject = (JSONObject) obj;
            // filter for red props
            if (jsonObject.keySet().stream().anyMatch(key -> jsonObject.get(key).equals("red"))) {
                System.out.println("hes red jim");
                return 0;
            }
            return jsonObject.keySet().stream().mapToInt(key -> sum(jsonObject.get(key))).sum();
        }
        if (obj instanceof JSONArray) {
            final var jsonArray = (JSONArray) obj;
            return IntStream.range(0, jsonArray.length()).map(it -> sum(jsonArray.get(it))).sum();
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        return 0;
    }

}
