package org.u2cc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

/**
 * The main application class must be in a root package above other classes.
 * This is because @SpringBootApplication implicitly include @ComponentScan with default attributes.
 * Other implicitly included attributes are @Configuration and @EnableAutoConfigruation
 * @author James Chen
 */
@SpringBootApplication(
        exclude = {
                DataSourceAutoConfiguration.class,
                //HibernateJpaAutoConfiguration.class
                DataSourceTransactionManagerAutoConfiguration.class
        }
)
public class RESTfulStartup {
    public static void main(String[] args) {
        SpringApplication.run(RESTfulStartup.class, args);
    }
}
