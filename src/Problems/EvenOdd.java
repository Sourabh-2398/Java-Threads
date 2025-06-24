package Problems;

public class EvenOdd {
    private static final int MAX = 20; // Maximum number to print
    private static int number = 1; // Shared number to print
    private static final Object lock = new Object(); // Lock object for synchronization

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            synchronized (lock) {
                while (number <= MAX) {
                    try {
                        System.out.println("Odd: " + number);
                        number++;
                        lock.notify(); // Notify the other thread
                        if (number <= MAX) {
                            lock.wait(); // Wait for the other thread
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            synchronized (lock) {
                while (number <= MAX) {
                    try {
                        System.out.println("Even: " + number);
                        number++;
                        lock.notify(); // Notify the other thread
                        if (number <= MAX) {
                            lock.wait(); // Wait for the other thread
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}