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
}
