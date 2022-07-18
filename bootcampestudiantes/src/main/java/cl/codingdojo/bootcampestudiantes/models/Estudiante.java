package cl.codingdojo.bootcampestudiantes.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante implements Comparable<Estudiante> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estudiante;
    @Column(length = 15)
    private String rut;
    @Column(length = 30)
    private String nombre;
    @Column(length = 30)
    private String apellido_pat;
    @Column(length = 30)
    private String apellido_mat;
    @Column(length = 100)
    @JsonIgnore
    private String direccion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_curso")
    @JsonIgnore
    private Curso curso;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_comuna")
    @JsonIgnore
    private Comuna comuna;

    public Estudiante() {
    }

    public Estudiante(String rut, String nombre, String apellido_pat, String apellido_mat, String direccion,
            Curso curso, Comuna comuna) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido_pat = apellido_pat;
        this.apellido_mat = apellido_mat;
        this.direccion = direccion;
        this.curso = curso;
        this.comuna = comuna;
    }

    @Override
    public int compareTo(Estudiante e) {
        return this.getId_estudiante().compareTo(e.getId_estudiante());
    }

}
