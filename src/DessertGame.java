import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.geometry.Pos;
import java.util.Random;

public class DessertGame extends Application {

    private int score = 0;

    @Override
    public void start(final Stage stage) {
        // Step 3 & 4
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 640, 480);
        stage.setTitle("Dessert in the Desert JavaFX Game");
        
        // Step 5
        Label scoreLabel = new Label("Score: " + score);
        borderPane.setTop(scoreLabel);
        BorderPane.setAlignment(scoreLabel, Pos.TOP_LEFT);

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> {
            Platform.exit();
        });
        borderPane.setBottom(exitButton);
        BorderPane.setAlignment(exitButton, Pos.BOTTOM_RIGHT);
        
        // Step 6
        Pane pane = new Pane();
        borderPane.setCenter(pane);
        BorderPane.setAlignment(pane, Pos.CENTER);

        // TODO: Step 7-10

        Random generator = new Random();

        Button[] buttons = new Button[]{
            new Button("Dessert"),
            new Button("Desert"),
            new Button("Desert"),
            new Button("Desert"),
            new Button("Desert"),
            new Button("Desert"),
            new Button("Desert"),
            new Button("Desert")
        };

        pane.getChildren().add(buttons[0]);
        buttons[0].setOnAction((event -> {
            exitButton.requestFocus();
            score++;
            borderPane.setTop(new Label("Score: " + score));
            randomizeButtonPositions(generator, buttons);
        }));

        for (int i = 1; i < buttons.length; i++) {
            pane.getChildren().add(buttons[i]);
            buttons[i].setOnAction((event -> {
                exitButton.requestFocus();
                score--;
                borderPane.setTop(new Label("Score: " + score));
                randomizeButtonPositions(generator, buttons);
            }));
        }

        stage.setScene(scene);
        stage.show();
        randomizeButtonPositions(generator, buttons);
        exitButton.requestFocus();
    }

    private void randomizeButtonPositions(Random generator, Button[] buttons) {
        int randomX;
        int randomY;
        for (Button button : buttons) {
            randomX = generator.nextInt(600);
            randomY = generator.nextInt(400);
            button.setLayoutX(randomX);
            button.setLayoutY(randomY);
        }
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
