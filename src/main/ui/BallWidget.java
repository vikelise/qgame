package main.ui;

import main.Ball;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BallWidget extends CellWidget {
    private  Ball ball;
    private  boolean active;

    public BallWidget(Ball ball){
        super();
        this.ball = ball;
        //setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            BufferedImage image = ImageIO.read(getBallFileByActive(ball, active));
            image = ImageUtils.resizeImage(image, 100, 100);
            g.drawImage(image,10, 5, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
    protected BufferedImage getImage() {
        BufferedImage image = null;
        try{
            image = ImageIO.read(getBallFileByActive(ball, active));
            image = ImageUtils.resizeImage(image, 120, 120);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }


//    @Override
//    public CellWidget.Layer getLayer() {
//        return CellWidget.Layer.TOP;
//    }


    public void setActive(boolean state){
        this.active = state;
        repaint();
    }





    private static File getBallFileByActive(Ball ball, boolean active) {
        File file = null;
        if (ball.getColor() == "red")  {
            file = active ? new File("activeRedBall.png") : new File("redBall.png");
        }
        if (ball.getColor() == "blue") {
            file = active ? new File("activeBlueBall.png") : new File("blueBall.png");
        }
        return file;
    }


}
