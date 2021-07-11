package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Event {

    @Id
    @GeneratedValue
    Long id;
    @Column
    String eventName;
    @Column
    EventType eventType;
    @Column
    LocalDateTime eventDateTime;
    @Column
    String createdBy;
    @Column
    Location location;

    public Event() {
        //Explicitly empty
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public LocalDateTime getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
