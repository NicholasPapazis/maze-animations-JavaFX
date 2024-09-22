package org.example.mazeproject_csc311;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

public class Robot {

    //private members
    private ImageView robotView;
    private int mazeWidth;
    private int mazeHeight;


    public Robot(String ImageURL, double mazeWidth, double mazeHeight) {
        this.robotView = new ImageView(new Image(ImageURL));
        this.robotView.setX(15);
        this.robotView.setY(260);
        this.mazeWidth = (int) mazeWidth;
        this.mazeHeight = (int) mazeHeight;
    }

    //return robotView
    public ImageView getImageView() {
        return robotView;
    }

    public void move(double x, double y){

        double updatedX = robotView.getX() + x;
        double updatedY = robotView.getY() + y;

        //
        Image image = new Image("maze.png");
        PixelReader pixelReader = image.getPixelReader();

        //make dimensions of robot smaller it fits through path easier
        int robotWidth = 20;
        int robotHeight = 20;

        //make sure robot is in the bounds of the robot
        if(updatedX >= 0 && updatedX <= mazeWidth && updatedY >= 0 && updatedY <= mazeHeight
        && updatedX + robotWidth >= 0 && updatedX + robotWidth <= mazeWidth && updatedY + robotHeight >= 0 && updatedY + robotHeight <= mazeHeight)
        {
            Color topLeftColor = pixelReader.getColor((int)updatedX, (int)updatedY);
            Color topRightColor = pixelReader.getColor((int)(updatedX + robotWidth), (int)updatedY);
            Color bottomLeftColor = pixelReader.getColor((int)updatedX, (int)(updatedY + robotHeight));
            Color bottomRightColor = pixelReader.getColor((int)(updatedX + robotWidth), (int)(updatedY + robotHeight));

            //check if robot is on the white path
            if (topLeftColor.equals(Color.WHITE) && topRightColor.equals(Color.WHITE) &&
                    bottomLeftColor.equals(Color.WHITE) && bottomRightColor.equals(Color.WHITE)) {
                //move the robot image
                robotView.setX(updatedX);
                robotView.setY(updatedY);
            } else {
                //if the blue wall is blocking the robot, print the statement
                System.out.println("You have run into a wall!");
            }
        }




    }

}
