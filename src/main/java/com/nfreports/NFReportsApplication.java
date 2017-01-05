package com.nfreports;

import com.nfreports.db.UserDAO;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class NFReportsApplication extends Application<NFReportsConfiguration> {

    public static void main(final String[] args) throws Exception {
        new NFReportsApplication().run(args);
    }

    /**
     * Hibernate bundle
     */
    private final HibernateBundle<NFReportsConfiguration> hibernate = new HibernateBundle<NFReportsConfiguration>(UserDAO.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(NFReportsConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    /**
     * Initializes application
     * @param bootstrap
     */
    @Override
    public void initialize(final Bootstrap<NFReportsConfiguration> bootstrap) {
        // initializing Hibernate
        bootstrap.addBundle(hibernate);

        // static pages
        bootstrap.addBundle(new AssetsBundle("views","/login","login.html","login"));
    }

    /**
     * Configures resources and runs the application
     * @param configuration
     * @param environment
     */
    @Override
    public void run(final NFReportsConfiguration configuration,
                    final Environment environment) {

        configureResources(configuration, environment);
    }

    /**
     * Resources configurations (available endpoints)
     * @param config NFReportsConfiguration
     * @param env Environment
     */
    protected void configureResources(NFReportsConfiguration config, Environment env) {
        //TODO: include all resources here
    }

}
