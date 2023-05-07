package main.events;

import main.Ball;
import main.Cell;


import java.util.EventObject;

public class BallEvent extends EventObject {

    private Ball ball;

    private Cell oldPosition;

    public void setOldPosition(Cell c){
        oldPosition = c;
    }

    public Cell getOldPosition(){
        return oldPosition;
    }



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
