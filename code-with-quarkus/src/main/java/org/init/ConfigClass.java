package org.init;

import io.smallrye.config.ConfigMapping;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import javax.xml.namespace.QName;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperties;

@ApplicationScoped
public class ConfigClass {

    @Inject
    private Config config;

    public String getThreadName() {
        return config.getValue("application.test.name", String.class);
    }

    public Integer getThreads() {
        return config.getValue("application.test.threads", Integer.class);
    }
}
