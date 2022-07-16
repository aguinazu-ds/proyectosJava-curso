package cl.ejerciciojava.dojooverflow.repositories;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.data.repository.CrudRepository;

public interface Questionrepository extends CrudRepository<Question, Long> {

}
