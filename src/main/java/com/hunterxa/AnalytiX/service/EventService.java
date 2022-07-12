package com.hunterxa.AnalytiX.service;

import com.hunterxa.AnalytiX.entity.Event;
import com.hunterxa.AnalytiX.repository.EventRepository;
import com.hunterxa.AnalytiX.entity.User;
import com.hunterxa.AnalytiX.repository.UserRepository;
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



}
