package com.example.tms_app.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name="event_categories")
public class EventCategory implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    @Column(name="category_id")
    private UUID categoryId;

    @Column(name="category_name")
    private String categoryName;

    @Version
    @Column(name="event_category_version")
    private Integer eventCategoryVersion;

    public EventCategory() {
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getEventCategoryVersion() {
        return eventCategoryVersion;
    }

    public void setTimestamp(Integer eventCategoryVersion) {
        this.eventCategoryVersion = eventCategoryVersion;
    }
}
