package labs_examples.multi_threading.labs;

public class playgroundExtendingThread {
    public static void main(String[] args) {

        // Step 1) demonstrate creating a new Thread using the MyThread class below
        MyThread thread1 = new MyThread("thread1");

        // Step 2) demonstrate creating (and starting) a new Thread using the MyOtherThread class below
        MyOtherThread thread2 = new MyOtherThread();
        thread2.setName("thread2");
        thread2.start();
    }
}

class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
        start();
    }

    @Override
    public void run() {
        System.out.println("I'm in a thread name " + getName() + "!");
    }
}

class MyOtherThread extends Thread {

    @Override
    public void run() {
        System.out.println("I'm in a thread name " + getName() + "!");
    }
}
