package com.nfreports;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class NFReportsApplication extends Application<NFReportsConfiguration> {

    public static void main(final String[] args) throws Exception {
        new NFReportsApplication().run(args);
    }

    @Override
    public String getName() {
        return "NFReports";
    }

    @Override
    public void initialize(final Bootstrap<NFReportsConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final NFReportsConfiguration configuration,
                    final Environment environment) {

        DateFormat actualDate = new SimpleDateFormat(configuration.getDateFormat());
        environment.getObjectMapper().setDateFormat(actualDate);

    }

}
