// Generated by delombok at Fri Mar 17 11:01:30 UTC 2023
package fr.univtln.bruno.demos.jpa.hello;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class DatabaseManager {
    public static final EntityManagerFactory emf;
    @java.lang.SuppressWarnings("all")
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(DatabaseManager.class.getName());

    static {
        Map<String, String> env = System.getenv();
        Map<String, Object> configOverrides = new HashMap<>();
        for (String envName : env.keySet()) {
            if (envName.contains("DATASOURCE_URL")) {
                log.info("Override with env. var. : {0}", envName);
                configOverrides.put("jakarta.persistence.jdbc.url", env.get(envName));
            }
            if (envName.contains("DATASOURCE_USERNAME")) {
                log.info("Override with env. var. : {0}", envName);
                configOverrides.put("jakarta.persistence.jdbc.user", env.get(envName));
            }
            if (envName.contains("DATASOURCE_PASSWORD")) {
                log.info("Override with env. var. : {0}", envName);
                configOverrides.put("jakarta.persistence.jdbc.password", env.get(envName));
            }
        }
        emf = Persistence.createEntityManagerFactory("hellojpa-pu", configOverrides);
    }

    private DatabaseManager() {
    }
}