package cl.codingdojo.bootcampestudiantes.models;

import lombok.Data;

@Data
public class FiltroRegionCurso {
    private Integer codigo_region;
    private String codigo_curso;

    public FiltroRegionCurso(Integer codigo_region, String codigo_curso) {
        this.codigo_region = codigo_region;
        this.codigo_curso = codigo_curso;
    }

    public Integer getCodigo_region() {
        return this.codigo_region;
    }

    public void setCodigo_region(Integer codigo_region) {
        this.codigo_region = codigo_region;
    }

    public String getCodigo_curso() {
        return this.codigo_curso;
    }

    public void setCodigo_curso(String codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

}
