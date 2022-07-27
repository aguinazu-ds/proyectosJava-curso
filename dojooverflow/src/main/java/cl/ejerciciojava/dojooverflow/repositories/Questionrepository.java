package cl.ejerciciojava.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.ejerciciojava.dojooverflow.models.Question;

@Repository
public interface Questionrepository extends CrudRepository<Question, Long> {
    List<Question> findAll();

    Question findQuestionById(Long id);
}
