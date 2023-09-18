package com.example.tms_app.controller;

import com.example.tms_app.models.dto.EventDto;
import com.example.tms_app.models.dto.event_review.EventReviewDto;
import com.example.tms_app.models.dto.event_review.EventReviewPostDto;
import com.example.tms_app.service.event_review_service.EventReviewService;
import com.example.tms_app.service.event_review_service.IEventReviewService;
import com.example.tms_app.service.event_service.EventService;
import com.example.tms_app.service.event_service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/events")
public class EventController {
    private final IEventService eventService;
    private final IEventReviewService eventReviewService;

    @Autowired
    public EventController(EventService eventService, EventReviewService eventReviewService) {
        this.eventService = eventService;
        this.eventReviewService = eventReviewService;
    }

    @GetMapping("")
    public List<EventDto> getAllEvents() {
        return this.eventService.getAllEvents();
    }

    @GetMapping("/{eventId}")
    public EventDto getEventById(@PathVariable UUID eventId) {
        return this.eventService.getEventById(eventId);
    }

    @GetMapping("/{eventId}/reviews")
    public List<EventReviewDto> getEventReviewsByEventId(@PathVariable  UUID eventId) {
        return this.eventService.getEventReviewsByEventId(eventId);
    }

    @GetMapping("/filters")
    public List<EventDto> getEventsByVenueLocationAndEventCategory(@RequestParam(name="location") String venueLocation,
                                                                   @RequestParam(name="category") String eventCategory) {
        return eventService.getEventsByVenueAndCategory(venueLocation, eventCategory);
    }

    @PostMapping("/{eventId}/reviews")
    public EventReviewDto saveEventReview(@RequestBody EventReviewPostDto eventReviewPostDto,
                                          @PathVariable UUID eventId, @PathVariable UUID userId) {
        return this.eventReviewService.saveEventReview(eventReviewPostDto, eventId, userId);
    }
}
