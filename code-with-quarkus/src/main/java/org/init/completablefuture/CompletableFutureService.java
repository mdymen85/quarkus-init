package org.init.completablefuture;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class CompletableFutureService {

    @Inject
    CompletableFutureHelperService completableFutureHelperService;

    private static final Integer ITERATIONS = 10;

    public void method1()  {
        for (int i = 0; i < ITERATIONS; i++) {
            completableFutureHelperService.method1Call();
        }
        log.info("method 1 finished");
    }


    public void method2()  {
        for (int i = 0; i < ITERATIONS; i++) {
            try {
                completableFutureHelperService.method2Call();
            } catch (Exception e) {
                log.error("Error: ", e);
            }
        }
        log.info("method 2 finished");
    }


    public void method3()  {
        for (int i = 0; i < ITERATIONS; i++) {
            completableFutureHelperService.method3Call();
        }
        log.info("method 3 finished");
    }


}
