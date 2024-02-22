package io.github.bartlomiejmilosz.servlets.divisors;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class DivisorsFinder {
    static List<Integer> getDivisors(int number) {
        if (number == 0) {
            return Collections.emptyList();
        }
        List<Integer> divisors = createStream(number)
                .filter(next -> isDivisor(number, next))
                .boxed()
                .collect(Collectors.toList());
        if (number < 0) {
            divisors.add(0, number);
            divisors.add(-number);
        } else {
            divisors.add(number);
        }
        return divisors;
    }

    private static IntStream createStream(int number) {
        if (number == 0)
            return IntStream.empty();
        if (number > 0)
            return IntStream.rangeClosed(1, number / 2);
        else {
            IntStream negativeStream = IntStream.rangeClosed(number / 2, -1);
            IntStream positiveStream = IntStream.rangeClosed(1, -number / 2);
            return IntStream.concat(negativeStream, positiveStream);
        }
    }

    private static boolean isDivisor(int number, int possibleDivisor) {
        return number % possibleDivisor == 0;
    }
}