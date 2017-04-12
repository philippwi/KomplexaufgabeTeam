import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.lang.*;

public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) {

        Slider spiralIndexSlider = new Slider(1, 10000, 1);
        spiralIndexSlider.setShowTickLabels(true);
        spiralIndexSlider.setShowTickMarks(true);
        spiralIndexSlider.setMajorTickUnit(1000);
        spiralIndexSlider.setMinorTickCount(3);
        spiralIndexSlider.setBlockIncrement(50);
        spiralIndexSlider.setMinSize(700, 1);

        Slider rangeSlider = new Slider(1, 6, 1);
        rangeSlider.setShowTickLabels(true);
        rangeSlider.setShowTickMarks(true);
        rangeSlider.setMajorTickUnit(1);
        rangeSlider.setMinorTickCount(0);
        rangeSlider.setBlockIncrement(1);
        rangeSlider.setMinSize(200, 1);

        Label spiralLabel = new Label("Ulam spiral (maximum index)");
        Label statsLabel = new Label("range (10^x)\n\n\n\n\n" +
                "Statistics\n\nnumber of primes:\nnumber of twin primes:\n" +
                "ratio:\n\n -------\n\nTwin Prime Conjecture\n\npi(n):\nli(n:\nepsilon:");
        Label info = new Label("Hinweise:\n" +
                "- Zum Aktualisieren Slider Ziehen und\n  Loslassen\n" +
                "- Ulam-Spirale nach 1296 zu groß für\n  Darstellung im Fenster\n" +
                "  --> Slider am besten im Bereich 1-1000\n        bewegen\n" +
                "- li(n) nicht mathematisch implementiert, da\n  sehr komplexe Berechnung\n" +
                "- In Testing.java können die Algorithmen in\n  der Konsole getestet werden");

        GridPane matrix = new GridPane();

        spiralIndexSlider.setLayoutX(100);
        spiralIndexSlider.setLayoutY(50);
        rangeSlider.setLayoutX(1300);
        rangeSlider.setLayoutY(50);
        spiralLabel.setLayoutX(100);
        spiralLabel.setLayoutY(20);
        statsLabel.setLayoutX(1300);
        statsLabel.setLayoutY(20);
        info.setLayoutX(1300);
        info.setLayoutY(600);
        matrix.setLayoutX(50);
        matrix.setLayoutY(120);

        UlamSpiral ulamSpiral = new UlamSpiral(10000);

        spiralIndexSlider.valueChangingProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {

                matrix.getChildren().clear();

                for(int i=32; i<68; i++) {
                    for (int j = 32; j < 68; j++) {

                        SpiralNumber number = ulamSpiral.spiral[i][j];

                        Label l = new Label();

                        if(number.value < 10) l.setText("  " + ulamSpiral.spiral[i][j].toString() + "  ");
                        else if(number.value < 100) l.setText("  " + ulamSpiral.spiral[i][j].toString() + " ");
                        else if(number.value < 1000) l.setText("  " + ulamSpiral.spiral[i][j].toString());
                        else l.setText(number.toString());

                        if(number.value<=spiralIndexSlider.getValue()){
                                if (number.isPrime) {
                                    if (number.isTwinPrime) l.setStyle("-fx-background-color: #ffa64d;"//orange background
                                            + "-fx-text-fill: #ffffff"); //white text
                                    else l.setStyle("-fx-background-color: #ff3333;"//red background
                                            + "-fx-text-fill: #ffffff"); //white text
                                }
                            }
                        else{
                            if (number.isPrime) {
                                if (number.isTwinPrime) l.setStyle("-fx-background-color: #a6a6a6"); //grey background
                                else l.setStyle("-fx-background-color: #cccccc"); //light grey background
                            }
                            else l.setStyle("-fx-text-fill: #a6a6a6");//grey text
                        }
                        matrix.getChildren().add(l);
                        GridPane.setRowIndex(l,i);
                        GridPane.setColumnIndex(l,j);
                    }
                }
            }});

        rangeSlider.valueChangingProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                Statistics stats = new Statistics((int)Math.pow(10, (int)rangeSlider.getValue()));
                statsLabel.textProperty().setValue("range (10^x)\n\n\n\n\n" +
                        "Statistics\n\nnumber of primes: " + stats.numberOfPrimes +
                        "\nnumber of twin primes: " + stats.numberOfTwinPrimes +
                        "\nratio: " + stats.ratio +
                        "\n\n -------\n\nTwin Prime Conjecture\n\n" +
                        "pi(n): " + stats.pi +
                        "\nli(n: " + stats.li +
                        "\nepsilon: "+  stats.epsilon);
            }});

        Pane pane = new Pane();

        pane.getChildren().add(spiralLabel);
        pane.getChildren().add(statsLabel);
        pane.getChildren().add(info);
        pane.getChildren().add(spiralIndexSlider);
        pane.getChildren().add(rangeSlider);
        pane.getChildren().add(matrix);

        Scene scene = new Scene(pane, 1600, 900);

        primaryStage.setTitle("Twin Prime Conjecture");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}