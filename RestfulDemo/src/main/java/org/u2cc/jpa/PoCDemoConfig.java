package org.u2cc.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.u2cc.business.BookKeeper;
import org.u2cc.jpa.oracle.repositories.CustomerRepositoryOracle;
import org.u2cc.jpa.oracle.repositories.OrderRepositoryOracle;
import org.u2cc.jpa.sybase.repositories.CustomerRepositorySybase;
import org.u2cc.jpa.sybase.repositories.OrderRepositorySybase;

public class PoCDemoConfig {
    @Autowired
    BookKeeper bookKeeper;
    private static final Logger LOGGER = LoggerFactory.getLogger(PoCDemoConfig.class);

    @Bean
    public BookKeeper bookKeeper() {
        return new BookKeeper();
    }

    @Bean
    public CommandLineRunner demo(CustomerRepositorySybase customerRepositorySybase,
                                  OrderRepositorySybase orderRepositorySybase,
                                  CustomerRepositoryOracle customerRepositoryOracle,
                                  OrderRepositoryOracle orderRepositoryOracle){
        return (args -> {
            bookKeeper.insertCustomersAndOrders(customerRepositorySybase
                    ,orderRepositorySybase
                    ,customerRepositoryOracle
                    ,orderRepositoryOracle);
        });
    }
}
