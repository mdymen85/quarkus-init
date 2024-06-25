package org.init;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import java.util.concurrent.CompletableFuture;
import lombok.extern.slf4j.Slf4j;
import org.init.completablefuture.CompletableFutureHelperService;
import org.init.completablefuture.CompletableFutureService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@QuarkusTest
@Slf4j
public class CompletableFutureTests {

    @Inject
    CompletableFutureService completableFutureService;

    @InjectMock
    CompletableFutureHelperService completableFutureHelperService;

    @Test
    public void completableFutureWithJoin() {

        CompletableFuture<Void> method1 = CompletableFuture.runAsync(() -> completableFutureService.method1());
        CompletableFuture<Void> method2 = CompletableFuture.runAsync(() -> completableFutureService.method2());
        CompletableFuture<Void> method3 = CompletableFuture.runAsync(() -> completableFutureService.method3());

        CompletableFuture<Void> test = CompletableFuture.allOf(method1, method2, method3);

        log.info("Waiting for join...");

        test.join();

        log.info("Joined succesfully");

        verify(completableFutureHelperService, times(10)).method1Call();
        verify(completableFutureHelperService, times(10)).method2Call();
        verify(completableFutureHelperService, times(10)).method3Call();
    }

    @Test
    public void completableFutureWithoutJoin() {

        CompletableFuture.runAsync(() -> completableFutureService.method1());
        CompletableFuture.runAsync(() -> completableFutureService.method2());
        CompletableFuture.runAsync(() -> completableFutureService.method3());
//
//        verify(completableFutureHelperService, atMost(9)).method1Call();
//        verify(completableFutureHelperService, atMost(9)).method2Call();
    }

}
