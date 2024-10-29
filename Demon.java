package pushpak57multithreading;

public class Demon extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("ok");

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Demon t1 =new Demon();
        t1.setDaemon(true);
        t1.start();
        System.out.println("Main done");
    }
}
