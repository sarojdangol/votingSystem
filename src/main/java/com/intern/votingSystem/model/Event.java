package com.intern.votingSystem.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.intern.votingSystem.dto.EventDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "event")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "event_id")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private int event_id;
    private String eventName;
    @Column(unique = true)
    private String eventCode;
    private LocalDateTime eventStartDate;
    private LocalDateTime eventEndDate;
//    @OneToMany(mappedBy = "event")
//    private List<CandidateProjection> candidate;
//    @JsonManagedReference


    public Event(EventDTO eventDTO){
        this.event_id=eventDTO.getEvent_id();
        this.eventName=eventDTO.getEventName();
        this.eventCode=eventDTO.getEventCode();
        this.eventStartDate =eventDTO.getEventStartDate();
        this.eventEndDate =eventDTO.getEventEndDate();
//        this.candidate= eventDTO.getCandidate();
    }
}
