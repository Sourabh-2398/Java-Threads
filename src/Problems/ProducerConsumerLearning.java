package Problems;
// Main class to test producer-consumer
public class ProducerConsumerLearning {

    public static void main(String[] args) {

        SharedResource sharedBuffer = new SharedResource(5);

        // Creating producer thread using Lambda expression
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    sharedBuffer.produce(i);
                }
            } catch (Exception e) {
                // Handle exception here
            }
        });

        // Creating consumer thread using Lambda expression
        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    sharedBuffer.consume();
                }
            } catch (Exception e) {
                // Handle exception here
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
