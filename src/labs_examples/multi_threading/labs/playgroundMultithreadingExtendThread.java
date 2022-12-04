package labs_examples.multi_threading.labs;

class playgroundMultithreadingExtendThread extends Thread {
    playgroundMultithreadingExtendThread() {
        super("thread1");
        start();
    }

    // 4.Override the run() method
    @Override
    public void run() {
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
