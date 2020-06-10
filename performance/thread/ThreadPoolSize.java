package performance.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolSize {

    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(13, 13, 10, TimeUnit.SECONDS, new ArrayBlockingQueue(1000), new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void main(String[] args) throws Exception {

        int cores = Runtime.getRuntime().availableProcessors();

        int requestNum = 300;
        System.out.println("CPU核数 " + cores);

        List<Future<?>> futureList = new ArrayList<>();

        List<Long> wholeTimeList = new ArrayList<>();
        List<Long> runTimeList = new ArrayList<>();

        for (int i = 0; i < requestNum; i++) {
            //Future<?> future = threadPool.submit(new CPUTypeRunnable(runTimeList, wholeTimeList));

            Future<?> future = threadPool.submit(new IOTypeRunnable(runTimeList, wholeTimeList));
            futureList.add(future);
        }

        for (Future<?> future : futureList) {
            //获取线程执行结果
            future.get(requestNum, TimeUnit.SECONDS);
        }

        Long wholeTime = wholeTimeList.stream().reduce(Long::sum).orElse(null);

        Long runTime = runTimeList.stream().reduce(Long::sum).orElse(null);

        long averageWholeTime = wholeTime / wholeTimeList.size();
        long averageRunTime = runTime / runTimeList.size();
        System.out.println("平均每个线程整体花费时间： " + averageWholeTime);
        System.out.println("平均每个线程执行花费时间： " + averageRunTime);
        System.out.println("平均每个线程等待花费时间： " + (averageWholeTime - averageRunTime));
    }
}
