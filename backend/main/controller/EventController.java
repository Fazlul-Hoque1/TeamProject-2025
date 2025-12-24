package com.eventorganizer.event_org.controller;

import com.eventorganizer.event_org.model.App_User;
import com.eventorganizer.event_org.model.Event;
import com.eventorganizer.event_org.repository.EventRepository;
import com.eventorganizer.event_org.repository.UserRepository;
import com.eventorganizer.event_org.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin("*")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;



    @PostMapping("/add")
    public Event addEvent(@RequestBody Event event) {

        String username  = SecurityContextHolder.getContext().getAuthentication().getName();

        App_User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        event.setCreatedBy(user.getUsername());

        return eventRepository.save(event);
    }



    @PostMapping("/join/{id}")
    public Event joinEvent(@PathVariable Long id) {

        String username  = SecurityContextHolder.getContext().getAuthentication().getName();
        App_User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Event event = eventRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Event not found"));

        if(event.getJoinedBy()== null){
            event.setJoinedBy(new ArrayList<>());
        }

        if (!event.getJoinedBy().contains(user.getUsername())){
            event.getJoinedBy().add(user.getUsername());
            eventRepository.save(event);

        }

        return eventRepository.save(event);
    }




    @GetMapping("/all")
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }


    @GetMapping("/{id}")
    public Event getEvent(@PathVariable Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event with ID " + id + " not found"));
    }

    // UPDATE (PUT)
    @PutMapping("/update/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event newEvent) {
        Event existing = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event with ID " + id + " not found"));

        existing.setTitle(newEvent.getTitle());
        existing.setLocation(newEvent.getLocation());
        existing.setDate(newEvent.getDate());
        existing.setDescription(newEvent.getDescription());

        return eventRepository.save(existing);
    }

    // PARTIAL UPDATE (PATCH)-> IT ONLY WORKS IN LOCAL HOST NOT ON "CLOUD PLATFORM"
    @PatchMapping("/update-partial/{id}")
    public Event updatePartial(@PathVariable Long id, @RequestBody Event eventData) {
        Event existing = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        if (eventData.getTitle() != null)
            existing.setTitle(eventData.getTitle());

        if (eventData.getDate() != null)
            existing.setDate(eventData.getDate());

        if (eventData.getLocation() != null)
            existing.setLocation(eventData.getLocation());

        if (eventData.getDescription() != null)
            existing.setDescription(eventData.getDescription());

        return eventRepository.save(existing);
    }

    // DELETE
//    @DeleteMapping("/delete/{id}")
//    public String deleteEvent(@PathVariable Long id) {
//        if (!eventRepository.existsById(id)) {
//            throw new IllegalArgumentException("Event with ID " + id + " not found");
//        }
//
//        eventRepository.deleteById(id);
//        return "Event deleted successfully.";
//    }

    @DeleteMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().iterator().next().getAuthority();

        Event event = eventRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("event not found"));

        if(role.equals("ROLE_ADMIN")){
            eventRepository.delete(event);
            return "Event deleted Successfully by Admin";
        }

        if(!event.getCreatedBy().equals(username)){
            throw new IllegalArgumentException("You are not allowed to delete this event");
        }


        eventRepository.delete(event);
        return "Event deleted.";
    }
}
