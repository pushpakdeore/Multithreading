package pushpak57multithreading;

public class SetPriorities extends  Thread {
    public SetPriorities(String name){
        super(name);
    }
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+"  priority : "+Thread.currentThread().getPriority()+" count : "+i);


            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        SetPriorities  l =new SetPriorities("pushpak");
        SetPriorities  m=new SetPriorities("Kunal");
        SetPriorities  n =new SetPriorities("Akash");

        n.setPriority(Thread.MAX_PRIORITY);//set the priority
        l.setPriority(Thread.MIN_PRIORITY);
        m.setPriority(Thread.NORM_PRIORITY);

        l.start();
        m.start();
        n.start();
        m.interrupt();  //if thread is wating or on sleep stop exicuting thread

    }


}
