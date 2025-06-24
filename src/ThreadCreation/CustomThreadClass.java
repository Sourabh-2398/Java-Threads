package ThreadCreation;

public class CustomThreadClass extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running");
        try {
            Thread.sleep(2000); // Simulate some work with sleep
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        System.out.println("Thread has finished execution");
    }
}
