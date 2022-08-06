package cl.ejerciciojava.paneladmin.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cl.ejerciciojava.paneladmin.models.Role;

public interface RoleRepo extends CrudRepository<Role, Long> {
    List<Role> findByName(String name);
}
