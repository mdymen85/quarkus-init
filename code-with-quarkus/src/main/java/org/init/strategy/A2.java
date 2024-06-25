package org.init.strategy;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class A2 extends A{

    @Override
    void methodA() {
        log.info("Method A2 executed!");
    }

    @Override
    String type() {
        return "A2";
    }
}
