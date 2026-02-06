package com.asigmaventures.assignment.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;

/**
 * Component responsible for initializing the database schema on application startup.
 */
@Component
@Slf4j
public class DbInitializer implements ApplicationRunner {

    private final DatabaseClient databaseClient;

    /**
     * Constructs a new DbInitializer with the given DatabaseClient.
     *
     * @param databaseClient the DatabaseClient to use for executing SQL queries
     */
    public DbInitializer(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    /**
     * Executes the database initialization logic.
     * Creates the 'items' table if it does not already exist.
     *
     * @param args incoming application arguments
     */
    @Override
    public void run(ApplicationArguments args) {
        log.info("Initializing database schema...");
        databaseClient.sql("""
            CREATE TABLE IF NOT EXISTS items (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(255),
                description VARCHAR(255)
            )
        """)
        .then()
        .doOnSuccess(unused -> log.info("Database schema initialized successfully."))
        .doOnError(error -> log.error("Error initializing database schema: {}", error.getMessage()))
        .subscribe();
    }
}
