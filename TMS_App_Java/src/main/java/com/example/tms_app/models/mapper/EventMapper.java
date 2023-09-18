package com.example.tms_app.models.mapper;

import com.example.tms_app.config.DateTimeFormat;
import com.example.tms_app.models.Event;
import com.example.tms_app.models.dto.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventMapper {
    private final VenueMapper venueMapper;
    private final EventReviewMapper eventReviewMapper;
    private final TicketCategoryMapper ticketCategoryMapper;

    @Autowired
    public EventMapper(TicketCategoryMapper ticketCategoryMapper, VenueMapper venueMapper, EventReviewMapper eventReviewMapper) {
        this.ticketCategoryMapper = ticketCategoryMapper;
        this.venueMapper = venueMapper;
        this.eventReviewMapper = eventReviewMapper;
    }

    public EventDto convertModelToDto(Event event) {
        EventDto eventDto = new EventDto();
        eventDto.setVenue(this.venueMapper.convertModelToDto(event.getVenue()));
        eventDto.setEventCategory(event.getEventCategory().getCategoryName());
        eventDto.setEventName(event.getEventName());
        eventDto.setEventDescription(event.getEventDescription());
        eventDto.setStartDate(event.getStartDate().format(DateTimeFormat.formatter));
        eventDto.setEndDate(event.getEndDate().format(DateTimeFormat.formatter));
        eventDto.setImageUrl(event.getImageUrl());
        eventDto.setTicketCategories(this.ticketCategoryMapper.convertModelListToDtoList(event.getTicketCategories()));
        eventDto.setEventReviews(this.eventReviewMapper.convertModelListToDtoList(event.getEventReviews()));
        return eventDto;
    }

    public List<EventDto> convertModelListToDtoList(List<Event> events) {
        List<EventDto> result = new ArrayList<>();
        for(Event event: events) {
            result.add(convertModelToDto(event));
        }
        return result;
    }
}
