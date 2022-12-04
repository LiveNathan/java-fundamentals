package labs_examples.multi_threading.labs;

/*
 * Multithreading Exercise 6:
 *      Write a program that will print 1-100 sequentially from at least two distinct threads. For instance, thread1 will
 *      print "1", then thread2 will print "2", then thread1 will print "3", then thread2 will print "4" and so on.
 */

public class Exercise_06 {
    public static void main(String[] args) {
        // Create objects
        KeepCount keepCount = new KeepCount();
        CountUp thread1 = new CountUp("A", keepCount);
        CountUp thread2 = new CountUp("B", keepCount);

        // Let thread 1 and 2 finish
        try {
            thread1.thread.join();
            thread2.thread.join();
        } catch (InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }
    }
}

class KeepCount {
    Boolean count1isDone; // contains the state of the counting
    static int count = 0;

    synchronized void CountA(boolean running) {
        if (!running) { // stop the counting
            count1isDone = true;
            notify(); // notify any waiting threads
            return;
        }
        count++;
        System.out.println("Thread " + Thread.currentThread().getName() + " counts " + count + ". ");
        count1isDone = true; // set the current state to done
        notify(); // let CountB() run
        try {
            while (count1isDone)
                wait(); // wait for CountB() to complete
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted.");
        }
    }

    synchronized void CountB(boolean running) {
        if (!running) {
            count1isDone = false;
            notify();
            return;
        }
        count++;
        System.out.println("Thread " + Thread.currentThread().getName() + " counts " + count + ". ");
        count1isDone = false; // set the current state to not done
        notify(); // let CountA() run
        try {
            while (!count1isDone)
                wait(); // wait for CountA to complete
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted.");
        }
    }
}

class CountUp implements Runnable {
    Thread thread;
    KeepCount keepCount;

    // Construct a new thread.
    CountUp(String name, KeepCount keepCount) {
        thread = new Thread(this, name);
        this.keepCount = keepCount;
        thread.start(); // start the thread
    }

    // Begin execution of new thread.
    public void run() {
        if (thread.getName().compareTo("A") == 0) {
            for (int i = 0; i < 50; i++) {
                keepCount.CountA(true);
            }
            keepCount.CountA(false);
        } else {
            for (int i = 0; i < 50; i++)
                keepCount.CountB(true);
            keepCount.CountB(false);
        }
    }
}