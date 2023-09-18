package com.example.tms_app.service.event_service;

import com.example.tms_app.models.dto.EventDto;
import com.example.tms_app.models.dto.event_review.EventReviewDto;
import com.example.tms_app.models.dto.order_dto.OrderDto;
import com.example.tms_app.models.dto.order_dto.OrderPostDto;

import java.util.List;
import java.util.UUID;

public interface IEventService {
    List<EventDto> getAllEvents();
    EventDto getEventById(UUID eventId);
    List<EventReviewDto> getEventReviewsByEventId(UUID eventReviewId);
    List<EventDto> getEventsByVenueAndCategory(String venueLocation, String eventCategory);
}
