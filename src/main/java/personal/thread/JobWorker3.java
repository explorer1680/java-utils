package personal.thread;

public class JobWorker3 implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();//if you have try-catch around sleep, you have to call this method to make the test in while work.
            }
            System.out.println("outside of try-catch");
        }
    }
}
