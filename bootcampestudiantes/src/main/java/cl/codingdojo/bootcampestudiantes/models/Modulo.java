package cl.codingdojo.bootcampestudiantes.models;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
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

    public Modulo() {
    }

    public Modulo(String descripcion, Integer duracion_horas, List<PlanModulo> planesModulos,
            List<CursoModuloTutor> cursosModulosTutores) {
        this.descripcion = descripcion;
        this.duracion_horas = duracion_horas;
        this.planesModulos = planesModulos;
        this.cursosModulosTutores = cursosModulosTutores;
    }

}
