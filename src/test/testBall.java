package test;
import main.*;
import main.events.BallEvent;
import main.events.BallListener;
import main.events.GateEvent;
import main.events.GateListener;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class testBall {


    @Test
    public  void goingBeyondBordersField() throws InterruptedException {
        Field field = new Field(1, 5);
        Ball first_ball = new Ball();
        first_ball.setColor("red");

        field.getCell(new Point(0,  0)).setUnit(first_ball);
        first_ball.setOwner(field.getCell(new Point(0,  0)));
        field.addBall(first_ball);

        first_ball.startMove(Direction.SOUTH);

        Point exp_point1 = new Point(0, 4);
        Assert.assertEquals(field.getCell(exp_point1), first_ball.owner());
    }

    @Test
    public  void ballFacesWithBall() throws InterruptedException {
        Field field = new Field(1, 5);
        Ball first_ball = new Ball();
        first_ball.setColor("red");
        Ball second_ball = new Ball();
        second_ball.setColor("blue");

        field.getCell(new Point(0,  0)).setUnit(first_ball);
        first_ball.setOwner(field.getCell(new Point(0,  0)));
        field.addBall(first_ball);

        field.getCell(new Point(0,4)).setUnit(second_ball);
        second_ball.setOwner(field.getCell(new Point(0,4)));
        field.addBall(second_ball);

        first_ball.startMove(Direction.SOUTH);

        Point exp_point1 = new Point(0, 3);
        Assert.assertEquals(field.getCell(exp_point1), first_ball.owner());

        Point exp_point2 = new Point(0, 4);
        Assert.assertEquals(field.getCell(exp_point2), second_ball.owner());
    }

    @Test
    public  void ballFacesWithWall() throws InterruptedException {
        Field field = new Field(1, 5);
        Ball first_ball = new Ball();
        first_ball.setColor("red");
        Wall wall = new Wall();

        field.getCell(new Point(0,  0)).setUnit(first_ball);
        first_ball.setOwner(field.getCell(new Point(0,  0)));
        field.addBall(first_ball);

        field.getCell(new Point(0,4)).setUnit(wall);
        wall.setOwner(field.getCell(new Point(0,4)));

        first_ball.startMove(Direction.SOUTH);

        Point exp_point1 = new Point(0, 3);
        Assert.assertEquals(field.getCell(exp_point1), first_ball.owner());

        Point exp_point2 = new Point(0, 4);
        Assert.assertEquals(field.getCell(exp_point2), wall.owner());
    }



}
