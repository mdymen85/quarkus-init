package org.init;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.Config;

import java.time.LocalDateTime;

@ApplicationScoped
public class TestService {

    @Inject
    Config config;

    public TestObject setDateTime(TestObject testObject) {
        testObject.setDateTime(LocalDateTime.now());
        testObject.setAppName(config.getValue("quarkus.application.name", String.class));
        return testObject;
    }

}
