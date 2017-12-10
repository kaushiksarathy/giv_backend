package com.farm.giv.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
@Getter
public class DatabaseConfig {
    private final String driverClass;
    private final String url;
    private final String user;
    private final String password;
    private final long maxWaitForConnection;
    private final String validationQuery;
    private final long validationQueryTimeout;
    private final int minSize;
    private final int maxSize;
    private final boolean checkConnectionWhileIdle;
    private final long minIdleTime;
    private final Map<String,String> properties;
}
