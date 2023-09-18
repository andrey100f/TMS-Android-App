package com.example.tms_app.models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="event_reviews")
public class EventReview implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    @Column(name="review_id")
    private UUID reviewId;

    @Column(name="review_text")
    private String reviewText;

    @Column(name="rating")
    private Integer rating;

    @Version
    @Column(name="event_review_version")
    private Integer event_review_version;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="event_id")
    private Event event;

    public EventReview() {
    }

    public UUID getReviewId() {
        return reviewId;
    }

    public void setReviewId(UUID reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getEvent_review_version() {
        return event_review_version;
    }

    public void setEvent_review_version(Integer event_review_version) {
        this.event_review_version = event_review_version;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
