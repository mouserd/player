package com.pixelus.player.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Player {

    @Id
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Transient
    private PlayerStats statsRestTemplate;

    @Transient
    private PlayerStats statsFeign;

    protected Player() {
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public PlayerStats getStatsRestTemplate() {
        return statsRestTemplate;
    }

    public void setStatsRestTemplate(final PlayerStats statsRestTemplate) {
        this.statsRestTemplate = statsRestTemplate;
    }

    public void setStatsFeign(final PlayerStats statsFeign) {
        this.statsFeign = statsFeign;
    }

    public PlayerStats getStatsFeign() {
        return statsFeign;
    }
}
