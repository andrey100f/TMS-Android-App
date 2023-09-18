package com.example.tms_app.service.event_service;

import com.example.tms_app.models.*;
import com.example.tms_app.models.dto.EventDto;
import com.example.tms_app.models.dto.event_review.EventReviewDto;
import com.example.tms_app.models.dto.order_dto.OrderDto;
import com.example.tms_app.models.dto.order_dto.OrderPostDto;
import com.example.tms_app.models.exceptions.models.EntityNotFoundException;
import com.example.tms_app.models.mapper.EventMapper;
import com.example.tms_app.models.mapper.EventReviewMapper;
import com.example.tms_app.repository.EventRepository;
import com.example.tms_app.repository.EventReviewRepository;
import com.example.tms_app.repository.TicketCategoryRepository;
import com.example.tms_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventService implements IEventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    private final EventReviewRepository eventReviewRepository;
    private final EventReviewMapper eventReviewMapper;

    @Autowired
    public EventService(EventRepository eventRepository, EventReviewRepository eventReviewRepository,
                        EventMapper eventMapper, EventReviewMapper eventReviewMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
        this.eventReviewRepository = eventReviewRepository;
        this.eventReviewMapper = eventReviewMapper;
    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = (List<Event>) this.eventRepository.findAll();
        if(events.isEmpty()) {
            throw new EntityNotFoundException("Events not found!!");
        }
        return this.eventMapper.convertModelListToDtoList(events);
    }

    @Override
    public EventDto getEventById(UUID eventId) {
        Event event = this.eventRepository.getEventByEventId(eventId);
        if(event == null) {
            throw new EntityNotFoundException("Event not Found!!");
        }
        return this.eventMapper.convertModelToDto(event);
    }

    @Override
    public List<EventReviewDto> getEventReviewsByEventId(UUID eventReviewId) {
        List<EventReview> eventReviews = this.eventReviewRepository.getEventReviewsByEventEventId(eventReviewId);
        if(eventReviews.isEmpty()) {
            throw new EntityNotFoundException("Event Reviews Not Found!!");
        }
        return this.eventReviewMapper.convertModelListToDtoList(eventReviews);
    }

    @Override
    public List<EventDto> getEventsByVenueAndCategory(String venueLocation, String eventCategory) {
        List<Event> events = eventRepository.getEventsByVenueLocationAndEventCategoryCategoryName(venueLocation, eventCategory);
        if(events.isEmpty()) {
            throw new EntityNotFoundException("Events Not Found!!");
        }
        return eventMapper.convertModelListToDtoList(events);
    }
}
