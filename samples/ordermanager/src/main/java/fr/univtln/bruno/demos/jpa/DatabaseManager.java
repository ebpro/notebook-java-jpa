package fr.univtln.bruno.demos.jpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.extern.java.Log;

import java.util.HashMap;
import java.util.Map;

@Log
public class DatabaseManager {

    private DatabaseManager() {}

    public final static EntityManagerFactory emf;

    static {
        Map<String, String> env = System.getenv();
        Map<String, Object> configOverrides = new HashMap<>();
        for (String envName : env.keySet()) {
            if (envName.contains("DATASOURCE_URL")) {
                log.info("Override with env. var. :" + envName);
                configOverrides.put("jakarta.persistence.jdbc.url", env.get(envName));
            }
            if (envName.contains("DATASOURCE_USERNAME")) {
                log.info("Override with env. var. :" + envName);
                configOverrides.put("jakarta.persistence.jdbc.user", env.get(envName));
            }
            if (envName.contains("DATASOURCE_PASSWORD")) {
                log.info("Override with env. var. :" + envName);
                configOverrides.put("jakarta.persistence.jdbc.password", env.get(envName));
            }
        }

        emf =
                Persistence.createEntityManagerFactory("ordermanager-pu", configOverrides);
    }

}
