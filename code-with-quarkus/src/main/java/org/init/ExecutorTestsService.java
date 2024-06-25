package org.init;

//import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;

@Slf4j
@ApplicationScoped
public class ExecutorTestsService {

    @Inject
    ConfigClass configClass;

//    @WithSpan
    public void execute() throws InterruptedException {

//        MdcUtils.put("traceId", traceId);

        var iterations = 50;

        StopWatch executorStopWatch = new StopWatch("executorStopWatch");
        ExecutorService ex = Executors.newFixedThreadPool(configClass.getThreads(), new MyThreadFactory(configClass.getThreadName()));
        CountDownLatch countDownLatch = new CountDownLatch(iterations);
        executorStopWatch.start();
        for (int i = 0; i < iterations; i++) {
            int finalI = i;
            ex.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info(Thread.currentThread().getName() + " " + finalI);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorStopWatch.stop();

        log.info("time elapsed: {} seconds",executorStopWatch.getTime(TimeUnit.SECONDS));
    }

}
