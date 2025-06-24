package ThreadCreation;

public class CustomThreadbyInterface implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Inside Custom Thread run method");
        try {
            System.out.println("Thread is going to sleep");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() +" Thread is awake");

    }
}
