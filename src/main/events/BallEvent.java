package main.events;

import main.Ball;


import java.util.EventObject;

public class BallEvent extends EventObject {

    private Ball ball;

    public BallEvent(Object source) {
        super(source);
    }

    public void setBall(Ball b){
        this.ball = b;
    }

    public Ball ball(){
        return this.ball;
    }
}
