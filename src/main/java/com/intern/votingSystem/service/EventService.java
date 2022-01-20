package com.intern.votingSystem.service;

import com.intern.votingSystem.dto.EventDTO;

import java.util.List;

public interface EventService {
    EventDTO addEvent(EventDTO eventDTO);

    List<EventDTO> getAllEvent();

    EventDTO updateEvent(EventDTO eventDTO);

    String deleteEvent(int id);
}
