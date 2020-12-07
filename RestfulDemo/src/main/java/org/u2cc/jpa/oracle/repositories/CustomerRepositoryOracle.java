package org.u2cc.jpa.oracle.repositories;

import org.springframework.data.repository.CrudRepository;
import org.u2cc.jpa.oracle.entities.SpringBootCustomerOracle;

import java.util.List;

public interface CustomerRepositoryOracle extends CrudRepository<SpringBootCustomerOracle, Long> {
    List<SpringBootCustomerOracle> findByName(String name);
    SpringBootCustomerOracle findByID(long id);
    long count();
}
