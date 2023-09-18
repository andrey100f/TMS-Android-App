package com.example.tms_app.repository;

import com.example.tms_app.models.Event;
import com.example.tms_app.models.EventReview;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends CrudRepository<Event, UUID> {
    Event getEventByEventId(UUID eventId);
    Event getEventByEventName(String eventName);
    List<Event> getEventsByVenueLocationAndEventCategoryCategoryName(String venueLocation, String categoryName);
}
