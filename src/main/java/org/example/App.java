package org.example;

public class App {

    public static void main(String[] args) {
        FunctionalInterfeces functionalInterfeces = new FunctionalInterfeces();

        System.out.println(functionalInterfeces.isPrime(8));
        functionalInterfeces.luckyNumber(10);
        System.out.println(functionalInterfeces.dayOfWeek());
        System.out.println(functionalInterfeces.roundedNumber(20.45));
        functionalInterfeces.fibonacciSeries(10);
    }
}
