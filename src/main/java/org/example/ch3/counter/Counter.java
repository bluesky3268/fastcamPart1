package org.example.ch3.counter;

public class Counter implements Runnable{

    private int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public int getValue() {
        return count;
    }

    @Override
    public void run() {
        this.increment();
        System.out.println("value for Thread after increment " + Thread.currentThread().getName() + " " + this.getValue());
        this.decrement();
        System.out.println("value for Thread after decrement " + Thread.currentThread().getName() + " " + this.getValue());
    }
}
