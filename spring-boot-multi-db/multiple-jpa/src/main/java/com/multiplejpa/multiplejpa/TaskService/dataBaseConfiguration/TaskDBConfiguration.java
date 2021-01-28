package com.multiplejpa.multiplejpa.TaskService.dataBaseConfiguration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "taskEntityManagerFactory",
        transactionManagerRef = "taskTransactionManager",
        basePackages = {"com.multiplejpa.multiplejpa.TaskService.Repository"}
)
public class TaskDBConfiguration {
    
    @Bean(name = "taskDataSource")
    @ConfigurationProperties(prefix = "spring.task.datasource")
    public DataSource taskDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "taskEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("taskDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.multiplejpa.multiplejpa.TaskService.model")
                .persistenceUnit("Task")
                .build();
    }

    @Bean(name = "taskTransactionManager")
    public PlatformTransactionManager taskTransactionManager(
            @Qualifier("taskEntityManagerFactory") EntityManagerFactory
                    taskEntityManagerFactory
    ) {
        return new JpaTransactionManager(taskEntityManagerFactory);
    }
}
