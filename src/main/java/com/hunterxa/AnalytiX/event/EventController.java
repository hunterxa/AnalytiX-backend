package com.hunterxa.AnalytiX.event;

import com.hunterxa.AnalytiX.user.User;
import com.hunterxa.AnalytiX.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/event")
public class EventController {
    private final EventService eventService;
    private final UserService userService;

    @Autowired
    public EventController(EventService eventService, UserService userService) {

        this.eventService = eventService;
        this.userService = userService;
    }

    @PostMapping
    public void addNewEvent(@RequestBody Event event) {
        eventService.addNewEvent(event);
    }

    @GetMapping
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @GetMapping(path = "/username/{username}")
    public List<Event> getEventsByUserId(@PathVariable("username") String username) {
        List<Event> events;
        Optional<User> user = userService.getUserByUsername(username);
        if (user.isPresent()) {
            events = eventService.getEventsByUser(user.get());
        } else {
            throw new IllegalStateException("no user found by that username");
        }

        return events;
    }
}
