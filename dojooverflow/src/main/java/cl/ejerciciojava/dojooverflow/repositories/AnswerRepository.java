package cl.ejerciciojava.dojooverflow.repositories;

import cl.ejerciciojava.dojooverflow.models.Answer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

}