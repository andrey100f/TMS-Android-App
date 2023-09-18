package com.example.tms_app.models.dto.event_review;

import com.example.tms_app.models.dto.user.UserDto;

import java.io.Serializable;

public class EventReviewDto implements Serializable {
    private UserDto user;
    private String reviewText;
    private Integer rating;

    public EventReviewDto() {
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
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
}
