package pushpak57multithreading;

public class ExtendingThread extends Thread {

    @Override
    public void run() {
        System.out.println("ok");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) throws InterruptedException  {
        System.out.println("ok1");
        ExtendingThread t =new ExtendingThread();
        System.out.println(t.getState());//new

        t.start();
        System.out.println(t.getState());//runable

        Thread.sleep(100);
        System.out.println(t.getState());//time_waiting

        t.join();
        System.out.println(t.getState());//terminated

        System.out.println(Thread.currentThread().getState());


        //methoin thread
        //start run sleep join set

    }
}
