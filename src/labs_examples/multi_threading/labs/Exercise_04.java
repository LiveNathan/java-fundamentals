package labs_examples.multi_threading.labs;

/*
 * Multithreading Exercise 4:
 *      Demonstrate the use of a synchronized block and a synchronized method - ensure that the synchronization is
 *      working as expected
 */

import java.util.Random;

public class Exercise_04 {
    public static void main(String[] args) {
        // Create objects. I could improve this demo by creating two people with the same account.
        AccountManagement nathan = new AccountManagement(424242, 1000);
        AccountManagement elis = new AccountManagement(414141, 1000);

        // Create threads
        Thread thread1 = new Thread(nathan, "thread1");
        Thread thread2 = new Thread(elis, "thread2");

        // Start threads
        thread1.start();
        thread2.start();
    }
}

class AccountManagement implements Runnable {
    // Instance variables
    private Thread thread;
    private int accountNumber;
    private double dollarAmount;

    // Constructors

    public AccountManagement(int accountNumber, double dollarAmount) {
        this.accountNumber = accountNumber;
        this.dollarAmount = dollarAmount;
    }

    // Other methods
    public synchronized void AdjustAccountDollarAmount(double dollarAmount) {
        this.dollarAmount += dollarAmount;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starting.");
        Random rand = new Random(); //instance of random class
        int upperboundSleep = 500;
        int upperboundDollarAmount = 100;
        int lowerboundDollarAmount = -100;
        try {
            for (int i = 0; i < 8; i++) {
                int int_random = rand.nextInt(upperboundSleep);
                Thread.sleep(int_random);
                double randomDollarAmount = lowerboundDollarAmount + (upperboundDollarAmount - lowerboundDollarAmount) * rand.nextDouble();
                randomDollarAmount = Math.round(randomDollarAmount * 100.0) / 100.0;
                AdjustAccountDollarAmount(randomDollarAmount);
                System.out.printf("Account %d: adjusted by $%.2f now has the value $%.2f.%n", accountNumber, randomDollarAmount, dollarAmount);

            }
        } catch (InterruptedException exc) {
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }
        System.out.println(Thread.currentThread().getName() + " terminating.");
    }
}