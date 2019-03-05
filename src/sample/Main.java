package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.Label;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField firstXField = new TextField();
        TextField secondXField = new TextField();
        TextField firstYField = new TextField();
        TextField secondYField = new TextField();
        Label normalLable = new Label("Норма ");
        Label xPlaneLable = new Label("Проекция на x");
        Label yPlaneLable = new Label("Проекция на y");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(normalLable, 3, 0);
        grid.add(xPlaneLable, 3, 1);
        grid.add(yPlaneLable, 3, 2);
        grid.add(new Label("x1 "), 0, 0);
        grid.add(new Label("y1 "), 0, 1);
        grid.add(new Label("x2 "), 0, 2);
        grid.add(new Label("y2 "), 0, 3);
        grid.add(firstXField, 1, 0);
        grid.add(firstYField, 1, 1);
        grid.add(secondXField, 1, 2);
        grid.add(secondYField, 1, 3);
        grid.setHgap(20);
        grid.setVgap(10);

        Button btn = new Button();
        btn.setText("Посчитать");
        Group root = new Group();

        grid.add(btn, 3, 3);

        Calculate calculate = new Calculate();

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double x, y;
                x = calculate.calculatePlane(firstXField, secondXField);
                y = calculate.calculatePlane(firstYField, secondYField);
                normalLable.setText("Норма " + (int) calculate.calculateNormal(x, y));
                xPlaneLable.setText("Проекция на х " + (int) x);
                yPlaneLable.setText("Проекция на у " + (int) y);
            }
        });


        primaryStage.setTitle("Convertor");
        root.getChildren().add(grid);
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
