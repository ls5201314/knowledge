package performance.thread;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class IOTypeRunnable implements Runnable {

    //整体执行时间，包括在队列中等待的时间
    List<Long> wholeTimeList;
    //真正执行时间
    List<Long> runTimeList;

    private long initStartTime = 0;


    public IOTypeRunnable(List<Long> runTimeList, List<Long> wholeTimeList) {
        initStartTime = System.currentTimeMillis();
        this.runTimeList = runTimeList;
        this.wholeTimeList = wholeTimeList;
    }

    //IO操作
    public void readAndWrite() throws IOException {
        File sourceFile = new File("/Users/sheng.li/Desktop/test.txt");
        //创建输入流
        BufferedReader input = new BufferedReader(new FileReader(sourceFile));
        //读取源文件,写入到新的文件
        while(input.readLine() != null){
            //System.out.println(line);
        }
        //关闭输入输出流
        input.close();
    }

    public void run() {
        long start = System.currentTimeMillis();
        try {
            readAndWrite();
        } catch (IOException e) {
        }
        long end = System.currentTimeMillis();


        long wholeTime = end - initStartTime;
        long runTime = end - start;
        wholeTimeList.add(wholeTime);
        runTimeList.add(runTime);
        System.out.println("单个线程花费时间：" + (end - start));
    }
}
