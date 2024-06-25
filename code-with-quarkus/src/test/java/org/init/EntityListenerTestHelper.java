package org.init;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.init.entitylistener.EntityListenerService;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class EntityListenerTestHelper {

    @Inject
    EntityListenerService entityListenerService;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void createEntity(String id, String name) {
        entityListenerService.createEntity(id, name);
    }
}
