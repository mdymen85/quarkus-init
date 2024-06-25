package org.init.strategy;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class AService {

    @Inject
    Instance<A> aInstance;

    public void methodA(String type) {
        var aResultOpt = aInstance.stream().filter(a -> a.type().equals(type)).findAny();

        if (aResultOpt.isEmpty()) {
            throw new RuntimeException();
        }

        aResultOpt.get().methodA();

    }

}
