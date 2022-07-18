package cl.codingdojo.bootcampestudiantes.models;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_region")
    private Integer id;
    @Column(length = 30)
    private String nombre;
    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
    private List<Comuna> comunas;

    public Region() {
    }

    public Region(String nombre, List<Comuna> comunas) {
        this.nombre = nombre;
        this.comunas = comunas;
    }

}
