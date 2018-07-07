package yj;

import javafx.scene.shape.Shape;

public class App {
    private static App ourInstance = new App();

    public static App getInstance() {
        return ourInstance;
    }

    private App() {
    }

    private Shape selectedShape;

    public void setSelectedShape(Shape shape) {
        selectedShape = shape;
    }

    public Shape getSelectedShape() {
        return selectedShape;
    }
}
