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
    private PlayerStats stats;

    @Transient
    private PlayerStats feignStats;

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

    public PlayerStats getStats() {
        return stats;
    }

    public void setStats(final PlayerStats stats) {
        this.stats = stats;
    }

    public void setFeignStats(final PlayerStats feignStats) {
        this.feignStats = feignStats;
    }

    public PlayerStats getFeignStats() {
        return feignStats;
    }
}
