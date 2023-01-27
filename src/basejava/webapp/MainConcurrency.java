package basejava.webapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class MainConcurrency {
    public static final int THREAD_NUMBERS = 10000;
    private static int counter;
    private final AtomicInteger atomicCounter = new AtomicInteger();
    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();
    private static final Lock lock = new ReentrantLock();
    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat();
        }
    };

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
        CountDownLatch latch = new CountDownLatch(THREAD_NUMBERS);
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < THREAD_NUMBERS; i++) {
            Future<Integer> future = executorService.submit(() ->
            {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                }
                latch.countDown();
                return 5;
            });
        }

        latch.await(10, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.println(mainConcurrency.atomicCounter.get());

//        System.out.println("--- Deadlock ---");
//        deadLock (LOCK1, LOCK2);
//        deadLock (LOCK2, LOCK1);
        System.out.println(minValue(new int[]{9, 4, 3, 2, 1, 3}));

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,1));
        System.out.println(oddOrEven(list));
    }

    private static int minValue(int[] values) {
        return Arrays.stream(values).distinct().sorted().reduce((s1, s2) -> s1 * 10 + s2).getAsInt();
    }

    private static List<Integer> oddOrEven(List<Integer> integers) {
        final Map<Boolean, List<Integer>> oddsAndEvens = integers.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));
        return oddsAndEvens.get(oddsAndEvens.get(false).size() % 2 != 0);
    }

    private static void deadLock(Object object1, Object object2) {
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

    private void inc() {
        atomicCounter.incrementAndGet();
    }
}
