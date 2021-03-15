import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.Random;

public class Code extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    int speed = 30;

    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(500, 600, 50, Color.BLUE);
        Circle circle2 = new Circle(700, 600, 50, Color.RED);
        Circle circle3 = new Circle(500, 800, 50, Color.GREEN);
        Group root = new Group(circle, circle2, circle3);
        Scene scene = new Scene(root, 1500, 1000);
        primaryStage.setScene(scene);


        Thread thread = new Thread(() -> {
            scene.setOnKeyPressed(event -> {
                KeyCode keyCode = event.getCode();
                switch (keyCode) {
                    case W:
                        circle.setCenterY(circle.getCenterY() - speed);
                        break;
                    case S:
                        circle.setCenterY(circle.getCenterY() + speed);
                        break;
                    case D:
                        circle.setCenterX(circle.getCenterX() + speed);
                        break;
                    case A:
                        circle.setCenterX(circle.getCenterX() - speed);
                        break;
                }

            });
        });


        Thread thread1 = new Thread(() -> {
            scene.setOnKeyPressed(event -> {
                KeyCode keyCode = event.getCode();
                switch (keyCode) {
                    case UP:
                        circle2.setCenterY(circle2.getCenterY() - speed);
                        break;
                    case DOWN:
                        circle2.setCenterY(circle2.getCenterY() + speed);
                        break;
                    case RIGHT:
                        circle2.setCenterX(circle2.getCenterX() + speed);
                        break;
                    case LEFT:
                        circle2.setCenterX(circle2.getCenterX() - speed);
                        break;
                }

            });
        });
        scene.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            switch (keyCode) {
                case UP:
                    circle2.setCenterY(circle2.getCenterY() - speed);
                    break;
                case DOWN:
                    circle2.setCenterY(circle2.getCenterY() + speed);
                    break;
                case RIGHT:
                    circle2.setCenterX(circle2.getCenterX() + speed);
                    break;
                case LEFT:
                    circle2.setCenterX(circle2.getCenterX() - speed);
                    break;
                case SPACE:
                    JOptionPane.showMessageDialog(new JFrame(), "); You hit the space bar", "Information", 0);
                    break;
                case CAPS:
                    JOptionPane.showMessageDialog(new JFrame(), "); You pressed Caps Lock", "Information", 0);
                    break;
                case ENTER:
                    JOptionPane.showMessageDialog(new JFrame(), "); You pressed ENTER", "Information", 0);
                    break;
            }
        });

        circle.setOnMouseClicked(event -> {
            Random randomR = new Random();
            Random randomG = new Random();
            Random randomB = new Random();

            int r = randomR.nextInt(255);
            int g = randomG.nextInt(255);
            int b = randomB.nextInt(255);

            circle.setFill(Color.rgb(r, g, b));
            speed += 10;
        });

        scene.setOnMouseMoved(event -> {
            circle3.setCenterX(event.getX());
            circle3.setCenterY(event.getY());
        });

        primaryStage.setTitle("Window");
        primaryStage.show();
    }
}
