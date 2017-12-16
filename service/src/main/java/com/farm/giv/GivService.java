package com.farm.giv;

import com.farm.giv.config.GivConfig;
import com.farm.giv.module.GivModule;
import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.logging.LoggingFeature;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GivService extends Application<GivConfig> {
    @Override
    public void initialize(Bootstrap<GivConfig> bootstrap) {
        super.initialize(bootstrap);
        bootstrap.addBundle(GuiceBundle.<GivConfig>newBuilder()
                .addModule(new GivModule())
                .enableAutoConfig(getClass().getPackage().getName())
                .setConfigClass(GivConfig.class)
                .build(Stage.DEVELOPMENT)
        );
    }
    @Override
    public void run(GivConfig givConfig, Environment environment) throws Exception {
        environment.jersey().register(new LoggingFeature(Logger.getLogger("inbound"),
                Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 8192));
    }

    public static void main(String[] args) throws Exception {
        new GivService().run(args);
    }
}
