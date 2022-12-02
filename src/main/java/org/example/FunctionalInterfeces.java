package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionalInterfeces {

    protected boolean isPrime(int number) {
        Predicate<Integer> primeNumber = i -> (i > 1)
                && IntStream.rangeClosed(2, (int) Math.sqrt(i))
                .noneMatch(n -> (i % n == 0));

        //Calling Predicate method
        return primeNumber.test(number);
    }

    protected void luckyNumber(int max) {
        Random random = new Random();
        Consumer<Integer> randomNumber = i -> System.out.println(random.nextInt(i));
        randomNumber.accept(max + 1);
    }

    protected DayOfWeek dayOfWeek() {
        Supplier<DayOfWeek> day = () -> LocalDate.now().getDayOfWeek();;
        return day.get();
    }

    protected long roundedNumber(double doubleNumber) {
        Function<Double, Long> longNumber = l -> (long) Math.round(l);
        return longNumber.apply(doubleNumber);
    }

    protected void fibonacciSeries(int maxSize) {
        //Generates series of number based on the UnaryOperator
        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
                .limit(maxSize)
                .map(n -> n[0])
                .forEach(fibNum -> System.out.print(fibNum + " "));
    }
}
