package cl.ejerciciojava.paneladmin.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import cl.ejerciciojava.paneladmin.models.User;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByEmail(String email);

    Optional<User> findById(Long id);
}
