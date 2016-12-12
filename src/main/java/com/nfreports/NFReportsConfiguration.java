package com.nfreports;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;

import javax.validation.constraints.*;

public class NFReportsConfiguration extends Configuration {

    @NotEmpty
    private String dateFormat;

    @NotEmpty
    private String server;

    public String getDateFormat() {
        return this.dateFormat;
    }

    public String getServer() {
        return this.server;
    }

}
