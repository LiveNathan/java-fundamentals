package labs_examples.multi_threading.labs;

/*
 * Multithreading Exercise 1:
 *      1: Create an application that starts a Thread by implementing the Runnable interface
 *      2: Demonstrate at least two distinct ways of initiating a Thread using the Runnable you just created
 *
 */

public class Exercise_01 {
    public static void main(String[] args) {
        System.out.println("** Main Thread Start **");
        // Thread initiation method 1
        new Thread(new CountASCII(), "thread1").start();
        // Thread initiation method 2
        CountASCII countASCII = new CountASCII();
        Thread thread2 = new Thread(countASCII, "thread2");
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread2.start();
        System.out.println("** Main Thread End **");
    }
}

class CountASCII implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starting.");
        try {
            for (int i = 33; i < 43; i++) {
                /* put this thread to sleep for 400 milliseconds */
                Thread.sleep(300);
                char ascii = (char) i;
                System.out.println("The number " + i + " is the ASCII character " + ascii);
            }
        }
        /* catch the potential exception */ catch (InterruptedException exc) {
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }
        System.out.println(Thread.currentThread().getName() + " terminating.");
    }
}