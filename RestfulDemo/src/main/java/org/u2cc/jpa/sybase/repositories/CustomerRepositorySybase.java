package org.u2cc.jpa.sybase.repositories;

import org.springframework.data.repository.CrudRepository;
import org.u2cc.jpa.sybase.entities.SpringBootCustomerSybase;
import org.u2cc.jpa.sybase.entities.SpringBootOrderSybase;

import javax.swing.*;
import java.util.List;

public interface CustomerRepositorySybase extends CrudRepository<SpringBootCustomerSybase, Long> {
    List<SpringBootOrderSybase> findByName(String name);
    SpringBootCustomerSybase findById(long id);
    long count();
}
