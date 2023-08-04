package com.pivovarit.rental;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie")
class PersistedMovie {

    @Id
    private long id;

    private String title;

    private String type;

    public PersistedMovie() {
    }

    public PersistedMovie(long id, String title, String type) {
        this.id = id;
        this.title = title;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }
}
