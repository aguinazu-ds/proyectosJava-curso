package cl.codingdojo.bootcampestudiantes.models;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plan_formativo")
public class PlanFormativo {
    @Id
    @Column(length = 30)
    private String codigo_plan_formativo;
    @Column(length = 30)
    private String descripcion;
    private Integer duracion_horas;
    @OneToMany(mappedBy = "planformativo", fetch = FetchType.LAZY)
    private List<Curso> cursos;
    @OneToMany(mappedBy = "planformativo", fetch = FetchType.LAZY)
    private List<PlanModulo> planesModulos;
}
