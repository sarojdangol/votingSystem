package com.intern.votingSystem.dto;

import com.intern.votingSystem.model.Candidate;
import com.intern.votingSystem.model.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

    private int event_id;
    private String eventName;
    private String eventCode;
    private LocalDateTime eventStartDate;
    private LocalDateTime eventEndDate;
//    private List<CandidateProjection> candidate;

    public EventDTO(Event event){
        this.event_id=event.getEvent_id();
        this.eventName=event.getEventName();
        this.eventCode=event.getEventCode();
        this.eventStartDate =event.getEventStartDate();
        this.eventEndDate =event.getEventEndDate();
//        this.candidate=event.getCandidate();
    }
}
