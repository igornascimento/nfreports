package com.nfreports.db.models;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
    private long id;
    private String content;

    public Task() {
        // Jackson deserialization
    }

    public Task(long id, String content) {
        this.id = id;
        this. content = content;
    }

    @JsonProperty
    public long getId() {
        return this.id;
    }

    @JsonProperty
    public String getContent() {
        return this.content;
    }
}
