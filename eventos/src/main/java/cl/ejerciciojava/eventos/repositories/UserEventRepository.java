package cl.ejerciciojava.eventos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cl.ejerciciojava.eventos.models.Event;
import cl.ejerciciojava.eventos.models.User;
import cl.ejerciciojava.eventos.models.UserEvent;

public interface UserEventRepository extends CrudRepository<UserEvent, Long> {
    List<UserEvent> findByEventContains(Event event);

    UserEvent findByEventAndUser(Event event, User user);
}
