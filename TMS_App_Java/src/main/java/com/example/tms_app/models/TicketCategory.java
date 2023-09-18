package com.example.tms_app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name="ticket_categories")
public class TicketCategory implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    @Column(name="ticket_category_id")
    private UUID ticketCategoryId;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private Float price;

    @Version
    @Column(name="ticket_category_version")
    private Integer ticketCategoryVersion;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="event_id")
    private Event event;

    public TicketCategory() {
    }

    public UUID getTicketCategoryId() {
        return ticketCategoryId;
    }

    public void setTicketCategoryId(UUID ticketCategoryId) {
        this.ticketCategoryId = ticketCategoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getTicketCategoryVersion() {
        return ticketCategoryVersion;
    }

    public void setTimestamp(Integer ticketCategoryVersion) {
        this.ticketCategoryVersion = ticketCategoryVersion;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
