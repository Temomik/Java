package sample;
import javafx.scene.control.TextField;

import java.awt.*;

public class Calculate {
    private double normal;

    public double calculateNormal(double x, double y){
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    public double calculatePlane(TextField _x, TextField __x){
        return Math.abs(Double.parseDouble(_x.getText())-Double.parseDouble(__x.getText()));
    }
}
