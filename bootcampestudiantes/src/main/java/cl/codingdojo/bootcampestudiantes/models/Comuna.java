package cl.codingdojo.bootcampestudiantes.models;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "comuna")
public class Comuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo_comuna;
    @Column(length = 30)
    private String nombre;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_region")
    private Region region;
    @OneToMany(mappedBy = "comuna", fetch = FetchType.LAZY)
    private List<Estudiante> estudiantes;
    @OneToMany(mappedBy = "comuna", fetch = FetchType.LAZY)
    private List<Tutor> tutores;
    @OneToMany(mappedBy = "comuna", fetch = FetchType.LAZY)
    private List<Curso> cursos;

    public Comuna() {
    }

    public Comuna(String nombre, Region region, List<Estudiante> estudiantes, List<Tutor> tutores, List<Curso> cursos) {
        this.nombre = nombre;
        this.region = region;
        this.estudiantes = estudiantes;
        this.tutores = tutores;
        this.cursos = cursos;
    }

}
