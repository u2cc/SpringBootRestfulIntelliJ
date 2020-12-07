package org.u2cc.jpa;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class TransactionManagerConfig {
    @Bean(name = "chainedTransactionManager")
    public ChainedTransactionManager transactionManager(
            @Qualifier("sybaseTransactionManager") PlatformTransactionManager sybaseTransactionManager,
            @Qualifier("oracleTransactionManager") PlatformTransactionManager oracleTransactionManager) {
        return new ChainedTransactionManager(sybaseTransactionManager, oracleTransactionManager);
    }
}
