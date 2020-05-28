package performance.thread;

import jdk.internal.vm.annotation.Contended;

public class RestrictContended implements Runnable {

    public final static int NUM_THREADS = 4;
    private final int arrayIndex;

    private static VolatileLong[] longs = new VolatileLong[NUM_THREADS];

    static {
        for (int i = 0; i < longs.length; i++) {
            longs[i] = new VolatileLong();
        }
    }

    public RestrictContended(final int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    public static void main(final String[] args) throws Exception {
        long start = System.currentTimeMillis();
        runTest();
        System.out.println("duration = " + (System.currentTimeMillis() - start));
    }

    private static void runTest() throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new RestrictContended(i));
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
    }

    public void run() {
        long i = 5000000;
        while (0 != --i) {
            longs[arrayIndex].value = i;
        }
    }

    //@Contended
    public final static class VolatileLong {
        public volatile long value = 0L;
    }

}
