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
@Table(name = "tutor")
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_tutor;
    @Column(length = 15)
    private String rut;
    @Column(length = 30)
    private String nombre;
    @Column(length = 30)
    private String apellido_pat;
    @Column(length = 30)
    private String apellido_mat;
    @Column(length = 100)
    private String direccion;
    @Column(length = 20)
    private String cargo;
    // private Integer sueldo_hora;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_comuna")
    private Comuna comuna;
    @OneToMany(mappedBy = "tutor", fetch = FetchType.LAZY)
    private List<CursoModuloTutor> cursosModulosTutores;
}
