import java.util.*;
import java.util.stream.Collectors;

/**
 * http://www.careercup.com/question?id=5619363327508480
 */
public class LongestWordConstructedFromChars {
    public List<String> longestWord(String[] wrds, Character[] chars) {
        Map<Character, Long> counts = Arrays.stream(chars).collect(Collectors.groupingBy(o -> o, Collectors.counting()));
        int maxLength = -1;
        List<String> results = null;

        for (String word : wrds) {
            Map<Character, Long> tmp = new HashMap<>(counts);
            boolean isSubSet = word
                    .chars()
                    .mapToObj(i -> (char) i)
                    .allMatch(c -> {
                        Long counter = tmp.computeIfPresent(c, (k, v) -> v - 1);
                        return counter != null && counter >= 0;
                    });

            if (isSubSet) {
                if (word.length() > maxLength) {
                    maxLength = word.length();
                    results = new ArrayList<>();
                    results.add(word);
                } else if (word.length() == maxLength) {
                    results.add(word);
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        String[] wrds = new String[]{"abc", "baa", "caan", "an", "banc"};
        Character[] chars = new Character[]{'a', 'a', 'n', 'c', 'b'};

        LongestWordConstructedFromChars l = new LongestWordConstructedFromChars();
        l.longestWord(wrds, chars).forEach(System.out::println);
    }
}
