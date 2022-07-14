package com.hunterxa.AnalytiX.event;

import com.hunterxa.AnalytiX.user.User;
import com.hunterxa.AnalytiX.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;


    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public void addNewEvent(Event event) {
        Optional<User> user = userRepository.findByEmail(event.getCreator().getEmail());
        user.ifPresent(event::setCreator);
        eventRepository.save(event);
    }

    public List<Event> getEventsByUser(User user) {
        return eventRepository.findByCreatorId(user.getId());
    }



}
