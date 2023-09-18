package com.example.tms_app.service.event_review_service;

import com.example.tms_app.models.Event;
import com.example.tms_app.models.EventReview;
import com.example.tms_app.models.User;
import com.example.tms_app.models.dto.event_review.EventReviewDto;
import com.example.tms_app.models.dto.event_review.EventReviewPostDto;
import com.example.tms_app.models.mapper.EventReviewMapper;
import com.example.tms_app.repository.EventRepository;
import com.example.tms_app.repository.EventReviewRepository;
import com.example.tms_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EventReviewService implements IEventReviewService {
    private final EventReviewRepository eventReviewRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final EventReviewMapper eventReviewMapper;

    @Autowired
    public EventReviewService(EventReviewRepository eventReviewRepository, UserRepository userRepository,
                              EventRepository eventRepository, EventReviewMapper eventReviewMapper) {
        this.eventReviewRepository = eventReviewRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.eventReviewMapper = eventReviewMapper;
    }

    @Override
    public EventReviewDto saveEventReview(EventReviewPostDto eventReviewPostDto, UUID eventId, UUID userId) {
        User user = this.userRepository.getUserByUserId(userId);
        Event event = this.eventRepository.getEventByEventId(eventId);
        EventReview eventReviewSaved = this.eventReviewRepository.save(this.eventReviewMapper
                .convertPostDtoToModel(eventReviewPostDto, event, user));
        return this.eventReviewMapper.convertModelToDto(eventReviewSaved);
    }
}
