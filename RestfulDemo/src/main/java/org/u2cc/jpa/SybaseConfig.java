package org.u2cc.jpa;

import javafx.application.Platform;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "sybaseEntityManagerFactory",
        transactionManagerRef = "sybaseTransactionManager",
        basePackages = {
                "org.u2cc.jpa.sybase.repositories"
        }
)
public class SybaseConfig {
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "replicator.datasource.sybase")
    public DataSource sybaseDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "sybaseEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("sybaseDataSource") DataSource dataSource
    ) {
        return builder.dataSource(dataSource)
                .packages("org.u2cc.sybase.entities")
                .persistenceUnit("sybase")
                .build();
    }

    @Primary
    @Bean(name = "sybaseTransactionManager")
    public PlatformTransactionManager sybaseTransactionManager(
            @Qualifier("sybaseEntityManagerFactory") EntityManagerFactory sybaseEntityManagerFactory
    ) {
        return new JpaTransactionManager(sybaseEntityManagerFactory);
    }
}
