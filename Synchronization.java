package pushpak57multithreading;

class Count{
    int count =0;
    public synchronized void increment(){ //synchronized
        count++;
//        Synchronization(this)  {
//            count++
//        }
    }
    public int getCount(){
        return count;
    }
}


public class Synchronization  extends  Thread {
    private Count counter;
    public Synchronization(Count counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

class Test{
    public static void main(String[] args) {
        Count counter =new Count();
        Synchronization t1 =new Synchronization(counter);
        Synchronization t2 =new Synchronization(counter);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(counter.getCount());


    }
}
