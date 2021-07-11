package cuttingsheeps.agendaservice.service;

import cuttingsheeps.agendaservice.repository.EventRepository;
import model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    public Event saveMember(Event member) {
        return eventRepository.save(member);
    }

    public void deleteMember(Long id) {
        eventRepository.deleteById(id);
    }
}

