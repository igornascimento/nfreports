package com.nfreports;

import com.mysql.cj.jdbc.MysqlDataSourceFactory;
import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class NFReportsConfiguration extends Configuration {

    @NotEmpty
    private String dateFormat;

    @NotEmpty
    private String server;

    /**
     * Data base access configuration
     */
    @NotNull
    @Valid
    private MysqlDataSourceFactory dataSourceFactory = new MysqlDataSourceFactory();


    public String getDateFormat() {
        return this.dateFormat;
    }

    public String getServer() {
        return this.server;
    }

    @JsonProperty("database")
    public MysqlDataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }

}
