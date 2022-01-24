package com.intern.votingSystem.service;

import com.intern.votingSystem.dto.CandidateDTO;
import com.intern.votingSystem.dto.EventDTO;
import com.intern.votingSystem.model.Event;

import java.util.List;

public interface EventService {
    EventDTO addEvent(EventDTO eventDTO);

    List<EventDTO> getAllEvent();

    EventDTO updateEvent(EventDTO eventDTO);

    String deleteEvent(int id);

//    List<CandidateDTO> getCandidateByEvent(int id);

}
