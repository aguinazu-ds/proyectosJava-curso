package cl.ejerciciojava.adminpanel.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.ejerciciojava.adminpanel.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findAll();

    List<Role> findByName(String name);
}
