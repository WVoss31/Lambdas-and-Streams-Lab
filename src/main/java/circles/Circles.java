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
    private int row;
    private int col;

    public Circles() {
        setAlignment(Pos.CENTER);
        
        canvas = new Pane();
        canvas.setPrefSize(COLS * CELL_SIZE, ROWS * CELL_SIZE);
        
        starter = new Button("Circles");
        
        getChildren().addAll(canvas, starter);
        
        addButtonHandler();  
        
        makeAllRows().forEach(r -> r.forEach(x -> System.out.println(x)));
    }
    
    private void addToCanvas(Circle newCircle) {
        double toX = (col * CELL_SIZE) + (CELL_SIZE / 2);
        double toY = (row * CELL_SIZE) + (CELL_SIZE / 2);
        newCircle.setCenterX(toX);
        newCircle.setCenterY(toY);
        newCircle.setFill(new Color(Math.random(), Math.random(), Math.random(), 1.0));
        canvas.getChildren().add(newCircle);
    }
    
    /**
     * This method adds the handler to the button that gives
     * this application its behavior.
     */
    private void addButtonHandler() {
        starter.setOnAction(e -> addAllRowsToCanvas(makeAllRows()));
    }
    
    private Stream<Circle> makeRow() {
        return Stream.generate(() -> new Circle(CELL_SIZE/4)).limit(COLS);
    }
    
    private void addRowToCanvas(Stream<Circle> stream) {
        col = 0;
        stream.forEach(c -> {addToCanvas(c);
                            col++;} );
    }
    
    private Stream<Stream<Circle>> makeAllRows() {
        return Stream.generate(() -> makeRow()).limit(ROWS);
    }
    
    private void addAllRowsToCanvas(Stream<Stream<Circle>> grid) {
        row = 0;
        grid.forEach(r -> {addRowToCanvas(r); row++;} );
    }
    
    private Pane canvas;
    private Button starter;
}
