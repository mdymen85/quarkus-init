package org.init.entitylistener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TEST_ENTITY")
@Data
@EntityListeners(MyEntityListener.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity {

    @Id
    private String id;
    private String name;


}
