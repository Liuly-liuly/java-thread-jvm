package com.concurrency.chapter2;


public class test {

    private TaxCalaculator taxCalaculator;

    public test(){}

    public test(TaxCalaculator taxCalaculator) {
        this.taxCalaculator = taxCalaculator;
    }

    public void start(){
        taxCalaculator.calculate();
    }
}
