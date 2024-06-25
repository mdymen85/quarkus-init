package org.init.completablefuture;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class CompletableFutureHelperService {

    public void method2Call() {
        try {
            Thread.sleep(1500);
            log.info("Call method 2 - {}", UUID.randomUUID());
        } catch (Exception e) {
            log.error("Error: ", e);
        }
    }

    public void method1Call() {
        try {
            log.info("Call method 1 - {}", UUID.randomUUID());
        } catch (Exception e) {
            log.error("Error: ", e);
        }
    }

    public void method3Call() {
        try {
            Thread.sleep(1500);
            log.info("Call method 2 - {}", UUID.randomUUID());
        } catch (Exception e) {
            log.error("Error: ", e);
        }
    }
}
