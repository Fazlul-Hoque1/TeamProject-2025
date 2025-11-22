
package com.eventorganizer.event_org.controller;

import com.eventorganizer.event_org.model.Event;
import com.eventorganizer.event_org.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin("*")
public class EventController {

    @Autowired
    private EventRepository repo;


    @PostMapping("/add")
    public Event addEvent(@RequestBody Event event) {
        return repo.save(event);
    }


    @GetMapping("/all")
    public List<Event> getAllEvents() {
        return repo.findAll();
    }


    @GetMapping("/{id}")
    public Event getEvent(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event with ID " + id + " not found"));
    }

  
}

