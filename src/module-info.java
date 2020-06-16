module Covid19VisualizingProject {
    requires javafx.fxml;
    requires javafx.controls;

    opens Project;
    //opens Project.Visual;
    opens Project.Visual.Base;
    opens Project.Visual.Graphs;
    //opens Project.Controller;

}