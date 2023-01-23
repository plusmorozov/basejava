package basejava.webapp;

import basejava.webapp.util.LazySingleton;

import java.util.ArrayList;
import java.util.List;

public class MainConcurrency {
    public static final int THREAD_NUMBERS = 10000;
    private static int counter;
    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread thread0 = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + ", " + getState());
            }
        };
        thread0.start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "," + Thread.currentThread().getState());
        }).start();
        System.out.println(thread0.getState());

        final MainConcurrency mainConcurrency = new MainConcurrency();
        List<Thread> threads = new ArrayList<>(THREAD_NUMBERS);
        for (int i = 0; i < THREAD_NUMBERS; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                }
            });
            thread.start();
            threads.add(thread);
        }
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(counter);
        LazySingleton.getInstance();

        System.out.println("--- Deadlock ---");
        deadLock (LOCK1, LOCK2);
        deadLock (LOCK2, LOCK1);
    }

    private static void deadLock (Object object1, Object object2) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                synchronized (object1) {
                    System.out.println(object1 + " is locked by a " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (object2) {
                        System.out.println(object2 + " is locked by a " + Thread.currentThread().getName());
                    }
                }
            }
        };
        thread.start();

    }

    private synchronized void inc() {
        counter++;
    }
}
