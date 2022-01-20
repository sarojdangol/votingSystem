package com.intern.votingSystem.model;


import com.intern.votingSystem.dto.EventDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int event_id;
    private String eventName;
    @Column(unique = true)
    private String eventCode;
    private LocalDateTime eventStartDate;
    private LocalDateTime eventEndDate;

    public Event(EventDTO eventDTO){
        this.event_id=eventDTO.getEvent_id();
        this.eventName=eventDTO.getEventName();
        this.eventCode=eventDTO.getEventCode();
        this.eventStartDate =eventDTO.getEventStartDate();
        this.eventEndDate =eventDTO.getEventEndDate();
    }
}
