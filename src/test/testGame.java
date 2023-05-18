package test;

import main.*;
import main.events.BallEvent;
import main.events.BallListener;
import main.events.GateEvent;
import main.events.GateListener;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class testGame {

    private enum EVENT {BALLISGOAL, BALLMOVED}
    private ArrayList<EVENT> gate_events = new ArrayList<>();

    private ArrayList<EVENT> ball_events = new ArrayList<>();

    private class GateObserver implements GateListener{
        @Override
        public void ballIsGoal(GateEvent e) {
            gate_events.add(EVENT.BALLISGOAL);
        }
    }

    private class BallObserver implements BallListener{

        @Override
        public void ballEndMoving(BallEvent e) {
            ball_events.add(EVENT.BALLMOVED);
        }

        @Override
        public void moveOnStep(BallEvent e) {

        }
    }



    @Test
    public  void gateEvent(){
        Field field = new Field(1, 2);
        Ball ball = new Ball();
        ball.setColor("red");
        Gate gate = new Gate();
        gate.setColor("red");

        field.getCell(new Point(0,  0)).setUnit(ball);
        ball.setOwner(field.getCell(new Point(0,  0)));
        field.addBall(ball);

        field.getCell(new Point(0,  1)).setUnit(gate);
        gate.setOwner(field.getCell(new Point(0,  1)));
        field.addGate(gate);


        for(var j: field.hasGate()){
            j.addGateListener(new GateObserver());
        }

        gate.goal(ball);

        assertTrue(!gate_events.isEmpty());
    }

    @Test
    public  void gateNotEvent(){
        Field field = new Field(1, 2);
        Ball ball = new Ball();
        ball.setColor("red");
        Gate gate = new Gate();
        gate.setColor("blue");

        field.getCell(new Point(0,  0)).setUnit(ball);
        ball.setOwner(field.getCell(new Point(0,  0)));
        field.addBall(ball);

        field.getCell(new Point(0,  1)).setUnit(gate);
        gate.setOwner(field.getCell(new Point(0,  1)));
        field.addGate(gate);


        for(var j: field.hasGate()){
            j.addGateListener(new GateObserver());
        }

        gate.goal(ball);

        assertTrue(gate_events.isEmpty());
    }

    @Test
    public  void ballEvent() throws InterruptedException {
        Field field = new Field(1, 5);
        Ball ball = new Ball();
        ball.setColor("red");

        field.getCell(new Point(0,  0)).setUnit(ball);
        ball.setOwner(field.getCell(new Point(0,  0)));
        field.addBall(ball);

        for(var i: field.hasBall()){
            i.addBallListener(new BallObserver());
        }

        ball.startMove(Direction.SOUTH);

        assertTrue(!ball_events.isEmpty());
    }


}
