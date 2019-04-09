package personal.thread;


public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        JobWorker1 jb = new JobWorker1();
        Thread t = new Thread(jb);
        t.start();

        Thread.sleep(1000);

        t.interrupt();

    }
}
