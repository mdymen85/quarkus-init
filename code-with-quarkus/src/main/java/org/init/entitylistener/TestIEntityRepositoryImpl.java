package org.init.entitylistener;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TestIEntityRepositoryImpl implements TestEntityRepository {

    @Inject
    EntityManager entityManager;

    public TestEntity find(String id) {
        return entityManager.find(TestEntity.class, id);
    }

    @Override
    public void save(TestEntity testEntity) {
        entityManager.persist(testEntity);
    }


}
