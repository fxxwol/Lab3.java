package task4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(final String[] args) {
        final Resource resource = new Resource(15);
        final Resource resource1 = new Resource(20);

        final Thread thread1 = new Thread(new Calculation(resource));
        thread1.start();
        final Thread thread2 = new Thread(new Calculation(resource1));
        thread2.start();

        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new Calculation(resource));
        executorService.execute(new Calculation(resource1));

        executorService.shutdown();
    }
}
