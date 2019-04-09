package personal.thread;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        JobWorker3 jb = new JobWorker3();
        Thread t = new Thread(jb);
        t.start();

        Thread.sleep(1000);

        t.interrupt();
    }
}
