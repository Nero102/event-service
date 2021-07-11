package cuttingsheeps.agendaservice.controller;

import com.common.exception.BadRequestException;
import com.common.exception.NotFoundException;
import cuttingsheeps.agendaservice.mapper.UpdatedEventDtoMapper;
import cuttingsheeps.agendaservice.service.EventService;
import model.Event;
import model.UpdatedEventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService service = new EventService();

    @Autowired
    private UpdatedEventDtoMapper mapper = new UpdatedEventDtoMapper();

    @GetMapping("/{id}")
    public ResponseEntity<Event> findById(@PathVariable Long id) throws NotFoundException {
        if (service.findById(id).isEmpty()) {
            throw new NotFoundException(String.format("Member with ID %s does not exist", id));
        } else {
            Event event = service.findById(id).get();
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(event.getId())
                    .toUri();

            return ResponseEntity.ok(event);
        }
    }

    @GetMapping
    public ResponseEntity<List<Event>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdMember = service.saveMember(event);

        if (createdMember == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdMember.getId())
                    .toUri();

            return ResponseEntity.created(uri).body(createdMember);
        }
    }

    @PutMapping("/{id}")
    public Event updateEvent(@RequestParam Long id, @RequestBody UpdatedEventDto event) throws NotFoundException {
        if (event == null || id == null) {
            throw new BadRequestException("Member or ID must not be null");
        }
        Optional<Event> memberOptional = service.findById(id);
        if (memberOptional.isEmpty()) {
            throw new NotFoundException("Member with ID " + id + " does not exist.");
        }
        Event updatedEvent = mapper.map(event);

        return service.saveMember(updatedEvent);
    }

    @DeleteMapping
    public ResponseEntity deleteEventById(@RequestParam Long id) {
        service.deleteMember(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

