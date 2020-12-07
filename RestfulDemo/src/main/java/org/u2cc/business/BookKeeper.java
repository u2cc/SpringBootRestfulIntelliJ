package org.u2cc.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.u2cc.jpa.oracle.entities.SpringBootCustomerOracle;
import org.u2cc.jpa.oracle.repositories.CustomerRepositoryOracle;
import org.u2cc.jpa.oracle.repositories.OrderRepositoryOracle;
import org.u2cc.jpa.sybase.entities.SpringBootCustomerSybase;
import org.u2cc.jpa.sybase.entities.SpringBootOrderSybase;
import org.u2cc.jpa.sybase.repositories.CustomerRepositorySybase;
import org.u2cc.jpa.sybase.repositories.OrderRepositorySybase;
import org.u2cc.util.Utilities;

public class BookKeeper {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(BookKeeper.class);


    @Transactional(value = "chainedTransactionManager")
    public void insertCustomersAndOrders(CustomerRepositorySybase customerRepositorySybase,

                                         OrderRepositorySybase orderRepositorySybase,

                                         CustomerRepositoryOracle customerRepositoryOracle,

                                         OrderRepositoryOracle orderRepositoryOracle) {

        LOGGER.info("Deleting all Sybase customers");
        customerRepositorySybase.deleteAll();
        LOGGER.info(String.format("Total number of Sybase customer rows is %d", customerRepositorySybase.count()));
        LOGGER.info("Inserting new Sybase customer rows");
        customerRepositorySybase.save(new SpringBootCustomerSybase("James", "From CPACS team"));
        customerRepositorySybase.save(new SpringBootCustomerSybase("Toral", "From CPACS team"));
        customerRepositorySybase.save(new SpringBootCustomerSybase("Jaya", "From CPACS team"));
        LOGGER.info("Finding all Sybase customers");
        LOGGER.info("---------------------");
        for (SpringBootCustomerSybase customer : customerRepositorySybase.findAll()) {
            LOGGER.info(customer.toString());
        }

             /*
             *
              logger.info("");
              logger.info("Deleting all orders");
             orderRepositorySybase.deleteAll();
             logger.info(String.format("Total number of order rows is %d", orderRepositorySybase.count()));
              logger.info("Inserting new order rows");
             orderRepositorySybase.save(new SpringBootOrderSybase(5l, Utilities.parseTimestamp("2005-11-11 10:57:42.68")));
              logger.info("Finding all orders");
             logger.info("---------------------");
              for(SpringBootOrderSybase order:orderRepositorySybase.findAll()) {
                    logger.info(order.toString());
             }
              logger.info("");
             */

        LOGGER.info("Deleting all Oracle customers");
        customerRepositoryOracle.deleteAll();
        LOGGER.info(String.format("Total number of Oracle customer rows is %d", customerRepositoryOracle.count()));
        LOGGER.info("Inserting new Oracle customer rows");
        customerRepositoryOracle.save(new SpringBootCustomerOracle("James", "From CPACS team"));
        customerRepositoryOracle.save(new SpringBootCustomerOracle("Toral", "From CPACS team"));
        customerRepositoryOracle.save(new SpringBootCustomerOracle("Jaya", "From CPACS team"));
        LOGGER.info("Finding all Oracle customers");
        LOGGER.info("---------------------");

        for (SpringBootCustomerOracle customer : customerRepositoryOracle.findAll()) {
            LOGGER.info(customer.toString());
        }


        LOGGER.info("");
        LOGGER.info("Deleting all Sybase orders");
        orderRepositorySybase.deleteAll();
        LOGGER.info(String.format("Total number of Sybase order rows is %d", orderRepositorySybase.count()));
        LOGGER.info("Inserting new Sybase order rows");
        orderRepositorySybase.save(new SpringBootOrderSybase(5l, Utilities.parseTimestamp("2005-11-11 10:57:42.68")));
        LOGGER.info("Finding all Sybase orders");
        LOGGER.info("---------------------");

        for (SpringBootOrderSybase order : orderRepositorySybase.findAll()) {
            LOGGER.info(order.toString());
        }
        LOGGER.info("");
    }
}
