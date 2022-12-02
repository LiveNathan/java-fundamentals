package labs_examples.multi_threading.labs;

class MultiThreading implements Runnable {
    /* 1. Create a reference to Thread */
    Thread thread;

    MultiThreading() {
        //2. Initialize the thread reference with a parameter of 'this'
        thread = new Thread(this);
        //3. Start the thread.
        thread.start();
    }

    // 4.Override the run() method
    @Override
    public void run() {
        //5. Make run() print 'Hello Multithreading 10 times, once every 100ms'
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(200);
                System.out.println("Hello MultiThreading!");
            }
        } catch (InterruptedException interruptedException) {
            System.out.println("Thread interrupted.");
        }
    }
}
