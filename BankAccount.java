package pushpak57multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread() + " attempting to withdraw " + amount);
        try {

            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {

                    if (balance >= amount) {
                        System.out.println(Thread.currentThread().getName() + " processing withdrawal");
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
                    } else {
                        System.out.println(Thread.currentThread().getName() + " insufficient balance");
                    }
                } finally {

                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock");
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        Runnable task = () -> bankAccount.withdraw(34);

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");

        t1.start();
        t2.start();
    }
}
