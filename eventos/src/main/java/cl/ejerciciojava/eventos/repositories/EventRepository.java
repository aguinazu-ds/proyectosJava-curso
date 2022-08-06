package cl.ejerciciojava.eventos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cl.ejerciciojava.eventos.models.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findByRegionContains(String region);

    List<Event> findByRegionNotContains(String region);
}
