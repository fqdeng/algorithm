package com.demo.org.algorithm.print.sequence;

//TODO
public class Foo {

    //volatile 保障可见性
    private volatile int first = 0;
    private volatile int second = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (first != 1) {
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        second = 1;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (second != 1) {
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
