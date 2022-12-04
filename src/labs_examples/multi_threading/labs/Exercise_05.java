package labs_examples.multi_threading.labs;

import java.util.Random;

/*
 * Multithreading Exercise 5:
 *      Demonstrate the use of a wait() and notify()
 */
public class Exercise_05 {
    public static void main(String[] args) {
        // Create object
        CountingAnimals countingAnimals = new CountingAnimals();

        // Create threads
        Thread sheep = new Thread(new CountSheep(10), "threadSheep");
        Thread goats = new Thread(new CountGoats(8), "threadGoats");
        Thread sheep2 = new Thread(new CountSheep(4), "threadSheep2");

        // Start threads
        sheep.start();
        goats.start();
        sheep2.start();
    }
}

class CountingAnimals {
//    private int numberOfAnimals = 0;
    private static boolean isCounting = false;  // True if counting goats and sheep should wait.

    // Other methods
    public synchronized void CountSheep(int numberOfAnimals) {
        while (isCounting) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
        isCounting = true;
        System.out.printf("Let's count %d sheep.%n", numberOfAnimals);
        for (int i = 0 ; i < numberOfAnimals; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("\t");
            }
            System.out.println(i);
            String sheep = "         ,ww\n" +
                    "   wWWWWWWW_)\n" +
                    "   `WWWWWW'\n" +
                    "    II  II";
            System.out.println(sheep);
        }
        isCounting = false;
        notifyAll();
    }
    public synchronized void CountGoats(int numberOfAnimals) {
        while (isCounting) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
        isCounting = true;
        System.out.printf("Let's count %d goats.%n", numberOfAnimals);
        for (int i = numberOfAnimals ; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("\t");
            }
            System.out.println(i);
            String sheep = " _))\n" +
                    "           > *\\     _~\n" +
                    "           `;'\\\\__-' \\_\n" +
                    "              | )  _ \\ \\\n" +
                    "             / / ``   w w\n" +
                    "            w w";
            System.out.println(sheep);
        }
        isCounting = false;
        notifyAll();
    }
}
class CountSheep implements Runnable {
    // Instance variables
    private final CountingAnimals sheep = new CountingAnimals();
    private final int numberOfSheep;

    // Constructors

    public CountSheep(int numberOfSheep) {
        this.numberOfSheep = numberOfSheep;
    }

    // Required overred
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starting.");
        Random random = new Random();
        int upperLimit = 500;
        try {
            int randomInt = random.nextInt(upperLimit);
            Thread.sleep(randomInt);  // This random sleep amount will make one of the Counting methods start first and make the other wait.
            sheep.CountSheep(numberOfSheep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " terminating.");
    }
}
class CountGoats implements Runnable {
    // instance variables
    private final CountingAnimals goats = new CountingAnimals();
    private final int numberOfGoats;

    // Constructors

    public CountGoats(int numberOfGoats) {
        this.numberOfGoats = numberOfGoats;
    }

    // Required override
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starting.");
        Random random = new Random();
        int upperLimit = 500;
        try {
            int randomInt = random.nextInt(upperLimit);
            Thread.sleep(randomInt);
            goats.CountGoats(numberOfGoats);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " terminating.");
    }
}