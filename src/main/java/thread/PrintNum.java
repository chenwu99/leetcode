package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNum {

    private int number = 1;
    private final int MAX_NUMBER = 100;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void printNumber(int targetNumber) {
        lock.lock();
        try {
            while (number <= MAX_NUMBER) {
                if (number % 3 != targetNumber) {
                    condition.await();
                } else {
                    System.out.println("Thread " + targetNumber + ": " + number);
                    number++;
                    condition.signalAll();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintNum printNumbers = new PrintNum();

        Thread thread1 = new Thread(() -> {
            printNumbers.printNumber(0);
        });

        Thread thread2 = new Thread(() -> {
            printNumbers.printNumber(1);
        });

        Thread thread3 = new Thread(() -> {
            printNumbers.printNumber(2);
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
