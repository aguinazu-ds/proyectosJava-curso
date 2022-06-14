import java.util.ArrayList;

import cl.clases.Portfolio;
import cl.clases.Project;

public  class ProjectTest {
    public static void main(String[] args) throws Exception {
        Project test1 = new Project();
        test1.setNombre("Proyecto 1");
        test1.setDescripcion("Descripción proyecto 1");
        test1.setInitialCost(125.0);
        
        Project test2 = new Project("Proyecto 2", "Descripción Proyecto 2", 98.0);
        Project test3 = new Project("Proyecto 3", "Descripción Proyecto 3", 109.0);
        Project test4 = new Project("Proyecto 4", "Descripción Proyecto 4", 2000.0);
        Project test5 = new Project("Proyecto 5", "Descripción Proyecto 5", 20.0);

        // test1.elevatorPitch();
        // test2.elevatorPitch();
        // test3.elevatorPitch();
        // test4.elevatorPitch();
        // test5.elevatorPitch();

        Portfolio portafolioTest1 = new Portfolio();
        ArrayList<Project> lista_project = new ArrayList<Project>();
        portafolioTest1.setProjects(lista_project);
        portafolioTest1.agregarProyecto(test1);
        portafolioTest1.agregarProyecto(test3);
        portafolioTest1.showPortfolio();
        System.out.println(portafolioTest1.getPortfolioCost());


    }
}
