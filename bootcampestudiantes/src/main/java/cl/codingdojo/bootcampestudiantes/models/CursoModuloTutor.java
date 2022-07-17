package cl.codingdojo.bootcampestudiantes.models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
