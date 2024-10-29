package pushpak57multithreading;

public class ImplementingRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("hello pushpak");
    }

    public static void main(String[] args) {
        ImplementingRunnable r =new ImplementingRunnable();
        Thread t =new Thread(r);
        t.start();

    }
}
