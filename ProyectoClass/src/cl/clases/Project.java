package cl.clases;

public class Project {
    public String nombre;
    public String descripcion;
    public Double initialCost;

    public Project() {
    }

    public Project(String nombre) {
        this.nombre = nombre;
    }

    public Project(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Project(String nombre, String descripcion, Double initialCost) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.initialCost = initialCost;
    }

    public void elevatorPitch() {
        System.out.println(this.nombre +"(" + this.initialCost + ")" + ": " + this.descripcion);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getInitialCost() {
        return this.initialCost;
    }

    public void setInitialCost(Double initialCost) {
        this.initialCost = initialCost;
    }
}
