package cl.ejerciciojava.dojooverflow.repositories;

import cl.ejerciciojava.dojooverflow.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

}
