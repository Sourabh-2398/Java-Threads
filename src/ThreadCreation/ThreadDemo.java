package ThreadCreation;

public class ThreadDemo {
    public static void main(String[] args) {

        CustomThreadClass customThread = new CustomThreadClass();
        customThread.start();
        CustomThreadbyInterface customThreadbyInterface = new CustomThreadbyInterface();
        Thread thread = new Thread(customThreadbyInterface);
        thread.start();

        Thread thread2 = new Thread(()->{
            System.out.println("Thread2 is running");
            try {
                Thread.sleep(2000); // Simulate some work with sleep
            } catch (InterruptedException e) {
                System.out.println("Thread2 interrupted");
            }
            System.out.println("Thread2 has finished execution");

        });
        thread2.start();
    }
}
