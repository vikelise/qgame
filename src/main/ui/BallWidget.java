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
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            BufferedImage image = ImageIO.read(getBallFileByActive(ball, active));
            image = resizeImage(image, 40, 40);
            g.drawImage(image,5, 0, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private static BufferedImage resizeImage(BufferedImage img, Integer width, Integer height) {
        Image tmpImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(tmpImg, 0, 0, null);
        g.dispose();

        return bufferedImage;
    }





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
        if (ball.getColor() == "green") {
            file = active ? new File("activeGreenBall.png") : new File("greenBall.png");
        }

//        file = active ? new File("active"+ball.getColor()+"Ball.png") : new File("greenBall.png");

//        String res = "";
//        if (active) { res.append("active"); }
//        res.append(ball.getColor()+"Ball.png");
//        new File(res);
        return file;
    }


}
