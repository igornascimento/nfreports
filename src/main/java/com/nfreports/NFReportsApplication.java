package com.nfreports;

import com.nfreports.resources.TaskListResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class NFReportsApplication extends Application<NFReportsConfiguration> {

    public static void main(String[] args) throws Exception {
        new NFReportsApplication().run(args);
    }

    @Override
    public String getName() {
        return "task-list-service";
    }

    @Override
    public void initialize(Bootstrap<NFReportsConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(NFReportsConfiguration configuration,
                    Environment environment) {
        // register resources
        final TaskListResource resource = new TaskListResource(configuration.getMaxLength());
        environment.jersey().register(resource);
    }

}