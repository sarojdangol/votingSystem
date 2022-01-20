package com.intern.votingSystem.service.impl;

import com.intern.votingSystem.dto.EventDTO;
import com.intern.votingSystem.dto.Message;
import com.intern.votingSystem.model.Event;
import com.intern.votingSystem.repository.EventRepository;
import com.intern.votingSystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Override
    public EventDTO addEvent(EventDTO eventDTO) {
        Event event = new Event(eventDTO);
        Event event1 = eventRepository.save(event);
        EventDTO eventDTO1 = new EventDTO(event1);
        return eventDTO1;
    }

    @Override
    public List<EventDTO> getAllEvent() {
        List<Event> eventList = eventRepository.getAllEvent();
        List<EventDTO> eventDTOList = new ArrayList<>();
        eventList.forEach(event -> {
            EventDTO eventDTO= new EventDTO(event);
            eventDTOList.add(eventDTO);
        });
        return eventDTOList;
    }

    @Override
    public EventDTO updateEvent(EventDTO eventDTO) {
        Event event= new Event(eventDTO);
        Event event1= eventRepository.save(event);
        return new EventDTO(event1);

    }

    @Transactional
    @Override
    public String deleteEvent(int id) {
        if(eventRepository.existsById(id)){
            eventRepository.deleteEvent(id);
            return Message.setMessage("002", "Event with given id deleted");
        }
        else{
            return Message.setMessage("002","Event with given id does not exist");
        }
    }
}
