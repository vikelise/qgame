package test;

import main.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class testNoConvergingBall {

    @Test
    public  void goingBeyondBordersField() throws InterruptedException {
        Field field = new Field(1, 5);
        NoConvergingBall first_ball = new NoConvergingBall();
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
        NoConvergingBall first_ball = new NoConvergingBall();
        first_ball.setColor("red");
        NoConvergingBall second_ball= new NoConvergingBall();
        second_ball.setColor("blue");

        field.getCell(new Point(0,  0)).setUnit(first_ball);
        first_ball.setOwner(field.getCell(new Point(0,  0)));
        field.addBall(first_ball);

        field.getCell(new Point(0,4)).setUnit(second_ball);
        second_ball.setOwner(field.getCell(new Point(0,4)));
        field.addBall(second_ball);

        first_ball.startMove(Direction.SOUTH);

        Point exp_point1 = new Point(0, 2);
        Assert.assertEquals(field.getCell(exp_point1), first_ball.owner());

        Point exp_point2 = new Point(0, 4);
        Assert.assertEquals(field.getCell(exp_point2), second_ball.owner());
    }

    @Test
    public  void ballFacesWithWall() throws InterruptedException {
        Field field = new Field(1, 5);
        NoConvergingBall first_ball = new NoConvergingBall();
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
