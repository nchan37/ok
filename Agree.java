//Agree counter

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.media.AudioClip;

public class Agree extends Application {

    private Button agreeB;
    private VBox vbox;
    private BorderPane pane;
    private BorderPane centPane;
    private int agrees;
    private Label moneyLabel;
    private Image prof;
    private ImageView iV;
    private AudioClip agre;
    public void start(Stage primaryStage) {
        prof = new Image("Prof.jpg");
        agre = new AudioClip(getClass().getResource("agree.mp3" + "").toExternalForm());
        iV = new ImageView(prof);
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(25, 25, 25, 25));
        vbox.setAlignment(Pos.TOP_RIGHT);
        moneyLabel = new Label("We've agreed: " + agrees + " times!");
        moneyLabel.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
        vbox.getChildren().addAll(moneyLabel);
        agreeB = new Button("AGREE?");
        agreeB.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 80));
        agreeB.setPadding(new Insets(20, 100, 20, 100));
        agreeB.setAlignment(Pos.CENTER);
        agreeB.setOnAction(e -> count());
        agreeB.setOnMouseEntered(e -> lol());
        agreeB.setOnMouseExited(e -> revert());
        centPane = new BorderPane(agreeB);
        pane = new BorderPane(centPane);
        pane.setTop(vbox);
        Scene scene = new Scene(pane, 650, 450);
        primaryStage.setTitle("AGREE"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void count() {
        agrees++;
        moneyLabel.setText("We've agreed: " + agrees + " times!");
        agre.play(3);
    }
    private void lol() {
        agreeB.setGraphic(iV);
        agreeB.setText("");
    }
    private void revert() {
        agreeB.setText("AGREE?");
        agreeB.setGraphic(null);
    }
}