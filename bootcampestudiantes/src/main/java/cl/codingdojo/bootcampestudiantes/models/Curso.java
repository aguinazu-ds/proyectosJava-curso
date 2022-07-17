package cl.codingdojo.bootcampestudiantes.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "curso")
public class Curso {
    @Id
    @Column(length = 30)
    private String codigo_curso;
    private Date fecha_inicio;
    private Date fecha_termino;
    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List<Estudiante> estudiantes;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_comuna")
    private Comuna comuna;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_plan_formativo")
    private PlanFormativo planformativo;
    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List<CursoModuloTutor> cursosModulosTutores;
}
