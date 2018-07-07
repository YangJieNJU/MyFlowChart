package yj.YjShape;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import yj.App;

public class ShapeFactory {

    public Rectangle  getRectangle(double x, double y, double w, double h) {
        Rectangle rectangle = new Rectangle(x, y, w, h);
        return addEventHandler(addTheme(rectangle));
    }

    public Line getLine(double x1, double y1, double x2, double y2) {
        Line line = new Line(x1, y1, x2, y2);
        return addEventHandler(addTheme(line));
    }

    public Circle getCircle(double x, double y, double r) {
        Circle circle = new Circle(x, y, r);
        return addEventHandler(addTheme(circle));
    }

    public Text getText(double x, double y, String textContent) {
        Text text = new Text(10,20,textContent);
        return addEventHandler(addTheme(text));
    }

    public Ellipse getEllipse(double centerX,double centerY,double radiusX,double radiusY) {
//        Text text = new Text(10,20,textContent);
        Ellipse ellipse = new Ellipse(centerX,centerY,radiusX,radiusY);
        return addEventHandler(addTheme(ellipse));
    }

    private <T extends Shape> T addTheme(T shape) {
        shape.setFill(new Color(0, 0, 0, 0));
        shape.setStroke(Color.BLACK);
        shape.setStrokeWidth(1);
        return shape;
    }

    private <T extends Shape> T addEventHandler(T shape) {
        EventHandler<MouseEvent> onMousePressedAndDragged = new EventHandler<MouseEvent>() {

            double lastX, lastY;

            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    lastX = mouseEvent.getSceneX();
                    lastY = mouseEvent.getSceneY();
                    App.getInstance().setSelectedShape(shape);

                }
                else if (mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                    shape.setLayoutX(shape.getLayoutX() + mouseEvent.getSceneX() - lastX);
                    shape.setLayoutY(shape.getLayoutY() + mouseEvent.getSceneY() - lastY);
                    lastX = mouseEvent.getSceneX();
                    lastY = mouseEvent.getSceneY();
//                    App.getInstance().setSelectedShape(shape);
                }
            }
        };
        shape.setOnMousePressed(onMousePressedAndDragged);
        shape.setOnMouseDragged(onMousePressedAndDragged);
        return shape;
    }
}
