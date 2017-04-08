import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) {

        Slider spiralIndexSlider = new Slider(1, 10000, 1);
        spiralIndexSlider.setShowTickLabels(true); spiralIndexSlider.setShowTickMarks(true);
        spiralIndexSlider.setMajorTickUnit(1000); spiralIndexSlider.setMinorTickCount(3);
        spiralIndexSlider.setBlockIncrement(50); spiralIndexSlider.setMinSize(700,1);

        Slider rangeSlider = new Slider(1, 6, 1);
        rangeSlider.setShowTickLabels(true); rangeSlider.setShowTickMarks(true);
        rangeSlider.setMajorTickUnit(1); rangeSlider.setMinorTickCount(3);
        rangeSlider.setBlockIncrement(0.5); rangeSlider.setMinSize(200,1);

        Label spiralLabel = new Label("Ulam spiral (maximum index)");
        Label statsLabel = new Label("range (10^x)\n\n\n\n\n" +
                "Statistics\nnumber of primes:\nnumber of twin primes:\n" +
                "ratio:\n -------\nTwin Prime Conjecture\npi(n):\nli(n:\nepsilon:");

        GridPane matrix = new GridPane();
        //muss Textfelder beinhalten
        //in denen die Zaheln der Spirale stehen

        Pane pane = new Pane();

        spiralIndexSlider.setLayoutX(100); spiralIndexSlider.setLayoutY(50);
        rangeSlider.setLayoutX(1100); rangeSlider.setLayoutY(50);
        spiralLabel.setLayoutX(100); spiralLabel.setLayoutY(20);
        statsLabel.setLayoutX(1100); statsLabel.setLayoutY(20);

        pane.getChildren().add(spiralLabel); pane.getChildren().add(statsLabel);
        pane.getChildren().add(spiralIndexSlider); pane.getChildren().add(rangeSlider);
        pane.getChildren().add(matrix);

        Scene scene = new Scene(pane, 1400, 800);

        primaryStage.setTitle("Twin Prime Conjecture");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}