package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class UpdatedEventDto {

    Long id;
    String eventName;
    EventType eventType;
    LocalDateTime eventDateTime;
    String createdBy;
    Location location;

    public UpdatedEventDto() {
        //Explicitly empty
    }
    @JsonProperty
    public Long getId() {
        return id;
    }
    @JsonProperty
    public void setId(Long id) {
        this.id = id;
    }
    @JsonProperty
    public String getEventName() {
        return eventName;
    }
    @JsonProperty
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    @JsonProperty
    public EventType getEventType() {
        return eventType;
    }
    @JsonProperty
    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
    @JsonProperty
    public LocalDateTime getEventDateTime() {
        return eventDateTime;
    }
    @JsonProperty
    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }
    @JsonProperty
    public String getCreatedBy() {
        return createdBy;
    }
    @JsonProperty
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}

