package AdventOfCode2015;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Data;

public class Day07 {

    enum Operation {
        AND, OR, LSHIFT, RSHIFT, NOT, VALUE
    };

    @Data
    private static class Gate {
        private final String id;
        private final Operation operation;
        private final List<String> inputs;
    }

    public static int _07_01(final List<String> input) {
        var gates = input.stream()
                .map(line -> gateFromString(line))
                .collect(Collectors.toMap(gate -> gate.id, gate -> gate));

        return valueOf("a", gates, new HashMap<>());
    }

    public static int _07_02(final List<String> input) {
        var gates = input.stream()
                .map(line -> gateFromString(line))
                .collect(Collectors.toMap(gate -> gate.id, gate -> gate));
        gates.put("b", new Gate("b", Operation.VALUE, Collections.singletonList("16076")));

        return valueOf("a", gates, new HashMap<>());
    }

    private static int valueOf(final String gateId, final Map<String, Gate> circuit,
            final Map<String, Integer> valueCache) {
        if (valueCache.containsKey(gateId))
            return valueCache.get(gateId);
        if (circuit.containsKey(gateId)) {
            var gate = circuit.get(gateId);
            var value = switch (gate.operation) {
                case AND ->
                    valueOf(gate.inputs.get(0), circuit, valueCache) & valueOf(gate.inputs.get(1), circuit, valueCache);
                case OR ->
                    valueOf(gate.inputs.get(0), circuit, valueCache) | valueOf(gate.inputs.get(1), circuit, valueCache);
                case LSHIFT -> valueOf(gate.inputs.get(0), circuit, valueCache) << valueOf(gate.inputs.get(1), circuit,
                        valueCache);
                case RSHIFT -> valueOf(gate.inputs.get(0), circuit, valueCache) >> valueOf(gate.inputs.get(1), circuit,
                        valueCache);
                case NOT -> ~valueOf(gate.inputs.get(0), circuit, valueCache);
                case VALUE -> valueOf(gate.inputs.get(0), circuit, valueCache);
            };
            valueCache.put(gateId, value);
            return value;
        } else {
            return Integer.parseInt(gateId);
        }
    }

    private static Gate gateFromString(final String specification) {
        var expressionAndId = specification.split(" -> ");
        if (expressionAndId[0].contains("AND")) {
            var args = Arrays.asList(expressionAndId[0].split(" AND "));
            return new Gate(expressionAndId[1], Operation.AND, args);
        } else if (expressionAndId[0].contains("OR")) {
            var args = Arrays.asList(expressionAndId[0].split(" OR "));
            return new Gate(expressionAndId[1], Operation.OR, args);
        } else if (expressionAndId[0].contains("LSHIFT")) {
            var args = Arrays.asList(expressionAndId[0].split(" LSHIFT "));
            return new Gate(expressionAndId[1], Operation.LSHIFT, args);
        } else if (expressionAndId[0].contains("RSHIFT")) {
            var args = Arrays.asList(expressionAndId[0].split(" RSHIFT "));
            return new Gate(expressionAndId[1], Operation.RSHIFT, args);
        } else if (expressionAndId[0].contains("NOT")) {
            var args = Arrays.asList(expressionAndId[0].replace("NOT ", ""));
            return new Gate(expressionAndId[1], Operation.NOT, args);
        } else {
            return new Gate(expressionAndId[1], Operation.VALUE, Collections.singletonList(expressionAndId[0]));
        }
    }

}
