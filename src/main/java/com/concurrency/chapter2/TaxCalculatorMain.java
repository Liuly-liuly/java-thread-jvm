package com.concurrency.chapter2;

import com.sun.corba.se.impl.orb.ParserTable;

import java.time.temporal.Temporal;

public class TaxCalculatorMain {

    public static void main(String[] args) {
        /*TaxCalaculator calculator = new TaxCalaculator(10000d, 2000d) {

            @Override
            public double calcTax() {
                return getSalary() * 0.1 + getBonus() * 0.15;
            }
        };
        double tax = calculator.calculate();
        System.out.println(tax);*/

        TaxCalaculator calculator = new TaxCalaculator(10000d, 2000d, (s, b) -> s * 0.1 + b * 0.15);
        System.out.println(calculator.calculate());

        TaxCalaculator taxCalaculator = new TaxCalaculator() {
            @Override
            public double calculate() {
                return 1000 * 12;
            }
        };
        System.out.println(taxCalaculator.calculate());

       //must be interface see @FunctionalInterface
//        new test(()->{ });
    }
}
