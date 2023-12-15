import java.time.Instant;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LotsOfTasks {
    public static void main(String[] args) throws Exception {

        Thread.Builder.OfVirtual virtual = Thread.ofVirtual().name("ys");
        var hi = ":d";

        Runnable runnable = () -> {
            for(int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("hihihi " + i + "name : " + Thread.currentThread().getName());
            }
        };

        long start = Instant.now().getEpochSecond();

        try (ExecutorService service = Executors.newVirtualThreadPerTaskExecutor()) {
            for(int i = 0; i < 100; i++) {
                service.submit(runnable);
            }
        }

        long end = Instant.now().getEpochSecond();

        System.out.println("comsume time = " + (end - start));
    }
}
