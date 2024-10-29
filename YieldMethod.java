package pushpak57multithreading;

public class YieldMethod extends Thread{
    @Override
    public void run() {
        for(int  i= 0;i<5;i++){
            System.out.println(Thread.currentThread().getName() + " is running ");
            Thread.yield(); // alternate execution  of each thread
        }
    }
//    with yield
//    Thread-0 is running
//    Thread-1 is running
//    Thread-0 is running
//    Thread-1 is running
//    Thread-0 is running
//    Thread-1 is running
//    Thread-0 is running
//    Thread-1 is running
//    Thread-1 is running
//    Thread-0 is running


//    without yield
//    Thread-0 is running
//    Thread-0 is running
//    Thread-0 is running
//    Thread-1 is running
//    Thread-0 is running
//    Thread-0 is running
//    Thread-1 is running
//    Thread-1 is running
//    Thread-1 is running
//    Thread-1 is running

    public static void main(String[] args) {
        YieldMethod t1 =new YieldMethod();
        YieldMethod t2 =new YieldMethod();
        t1.start();
        t2.start();

    }
}
