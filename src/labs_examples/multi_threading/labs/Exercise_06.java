package labs_examples.multi_threading.labs;

/*
 * Multithreading Exercise 6:
 *      Write a program that will print 1-100 sequentially from at least two distinct threads. For instance, thread1 will
 *      print "1", then thread2 will print "2", then thread1 will print "3", then thread2 will print "4" and so on.
 */

public class Exercise_06 {
    public static void main(String[] args) {
        KeepCount keepCount = new KeepCount();
        CountUp1 countUp1 = new CountUp1();
        CountUp2 countUp2 = new CountUp2();
        Thread thread1 = new Thread(countUp1, "thread1");
        Thread thread2 = new Thread(countUp2, "thread2");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
    }
}

class KeepCount {
    private static int count = 0;
    private boolean count2canGo;

    // Getters and Setters
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        KeepCount.count = count;
    }

    // Other methods
    public synchronized void CountUp1(boolean running) {
        if (!running) {
            count2canGo = true;
            notify();
            return;
        }
        count++;
        System.out.println(Thread.currentThread().getName() + " counts " + count);
        count2canGo = true;
        notify();  // Let CountUp2() run
        try {
            while (count2canGo) {
                wait();  // Wait for countUp2 to complete
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }

    public synchronized void CountUp2(boolean running) {
        if (!running) {
            count2canGo = true;
            notify();
            return;
        }
        count++;
        System.out.println(Thread.currentThread().getName() + " counts " + count);
        count2canGo = false;
        notify();  // Let CountUp1() run
        try {
            while (!count2canGo) {
                wait();  // Wait for countUp1 to complete
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }
}

class CountUp1 implements Runnable {
    KeepCount keepCountRunnable = new KeepCount();

    @Override
    public void run() {
        while (KeepCount.getCount() < 100) {
            keepCountRunnable.CountUp1(true);
        }
        keepCountRunnable.CountUp1(false);
    }
}

class CountUp2 implements Runnable {
    KeepCount keepCountRunnable = new KeepCount();

    @Override
    public void run() {
        while (KeepCount.getCount() < 100) {
            keepCountRunnable.CountUp2(true);
        }
        keepCountRunnable.CountUp2(false);
    }
}