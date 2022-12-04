package labs_examples.multi_threading.labs;

/*
 * Multithreading Exercise 2:
 *      Create an application that creates a Thread using the Thread class
 */

import java.util.Random;

public class Exercise_02 {
    public static void main(String[] args) {
        System.out.println("** Main Thread Start **");
        RandomASCII thread1 = new RandomASCII("First Thread");
        RandomASCII thread2 = new RandomASCII("Second Thread");
        System.out.println("** Main Thread End **");
    }
}

class RandomASCII extends Thread {
    // Constructor
    public RandomASCII(String name) {
        super(name);
        start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starting.");
        Random rand = new Random(); //instance of random class
        int upperboundSleep = 500;
        byte lowerboundASCII = 33;
        byte upperboundASCII = 126;
        try {
            for (int i = 0; i < 10; i++) {
                int int_random = rand.nextInt(upperboundSleep);
                Thread.sleep(int_random);
                byte random_byte = (byte) (rand.nextInt(upperboundASCII - lowerboundASCII) + lowerboundASCII);
                char ascii = (char) random_byte;
                System.out.println(Thread.currentThread().getName() + ": The number " + random_byte + " is the ASCII character " + ascii);
            }
        }
        /* catch the potential exception */ catch (InterruptedException exc) {
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }
        System.out.println(Thread.currentThread().getName() + " terminating.");
    }
}