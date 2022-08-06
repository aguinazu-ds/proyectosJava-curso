package cl.ejerciciojava.eventos.repositories;

import org.springframework.data.repository.CrudRepository;

import cl.ejerciciojava.eventos.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
