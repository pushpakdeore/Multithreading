package pushpak57multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Executing Task ID: " + taskId + " - " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // Simulate a task taking time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task ID: " + taskId + " completed by " + Thread.currentThread().getName());
    }
}

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Creating a thread pool of 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submitting tasks to the thread pool
        for (int i = 1; i <= 10; i++) {
            Task task = new Task(i);
            executorService.submit(task); // Submit each task to the thread pool
        }

        // Shutting down the executor service
        executorService.shutdown();
    }
}
