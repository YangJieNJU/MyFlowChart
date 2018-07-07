package yj;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import yj.YjShape.ShapeFactory;

import java.util.Optional;

public class PaneController {

    @FXML
    private Button btnRectangle;
    @FXML
    private Button btnLine;
    @FXML
    private Button btnCircle;
    @FXML
    private Button btnText;
    @FXML
    private Button btnCopy;
    @FXML
    private Button btnDelete;
    @FXML
    private Canvas canvas;
    @FXML
    private Group group;

    @FXML
    public void initialize() {
        ShapeFactory shapeFactory = new ShapeFactory();

        btnRectangle.setOnAction(actionEvent -> {
            group.getChildren().add(shapeFactory.getRectangle(0, 0, 100, 70));
        });

        btnLine.setOnAction(actionEvent -> {
            group.getChildren().add(shapeFactory.getLine(0, 50, 100, 50));
        });

        btnCircle.setOnAction(actionEvent -> {
            group.getChildren().add(shapeFactory.getEllipse(50,35,50,35));
        });

        btnText.setOnAction(actionEvent -> {
            TextInputDialog dialog = new TextInputDialog("");
            dialog.setTitle("请输入文字内容");
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()){
                group.getChildren().add(shapeFactory.getText(0,0,result.get()));
            }
        });

        btnCopy.setOnAction(actionEvent -> {
            Shape shape = App.getInstance().getSelectedShape();
            if(shape instanceof Rectangle){
                group.getChildren().add(shapeFactory.getRectangle(0, 0, 100, 70));
            }
            else if(shape instanceof Line){
                group.getChildren().add(shapeFactory.getLine(0, 50, 100, 50));
            }
            else if(shape instanceof Ellipse){
                group.getChildren().add(shapeFactory.getEllipse(50,35,50,35));
            }
            else if(shape instanceof Text){
                group.getChildren().add(shapeFactory.getText(0,0,((Text) shape).getText()));
            }
        });

        btnDelete.setOnAction(actionEvent -> {
            Shape shape = App.getInstance().getSelectedShape();
            group.getChildren().remove(shape);
        });
    }
}
