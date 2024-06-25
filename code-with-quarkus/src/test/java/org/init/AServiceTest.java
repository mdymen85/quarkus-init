package org.init;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.init.strategy.AService;
import org.junit.jupiter.api.Test;

@QuarkusTest
//@QuarkusTestResource(H2DatabaseTestResource.class)
public class AServiceTest {

    @Inject
    AService aService;

    @Test
    public void test() {
        aService.methodA("A1");
        aService.methodA("A2");
    }
}
