package com.hunterxa.AnalytiX.event;

import com.hunterxa.AnalytiX.organization.Organization;
import com.hunterxa.AnalytiX.organization.OrganizationRepository;
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
    @Autowired
    private OrganizationRepository organizationRepository;

    public void addNewEvent(Event event) {
        Optional<User> user = userRepository.findByEmail(event.getCreator().getEmail());
        if (user.isEmpty()) throw new IllegalStateException("no user found with that email");

        Optional<Organization> organization = organizationRepository.findByName(event.getOrganization().getName());
        if (organization.isEmpty()) throw new IllegalStateException("no organization found with that name");

        event.setCreator(user.get());
        event.setOrganization(organization.get());
        eventRepository.save(event);
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public List<Event> getEventsByUser(User user) {
        return eventRepository.findByCreatorId(user.getId());
    }



}
