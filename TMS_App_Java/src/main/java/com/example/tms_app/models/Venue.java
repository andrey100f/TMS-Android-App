package com.example.tms_app.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="venues")
public class Venue implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    @Column(name="venue_id")
    private UUID venueId;

    @Column(name="location")
    private String location;

    @Column(name="type")
    private String type;

    @Column(name="capacity")
    private Integer capacity;

    @Version
    @Column(name="venue_version")
    private Integer venueVersion;

    public Venue() {
    }

    public UUID getVenueId() {
        return venueId;
    }

    public void setVenueId(UUID venueId) {
        this.venueId = venueId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getVenueVersion() {
        return venueVersion;
    }

    public void setTimestamp(Integer venueVersion) {
        this.venueVersion = venueVersion;
    }
}
