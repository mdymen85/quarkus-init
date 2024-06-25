package org.init.entitylistener;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class EntityListenerService {

    @Inject
    TestIEntityRepositoryImpl testEntityRepository;

    @Transactional
    public void createEntity(String id, String name) {
        var entity = TestEntity
                .builder()
                .id(id)
                .name(name)
                .build();

        testEntityRepository.save(entity);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public TestEntity loadById(String id) {
        return this.testEntityRepository.find(id);
    }

}
