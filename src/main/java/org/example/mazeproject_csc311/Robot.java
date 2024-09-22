package org.example.mazeproject_csc311;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

public class Robot {

    //private members
    private Image robotImg;
    private ImageView robotView;
    private Image mazeImg;
    private int mazeWidth;
    private int mazeHeight;


    public Robot(String robotImageURL, String mazeImgUrl) {
        this.robotImg = new Image(robotImageURL);
        this.robotView = new ImageView(this.robotImg);
        this.robotView.setX(15);
        this.robotView.setY(260);
        this.mazeImg = new Image(mazeImgUrl);
        this.mazeWidth = (int) this.mazeImg.getWidth();
        this.mazeHeight = (int) this.mazeImg.getHeight();
    }

    //return robotView
    public ImageView getImageView() {
        return robotView;
    }

    public void move(double x, double y){

        //new coordinates for robot
        double updatedX = robotView.getX() + x;
        double updatedY = robotView.getY() + y;

        //
        //Image image = new Image("maze.png");
        PixelReader pixelReader = mazeImg.getPixelReader();

        //dimensions of robot
        int robotWidth = (int)robotImg.getWidth();
        int robotHeight = (int)robotImg.getHeight();

        //make sure robot is in the bounds of the maze
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
