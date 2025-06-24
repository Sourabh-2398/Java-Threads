package ThreadAndPool;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolClass {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES,
                new java.util.concurrent.ArrayBlockingQueue<>(2),
                new CustomThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for(int i=1;i<=8;i++){
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " is running");
                System.out.println("Task processed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(5000); // Simulate some work with sleep
                } catch (InterruptedException e) {
                    System.out.println("Task " + taskId + " interrupted");
                }
                System.out.println("Task " + taskId + " has finished execution");
            });
        }

        executor.shutdown();
    }
}

class CustomThreadFactory implements java.util.concurrent.ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("CustomThread-" + thread.getId());
        thread.setDaemon(false);
        thread.setPriority(Thread.NORM_PRIORITY);
        return thread;
    }
}

class CustomRejectHandler implements java.util.concurrent.RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task " + r.toString() + " rejected from " + executor.toString());
    }
}
