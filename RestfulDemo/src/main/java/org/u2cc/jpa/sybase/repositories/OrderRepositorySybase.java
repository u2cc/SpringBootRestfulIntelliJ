package org.u2cc.jpa.sybase.repositories;

import org.springframework.data.repository.CrudRepository;
import org.u2cc.jpa.sybase.entities.SpringBootCustomerSybase;
import org.u2cc.jpa.sybase.entities.SpringBootOrderSybase;

public interface OrderRepositorySybase extends CrudRepository<SpringBootOrderSybase, Long> {
    SpringBootOrderSybase findById(long id);
    long count();
}
