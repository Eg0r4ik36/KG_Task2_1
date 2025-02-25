module ru.vsu.cs.kg_task2_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.vsu.cs.kg_task2_1 to javafx.fxml;
    exports ru.vsu.cs.kg_task2_1;
}