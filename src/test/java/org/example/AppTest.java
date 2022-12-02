package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AppTest {

    @DisplayName("Number is prime")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29})
    void testNumberIsPrime(int testNumber) {
        FunctionalInterfeces functionalInterfeces = new FunctionalInterfeces();
        assertThat(functionalInterfeces.isPrime(testNumber)).isTrue();
    }

    @DisplayName("Number isn't prime")
    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 9, 10, 12, 14, 15, 16, 18})
    void testNumberIsNotPrime(int testNumber) {
        FunctionalInterfeces functionalInterfeces = new FunctionalInterfeces();
        assertThat(functionalInterfeces.isPrime(testNumber)).isFalse();
    }

    @Test
    @DisplayName("Random number is correct")
    void testCorrectRandomNumber() {
        FunctionalInterfeces functionalInterfeces = new FunctionalInterfeces();
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        functionalInterfeces.luckyNumber(5);

        assertThat(outputStreamCaptor.toString()).isNotEmpty()
                .containsAnyOf("0", "1", "2", "3", "4", "5");
    }

    @Test
    @DisplayName("Day of week is correct")
    void testCorrectDayOfWeek() {
        FunctionalInterfeces functionalInterfeces = new FunctionalInterfeces();
        assertThat(functionalInterfeces.dayOfWeek()).isEqualTo(LocalDate.now().getDayOfWeek());
    }

    @Test
    @DisplayName("Rounded number is correct")
    void testCorrectRoundedNumber() {
        FunctionalInterfeces functionalInterfeces = new FunctionalInterfeces();

        assertThat(functionalInterfeces.roundedNumber(20.45)).isEqualTo(20);
        assertThat(functionalInterfeces.roundedNumber(19.75)).isEqualTo(20);
    }

    @Test
    @DisplayName("Fibonacci series are correct")
    void testCorrectFibonacciSeries() {
        FunctionalInterfeces functionalInterfeces = new FunctionalInterfeces();
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        functionalInterfeces.fibonacciSeries(10);

        assertThat(outputStreamCaptor.toString()).isNotEmpty()
                .isEqualTo("0 1 1 2 3 5 8 13 21 34 ");
    }
}
