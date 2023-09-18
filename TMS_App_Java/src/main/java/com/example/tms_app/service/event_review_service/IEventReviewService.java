package com.example.tms_app.service.event_review_service;

import com.example.tms_app.models.dto.event_review.EventReviewDto;
import com.example.tms_app.models.dto.event_review.EventReviewPostDto;

import java.util.UUID;

public interface IEventReviewService {
    EventReviewDto saveEventReview(EventReviewPostDto eventReviewPostDto, UUID eventId, UUID userId);
}
