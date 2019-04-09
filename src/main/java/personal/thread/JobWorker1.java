package personal.thread;

public class JobWorker1 implements Runnable{
    @Override
    public void run() {

        //this runnable using InterruptedException to stop while sleep
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
            e.printStackTrace();
//            return;
        } finally {
            System.out.println("in finally!");
            //do something here
        }

    }
}
