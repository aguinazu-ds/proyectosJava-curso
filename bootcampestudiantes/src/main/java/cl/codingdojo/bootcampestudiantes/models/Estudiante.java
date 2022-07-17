package cl.codingdojo.bootcampestudiantes.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estudiante")
public class Estudiante {
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

}
