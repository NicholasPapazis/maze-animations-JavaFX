package org.example.mazeproject_csc311;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MazeApplication extends Application {

    //variables for maze
    Image mazeImg;
    ImageView mazeView;
    Image robotImg;
    ImageView robotView;
    Robot robot;

    //variables for maze2
    Image maze2Img;
    ImageView maze2View;

    @Override
    public void start(Stage stage) throws IOException {


        //load the maze image
        mazeImg = new Image("maze.png");
        mazeView = new ImageView(mazeImg);
        //create the robot object
        robot = new Robot("robot.png", mazeImg.getWidth(), mazeImg.getHeight());
        //create pane as the mazePane node
        Pane mazePane = new Pane(mazeView, robot.getImageView());
        mazePane.setFocusTraversable(true);

        //load maze2 image
        maze2Img = new Image("maze2.png");
        maze2View = new ImageView(maze2Img);
        Pane maze2Pane = new Pane(maze2View);

        //create tab for maze
        Tab maze1 = new Tab("Maze"); //create a new tab for maze
        Tab maze2 = new Tab("Maze2"); //create a tab for maze2
        TabPane tabPane = new TabPane(maze1, maze2); //create a new tabpane
        maze1.setContent(mazePane); //set mazePane to be the contents of the tab
        maze1.setClosable(false); //prevents user from closing tab
        maze2.setContent(maze2Pane); //set maze2Pane to be the content of the tab
        maze2.setClosable(false);//prevent user from closing tab

        //create the scene
        Scene scene = new Scene(tabPane, mazeImg.getWidth() + 15, mazeImg.getHeight() + 35);

        //add key listeners to move the robot
        mazePane.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.RIGHT) {
                robot.move(2, 0); //move right 5 pixels
                event.consume();//terminates the event
            }
            else if(event.getCode() == KeyCode.LEFT){
                robot.move(-2, 0); //move left 5 pixels
                event.consume();//terminates the event
            }
            else if(event.getCode() == KeyCode.UP){
                robot.move(0, -2); //move up 5 pixels
                event.consume();//terminates the event
            }
            else if(event.getCode() == KeyCode.DOWN){
                robot.move(0, 2); //move down 5 pixels
                event.consume();//terminates the event
            }
        });

        //brings focus to mazePane when clicked on so that arrow keys control robot
        mazePane.setOnMouseClicked(event -> mazePane.requestFocus());

        stage.setScene(scene);
        stage.setTitle("Maze");
        stage.show();

        // Initially request focus on the mazePane
        mazePane.requestFocus();






    }

    public static void main(String[] args) {
        launch();
    }
}