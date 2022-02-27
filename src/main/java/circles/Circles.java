package circles;

import java.util.stream.Stream;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 * A class to introduce Java 8 lambdas and streams.
 * @author Your name here
 */
public class Circles extends VBox {
    
    public static final int ROWS = 4;
    public static final int COLS = 5;
    public static final int CELL_SIZE = 100;
    private int row = ROWS-1;
    private int col = COLS-1;

    public Circles() {
        setAlignment(Pos.CENTER);
        
        canvas = new Pane();
        canvas.setPrefSize(COLS * CELL_SIZE, ROWS * CELL_SIZE);
        
        starter = new Button("Circles");
        
        getChildren().addAll(canvas, starter);
        
        addButtonHandler();  
    }
    
    private void addToCanvas(Circle newCircle) {
        double toX = (CELL_SIZE/col)*2;
        double toY = (CELL_SIZE/row)*2;
        newCircle.setCenterX(CELL_SIZE*col);
        newCircle.setCenterY(CELL_SIZE*row);
        canvas.getChildren().add(newCircle);
    }
    
    /**
     * This method adds the handler to the button that gives
     * this application its behavior.
     */
    private void addButtonHandler() {
        starter.setOnAction(e -> addToCanvas(new Circle(CELL_SIZE/4)));
    }
    
    private Pane canvas;
    private Button starter;
}
