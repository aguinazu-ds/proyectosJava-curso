package cl.codingdojo.bootcampestudiantes.models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "curso_modulo_tutor")
public class CursoModuloTutor implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_curso")
    private Curso curso;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_modulo")
    private Modulo modulo;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_tutor")
    private Tutor tutor;

    public CursoModuloTutor() {
    }

    public CursoModuloTutor(Curso curso, Modulo modulo, Tutor tutor) {
        this.curso = curso;
        this.modulo = modulo;
        this.tutor = tutor;
    }

}
