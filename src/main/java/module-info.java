module org.example.mazeproject_csc311 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.mazeproject_csc311 to javafx.fxml;
    exports org.example.mazeproject_csc311;
}