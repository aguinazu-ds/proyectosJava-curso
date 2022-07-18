package cl.codingdojo.bootcampestudiantes.models;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
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

    public Tutor() {
    }

    public Tutor(String rut, String nombre, String apellido_pat, String apellido_mat, String direccion, String cargo,
            Comuna comuna, List<CursoModuloTutor> cursosModulosTutores) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido_pat = apellido_pat;
        this.apellido_mat = apellido_mat;
        this.direccion = direccion;
        this.cargo = cargo;
        this.comuna = comuna;
        this.cursosModulosTutores = cursosModulosTutores;
    }

}
