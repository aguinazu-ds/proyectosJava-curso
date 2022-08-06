package cl.ejerciciojava.eventos.repositories;

import org.springframework.data.repository.CrudRepository;

import cl.ejerciciojava.eventos.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
