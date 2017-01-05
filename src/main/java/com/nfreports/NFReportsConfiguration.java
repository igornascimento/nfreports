package com.nfreports;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Configuration class
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 * @version 1.0
 */
public class NFReportsConfiguration extends Configuration {

    @NotEmpty
    private String dateFormat;

    @NotEmpty
    private String server;

    @NotNull
    @Valid
    private DataSourceFactory database = new DataSourceFactory();


    public String getDateFormat() {
        return this.dateFormat;
    }

    public String getServer() {
        return this.server;
    }

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

}
