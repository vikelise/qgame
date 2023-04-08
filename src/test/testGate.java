package test;

import main.Ball;
import main.Direction;
import main.Field;
import main.Gate;
import main.events.BallEvent;
import main.events.BallListener;
import main.events.GateEvent;
import main.events.GateListener;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class testGate {


    @Test
    public  void colorBallSameColorGate(){
        Field field = new Field(1, 2);
        Ball ball = new Ball("red");
        Gate gate = new Gate("red");

        field.getCell(new Point(0,  0)).setUnit(ball);
        ball.setOwner(field.getCell(new Point(0,  0)));
        field.addBall(ball);

        field.getCell(new Point(0,  1)).setUnit(gate);
        gate.setOwner(field.getCell(new Point(0,  1)));
        field.addGate(gate);

        gate.goal(ball);

        Assert.assertEquals(null, ball.owner());
        Assert.assertEquals(null, field.getCell(new Point(0,0)).getUnit());

        Assert.assertEquals(field.getCell(new Point(0,1)), gate.owner());
        Assert.assertEquals(gate, field.getCell(new Point(0,1)).getUnit());
    }

    @Test
    public  void colorBallNotSameColorGate(){
        Field field = new Field(1, 2);
        Ball ball = new Ball("red");
        Gate gate = new Gate("green");

        field.getCell(new Point(0,  0)).setUnit(ball);
        ball.setOwner(field.getCell(new Point(0,  0)));
        field.addBall(ball);

        field.getCell(new Point(0,  1)).setUnit(gate);
        gate.setOwner(field.getCell(new Point(0,  1)));
        field.addGate(gate);

        gate.goal(ball);

        Assert.assertEquals(field.getCell(new Point(0,0)), ball.owner());
        Assert.assertEquals(ball, field.getCell(new Point(0,0)).getUnit());

        Assert.assertEquals(field.getCell(new Point(0,1)), gate.owner());
        Assert.assertEquals(gate, field.getCell(new Point(0,1)).getUnit());
    }


}
