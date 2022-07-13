package com.hunterxa.AnalytiX.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/event")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @PostMapping
    public void addNewEvent(@RequestBody Event event) {
        System.out.println(event.getCreator().toString());
        eventService.addNewEvent(event);
    }
}
