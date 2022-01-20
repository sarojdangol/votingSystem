package com.intern.votingSystem.controller;

import com.intern.votingSystem.dto.EventDTO;
import com.intern.votingSystem.model.Event;
import com.intern.votingSystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vote/event")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping
    public EventDTO addEvent(@RequestBody EventDTO eventDTO) {
        return eventService.addEvent(eventDTO);
    }

    @GetMapping
    public List<EventDTO> getAllEvent(){
        return eventService.getAllEvent();
    }

    @PutMapping
    public EventDTO updateEvent(@RequestBody EventDTO eventDTO){
        return eventService.updateEvent(eventDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable int id){
        return eventService.deleteEvent(id);
    }
}
