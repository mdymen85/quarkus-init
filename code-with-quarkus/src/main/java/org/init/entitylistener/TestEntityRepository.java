package org.init.entitylistener;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;

public interface TestEntityRepository extends PanacheRepository<TestEntity> {

    void save(TestEntity testEntity);

}