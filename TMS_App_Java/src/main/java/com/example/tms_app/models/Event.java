package com.example.tms_app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "events")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="event_id")
    private UUID eventId;

    @Column(name="event_name")
    private String eventName;

    @Column(name="event_description")
    private String eventDescription;

    @Column(name="start_date")
    private LocalDateTime startDate;

    @Column(name="end_date")
    private LocalDateTime endDate;

    @Column(name="image_url")
    private String imageUrl;

    @Version
    @Column(name="event_version")
    private Integer eventVersion;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="venue_id")
    private Venue venue;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="category_id")
    private EventCategory eventCategory;

    @JsonIgnoreProperties("event")
    @OneToMany(mappedBy="event", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<TicketCategory> ticketCategories;

    @JsonIgnoreProperties("event")
    @OneToMany(mappedBy="event", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<EventReview> eventReviews;

    public Event() {
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getEventVersion() {
        return this.eventVersion;
    }

    public void setEventVersion(Integer eventVersion) {
        this.eventVersion = eventVersion;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public List<TicketCategory> getTicketCategories() {
        return ticketCategories;
    }

    public void setTicketCategories(List<TicketCategory> ticketCategories) {
        this.ticketCategories = ticketCategories;
    }

    public List<EventReview> getEventReviews() {
        return eventReviews;
    }

    public void setEventReviews(List<EventReview> eventReviews) {
        this.eventReviews = eventReviews;
    }
}
