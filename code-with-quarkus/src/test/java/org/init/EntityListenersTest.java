package org.init;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.init.entitylistener.EntityListenerService;
import org.init.entitylistener.TestEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@QuarkusTest
@Slf4j
@Transactional
public class EntityListenersTest {

    @Inject
    EntityListenerTestHelper entityListenerTestHelper;

    @Inject
    EntityListenerService entityListenerService;

    @Inject
    EntityManager entityManager;

    @BeforeEach
    public void createTable() throws Exception {
        String createTableSql = "CREATE TABLE TEST_ENTITY (id VARCHAR(40) PRIMARY KEY, name VARCHAR(255))";
        entityManager.createNativeQuery(createTableSql).executeUpdate();
    }

    @Test
    public void entityListenerExceptionOnPostPersist() {

        String id = UUID.randomUUID().toString();

        try {
            entityListenerTestHelper.createEntity(id, "Martin");
        }
        catch (Exception e) {
            log.info("Error: ", e);
        }

        TestEntity entity = entityListenerService.loadById(id);

        int i = 0;
    }

}
