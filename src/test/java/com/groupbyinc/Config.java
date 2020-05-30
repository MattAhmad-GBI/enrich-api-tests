package com.groupbyinc;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration properties.  These can be overwrite using environment variables as part of deployment
 */
@Configuration
@ComponentScan("com.groupbyinc")
@SpringBootTest(classes = Config.class)
public class Config {

    @Value("${URL}")
    private String url;

    @Value("${CLIENT_KEY}")
    private String clientKey;

    @Value("${COLLECTION}")
    private String collection;

    public String getUrl() {
        return url;
    }

    public String getClientKey() {
        return clientKey;
    }

    public String getCollection() {
        return collection;
    }
}