package pushpak57multithreading;

class SharedResource {
    private int data;
    private boolean hasData = false;

    // Method to produce data
    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            wait(); // Wait until the data is consumed
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + data);
        notify(); // Notify the consumer that data is ready
    }

    // Method to consume data
    public synchronized int consume() throws InterruptedException {
        while (!hasData) {
            wait(); // Wait until data is produced
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify(); // Notify the producer that data has been consumed
        return data;
    }
}

class Producer implements Runnable {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                resource.produce(i); // Produce data
                Thread.sleep(500); // Simulate time taken to produce data
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer implements Runnable {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                resource.consume(); // Consume data
                Thread.sleep(1000); // Simulate time taken to consume data
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start();
        consumerThread.start();
    }
}

