import java.util.*;

class Solution {

    int index = 0;

    public List<String> braceExpansionII(String expression) {

        Set<String> result = parseExpression(expression);

        List<String> ans = new ArrayList<>(result);

        Collections.sort(ans);

        return ans;
    }

    // Handles union: {a,b,c}
    Set<String> parseExpression(String s) {

        Set<String> result = new HashSet<>();

        while (index < s.length() && s.charAt(index) != '}') {

            Set<String> part = parseTerm(s);

            result.addAll(part);

            if (index < s.length() && s.charAt(index) == ',') {
                index++;
            }
        }

        return result;
    }

    // Handles concatenation: {a,b}{c,d}
    Set<String> parseTerm(String s) {

        Set<String> result = new HashSet<>();
        result.add("");

        while (index < s.length()
                && s.charAt(index) != ','
                && s.charAt(index) != '}') {

            Set<String> part;

            if (s.charAt(index) == '{') {

                index++; // skip {

                part = parseExpression(s);

                index++; // skip }

            } else {

                part = new HashSet<>();
                part.add(String.valueOf(s.charAt(index)));

                index++;
            }

            result = concatenate(result, part);
        }

        return result;
    }

    // Cartesian product / concatenation
    Set<String> concatenate(Set<String> a, Set<String> b) {

        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}