package com.concurrency.chapter3;


public class CreateThread4 {

    private static int counter = 1;

    public static void main(String[] args) {

        Thread t1 = new Thread(new ThreadGroup("test"), new Runnable() {
            @Override
            public void run() {
                try {
                    add(1);
                } catch (Error e) {
                    System.out.println(counter);
                }
            }

            private void add(int i) {
                counter++;
                add(i + 1);
            }
        }, "Test", 1 << 24);
        t1.start();
        System.out.println(t1.getThreadGroup());
    }
}

//stackSize 261300
