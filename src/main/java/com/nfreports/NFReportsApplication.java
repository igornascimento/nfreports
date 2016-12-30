package com.nfreports;

import com.nfreports.db.UserDAO;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class NFReportsApplication extends Application<NFReportsConfiguration> {

    public static void main(final String[] args) throws Exception {
        new NFReportsApplication().run(args);
    }

    /**
     * Hibernate
     */
    private final HibernateBundle<NFReportsConfiguration> hibernate = new HibernateBundle<NFReportsConfiguration>(UserDAO.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(NFReportsConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public String getName() {
        return "NFReports";
    }

    @Override
    public void initialize(final Bootstrap<NFReportsConfiguration> bootstrap) {
        // initializing Hibernate
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(final NFReportsConfiguration configuration,
                    final Environment environment) {

        // DateFormat actualDate = new SimpleDateFormat(configuration.getDateFormat());
        // environment.getObjectMapper().setDateFormat(actualDate);

        final UserDAO userDAO = new UserDAO(hibernate.getSessionFactory());
        environment.jersey().register(userDAO);

        System.out.println(userDAO.getAll());
    }

}
