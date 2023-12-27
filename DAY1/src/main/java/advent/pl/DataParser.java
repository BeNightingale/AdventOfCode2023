package advent.pl;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

import static java.util.Map.entry;

public class DataParser {

    private static final List<String> numbers = List.of(
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "1", "2", "3", "4", "5", "6", "7", "8", "9");
    private final Map<String, String> nameDigitMap = Map.ofEntries(
            entry("one", "1"),
            entry("two", "2"),
            entry("three", "3"),
            entry("four", "4"),
            entry("five", "5"),
            entry("six", "6"),
            entry("seven", "7"),
            entry("eight", "8"),
            entry("nine", "9"),
            entry("1", "1"),
            entry("2", "2"),
            entry("3", "3"),
            entry("4", "4"),
            entry("5", "5"),
            entry("6", "6"),
            entry("7", "7"),
            entry("8", "8"),
            entry("9", "9")
    );

    public int findNumbersSum(List<String> lines) {
        return lines.stream()
                .map(line -> {
                            final String number = findNumberInLine(line);
                            return Integer.parseInt(number);
                        }
                )
                .mapToInt(x -> x)
                .sum();
    }

    public int getNumbersAndCountSum(List<String> lines) {
        return lines
                .stream()
                .map(line -> Arrays.stream(line.split(""))
                        .map(s -> s.charAt(0))
                        .filter(Character::isDigit)
                        .map(String::valueOf)
                        .reduce("", String::concat)
                )
                .map(str -> {
                            if (StringUtils.isEmpty(str)) {
                                return "0";
                            }
                            if (str.length() == 1) {
                                return str.repeat(2);
                            }
                            return str.charAt(0) + str.substring(str.length() - 1);
                        }
                )
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private Map<String, Integer> findDigitFirstPresenceInLine(String line) {
        final Map<String, Integer> digitFirstOccurrences = new HashMap<>();
        numbers
                .forEach(num -> {
                    final int firstOccurrenceIndex = line.indexOf(num);
                    if (firstOccurrenceIndex >= 0) {
                        digitFirstOccurrences.put(num, firstOccurrenceIndex);
                    }
                });
        return digitFirstOccurrences;
    }

    private Map<String, Integer> findDigitLastPresenceInLine(String line) {
        final Map<String, Integer> digitLastOccurrences = new HashMap<>();
        numbers
                .forEach(num -> {
                    final int lastOccurrenceIndex = line.lastIndexOf(num);
                    if (lastOccurrenceIndex >= 0) {
                        digitLastOccurrences.put(num, lastOccurrenceIndex);
                    }
                });
        return digitLastOccurrences;
    }

    private String findNumberInLine(String line) {
        final Map<String, Integer> digitFirstOccurrences = findDigitFirstPresenceInLine(line);
        final Map<String, Integer> digitLastOccurrences = findDigitLastPresenceInLine(line);
        String firstDigit = StringUtils.EMPTY;
        String lastDigit = StringUtils.EMPTY;
        if (digitFirstOccurrences.isEmpty()) {
            System.out.println("I found nothing in this line");
            return "0";
        }
        if (digitFirstOccurrences.size() == 1
                && digitLastOccurrences.size() == 1
                && digitLastOccurrences.entrySet() == digitFirstOccurrences.entrySet()) {
            final Map.Entry<String, Integer> entry = digitFirstOccurrences.entrySet()
                                                                            .stream()
                                                                            .findFirst()
                                                                            .orElse(null);
            final String digit = entry == null ? "0" : nameDigitMap.get(entry.getKey());
            System.out.println("Only one digit in this line: " + digit);
            return digit + digit;
        }
        final Collection<Integer> firstOccurrenceIndexes = digitFirstOccurrences.values();
        final int minIndex = firstOccurrenceIndexes
                                    .stream()
                                    .mapToInt(i -> i)
                                    .min().orElse(-1);
        final int maxIndex = firstOccurrenceIndexes
                                    .stream()
                                    .mapToInt(i -> i)
                                    .max()
                                    .orElse(-1);
        final Collection<Integer> lastOccurrenceIndexes = digitLastOccurrences.values();
        final int maxLastIndex = lastOccurrenceIndexes
                                    .stream()
                                    .mapToInt(i -> i)
                                    .max()
                                    .orElse(-1);
        final int maxInd = Math.max(maxIndex, maxLastIndex);
        if (minIndex == -1 && maxInd == -1) {
            System.out.println("No digits in this line!");// rather impossible now
            return "0";
        }
        for (Map.Entry<String, Integer> entry : digitFirstOccurrences.entrySet()) {
            if (Objects.equals(entry.getValue(), minIndex)) {
                firstDigit = nameDigitMap.get(entry.getKey());
                break;
            }
        }
        for (Map.Entry<String, Integer> entry : digitLastOccurrences.entrySet()) {
            if (Objects.equals(entry.getValue(), maxInd)) {
                lastDigit = nameDigitMap.get(entry.getKey());
                break;
            }
        }
        return firstDigit + lastDigit;
    }
}
