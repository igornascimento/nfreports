package com.nfreports;

import com.nfreports.db.UserDAO;
import com.nfreports.resources.AuthRESTController;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.hibernate.SessionFactory;

/**
 * Initiates the application
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 * @version 1.0
 */
public class NFReportsApplication extends Application<NFReportsConfiguration> {

    public static void main(final String[] args) throws Exception {
        new NFReportsApplication().run(args);
    }

    /**
     * Hibernate
     */
    private final HibernateBundle<NFReportsConfiguration> hibernate = new HibernateBundle<NFReportsConfiguration>(UserDAO.class) {
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
        SessionFactory sessionFactory = hibernate.getSessionFactory();
    }

    @Override
    public void run(final NFReportsConfiguration configuration,
                    final Environment environment) {

        // TODO: check logged user
        //AuthRESTController authenticator = new AuthRESTController(configuration);
    }

}
