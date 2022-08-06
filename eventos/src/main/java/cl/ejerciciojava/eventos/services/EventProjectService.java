package cl.ejerciciojava.eventos.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import cl.ejerciciojava.eventos.models.Comment;
import cl.ejerciciojava.eventos.models.Event;
import cl.ejerciciojava.eventos.models.User;
import cl.ejerciciojava.eventos.models.UserEvent;
import cl.ejerciciojava.eventos.repositories.CommentRepository;
import cl.ejerciciojava.eventos.repositories.EventRepository;
import cl.ejerciciojava.eventos.repositories.UserEventRepository;
import cl.ejerciciojava.eventos.repositories.UserRepository;

@Service
public class EventProjectService {
    private final CommentRepository commentRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final UserEventRepository userEventRepository;

    public EventProjectService(CommentRepository commentRepository, EventRepository eventRepository,
            UserRepository userRepository, UserEventRepository userEventRepository) {
        this.commentRepository = commentRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.userEventRepository = userEventRepository;
    }

    public User registerUser(User user) {
        String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hash);
        return userRepository.save(user);
    }

    public Boolean checkLogin(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return false;
        }
        if (BCrypt.checkpw(password, user.getPassword())) {
            return true;
        }
        return false;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public Event createEvent(Event event, Long id) {
        event.setUser(getUserById(id));
        return eventRepository.save(event);
    }

    public List<Event> sameRegionEvents(String region) {
        return eventRepository.findByRegionContains(region);
    }

    public List<Event> outSideRegionEvents(String region) {
        return eventRepository.findByRegionNotContains(region);
    }

    public Event eventById(Long id) {
        if (eventRepository.findById(id) != null) {
            return eventRepository.findById(id).get();
        }
        return null;
    }

    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }

    public void updateEvent(Event event) {
        eventRepository.save(event);

    }

    public UserEvent userJoinEvent(UserEvent join) {
        return userEventRepository.save(join);
    }

    public Iterable<UserEvent> joinedEvents() {
        return userEventRepository.findAll();
    }

    public void cancelJoin(UserEvent userEvent) {
        userEventRepository.delete(userEvent);
    }

    public UserEvent findJoinedEvent(Event event, User user) {
        return userEventRepository.findByEventAndUser(event, user);
    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
