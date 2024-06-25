package org.init.strategy;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class A1 extends A{

    @Override
    void methodA() {
        log.info("Method A1 executed!");
    }

    @Override
    String type() {
        return "A1";
    }
}
