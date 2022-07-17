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
@Table(name = "modulo")
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo_modulo;
    @Column(length = 100)
    private String descripcion;
    private Integer duracion_horas;
    @OneToMany(mappedBy = "modulo", fetch = FetchType.LAZY)
    private List<PlanModulo> planesModulos;
    @OneToMany(mappedBy = "modulo", fetch = FetchType.LAZY)
    private List<CursoModuloTutor> cursosModulosTutores;
}
