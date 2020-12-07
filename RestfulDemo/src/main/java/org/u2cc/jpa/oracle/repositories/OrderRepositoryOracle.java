package org.u2cc.jpa.oracle.repositories;

import org.springframework.data.repository.CrudRepository;
import org.u2cc.jpa.oracle.entities.SpringBootOrderOracle;

public interface OrderRepositoryOracle extends CrudRepository<SpringBootOrderOracle, Long> {
    SpringBootOrderOracle findById(long id);
    long count();
}
