package com.example.tms_app.repository;

import com.example.tms_app.models.EventReview;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EventReviewRepository extends CrudRepository<EventReview, UUID> {
    List<EventReview> getEventReviewsByEventEventId(UUID eventId);
}
