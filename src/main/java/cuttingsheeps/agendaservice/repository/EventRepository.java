package cuttingsheeps.agendaservice.repository;

import model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

        @Override
        List<Event> findAll();

        @Override
        void deleteAll();

        @Override
        Optional<Event> findById(Long id);

        @Override
        void deleteById(Long id);

        @Override
        Event save(Event member);

    }

