package cl.codingdojo.bootcampestudiantes.models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plan_modulo")
public class PlanModulo implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_plan_formativo")
    private PlanFormativo planformativo;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_modulo")
    private Modulo modulo;

}
