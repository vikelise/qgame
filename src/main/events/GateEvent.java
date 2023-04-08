package main.events;


import main.Ball;
import main.Gate;

import java.util.EventObject;

public class GateEvent extends EventObject {
    private Gate gate;
    private Ball ball;
    public GateEvent(Object source) {
        super(source);
    }

    public void setGate(Gate g){
        this.gate = g;
    }

    public Gate gate(){
        return this.gate;
    }

    public void setBall(Ball b){
        this.ball = b;
    }

    public Ball getBall(){
        return this.ball;
    }


}
