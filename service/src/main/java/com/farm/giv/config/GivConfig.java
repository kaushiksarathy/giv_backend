package com.farm.giv.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GivConfig extends Configuration{
    @JsonProperty("database")
    private DatabaseConfig databaseConfig;
}
