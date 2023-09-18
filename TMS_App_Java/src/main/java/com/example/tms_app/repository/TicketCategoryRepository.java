package com.example.tms_app.repository;

import com.example.tms_app.models.TicketCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TicketCategoryRepository extends CrudRepository<TicketCategory, UUID> {
    TicketCategory getTicketCategoriesByTicketCategoryId(UUID ticketCategoryId);
    TicketCategory getTicketCategoriesByEventEventIdAndDescription(UUID eventId, String description);
}
