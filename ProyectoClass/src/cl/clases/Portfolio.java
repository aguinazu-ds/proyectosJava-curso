package cl.clases;

import java.util.ArrayList;

public class Portfolio {
    public ArrayList<Project> projects = new ArrayList<Project>();

    public Portfolio() {
    }

    public Portfolio(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public void agregarProyecto(Project proyecto) {
        this.projects.add(proyecto);
    }

    public Double getPortfolioCost() {
        Double costo_portafolio = 0.0;
        for (Project project : this.projects) {
            costo_portafolio = costo_portafolio + project.getInitialCost();
        }
        return costo_portafolio;
    }

    public void showPortfolio() {
        for (Project project : this.projects) {
            project.elevatorPitch();
        }
    }

    public ArrayList<Project> getProjects() {
        return this.projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "{" +
            " projects='" + getProjects() + "'" +
            "}";
    }
    
}
