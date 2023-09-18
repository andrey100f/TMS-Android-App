package com.example.tms_app.models.mapper;

import com.example.tms_app.models.Event;
import com.example.tms_app.models.EventReview;
import com.example.tms_app.models.User;
import com.example.tms_app.models.dto.event_review.EventReviewDto;
import com.example.tms_app.models.dto.event_review.EventReviewPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventReviewMapper {
    private final UserMapper userMapper;

    @Autowired
    public EventReviewMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public EventReviewDto convertModelToDto(EventReview eventReview) {
        EventReviewDto eventReviewDto = new EventReviewDto();
        eventReviewDto.setUser(this.userMapper.convertModelTodDto(eventReview.getUser()));
        eventReviewDto.setReviewText(eventReview.getReviewText());
        eventReviewDto.setRating(eventReview.getRating());
        return eventReviewDto;
    }

    public List<EventReviewDto> convertModelListToDtoList(List<EventReview> eventReviews) {
        List<EventReviewDto> result = new ArrayList<>();
        for(EventReview eventReview: eventReviews) {
            result.add(convertModelToDto(eventReview));
        }
        return result;
    }

    public EventReview convertPostDtoToModel(EventReviewPostDto eventReviewPostDto, Event event, User user) {
        EventReview eventReview = new EventReview();
        eventReview.setEvent(event);
        eventReview.setReviewText(eventReviewPostDto.getReviewText());
        eventReview.setUser(user);
        eventReview.setRating(eventReviewPostDto.getRating());
        return eventReview;
    }
}
