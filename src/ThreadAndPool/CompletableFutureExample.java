package ThreadAndPool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10,
                java.util.concurrent.TimeUnit.MINUTES, new java.util.concurrent.ArrayBlockingQueue<>(2),
                new CustomThreadFactory(), new CustomRejectHandler());

     /*   CompletableFuture<String> asyncTask = CompletableFuture.supplyAsync(() -> {

            System.out.println("Executing async task");
            System.out.println("Thread name: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000); // Simulate some work with sleep
            } catch (InterruptedException e) {
                System.out.println("Async task interrupted");
            }
            return "COMPLETABLE";
        },threadPoolExecutor).thenApplyAsync((String value) -> {
            System.out.println("Inside thenApply");
            System.out.println("Thread name: " + Thread.currentThread().getName());
            System.out.println("Processing result: " + value);
            return value + " FUTURE";
        });
        String ans = asyncTask.get();
        System.out.println("Final result: " + ans);
      */
      /*  CompletableFuture<String> asyncTask = CompletableFuture.supplyAsync(() -> {

            System.out.println("Executing async task");
            System.out.println("Thread name: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000); // Simulate some work with sleep
            } catch (InterruptedException e) {
                System.out.println("Async task interrupted");
            }
            return "COMPLETABLE";
        },threadPoolExecutor);

        asyncTask.thenCompose((String value) -> {
            System.out.println("Inside thenCompose");
            System.out.println("Thread name: " + Thread.currentThread().getName());
            System.out.println("Processing result: " + value);
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("Inside nested async task");
                System.out.println("Thread name: " + Thread.currentThread().getName());
                return value + " FUTURE";
            },threadPoolExecutor);
        }).thenAccept(result -> {
            System.out.println("Final result: " + result);
        });

       */
        CompletableFuture<Integer> asyncTask1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Executing async task 1");
            System.out.println("Thread name: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000); // Simulate some work with sleep
            } catch (InterruptedException e) {
                System.out.println("Async task 1 interrupted");
            }
            return 10;
        },threadPoolExecutor);
        CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Executing async task 2");
            System.out.println("Thread name: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000); // Simulate some work with sleep
            } catch (InterruptedException e) {
                System.out.println("Async task 2 interrupted");
            }
            return "k";
        },threadPoolExecutor);

        CompletableFuture<Object> combinedTask = asyncTask1.thenCombine(asyncTask2, (result1, result2) -> {
            System.out.println("Inside thenCombine");
            System.out.println("Thread name: " + Thread.currentThread().getName());
            System.out.println("Processing result1: " + result1);
            System.out.println("Processing result2: " + result2);
            return result1 + result2; // Ensure result2 is converted to Integer
        });

        combinedTask.thenAccept(result -> {
            System.out.println("Final result: " + result);
        });


    }


}
