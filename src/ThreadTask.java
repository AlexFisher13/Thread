import java.util.concurrent.*;

/**
 * Created by Fisher on 01.06.2016.
 */
public class ThreadTask {
    public static void main(String[] args) {
        Leonardo leonardo = new Leonardo();
        Thread th1 = new Thread(leonardo);
        th1.start();

        Mikilangelo mikilangelo = new Mikilangelo();
        Thread th2 = new Thread(mikilangelo);
        th2.start();

        ExecutorService ex = Executors.newCachedThreadPool();
        Future<Integer> s = ex.submit(new Rafael());
        try {
            System.out.println(s.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < 5; i++) {
            System.out.println("D");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

public static class Leonardo extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("L");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public static class Mikilangelo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("M");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public static class Rafael implements Callable<Integer>{
    int count;
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10; i++) {
            count++;
        }
        return count;
    }
}

}
