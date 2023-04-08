package main;

import main.events.BallEvent;
import main.events.BallListener;
import main.events.GateEvent;
import main.events.GateListener;

import java.util.ArrayList;

public class Game {
    private Ball activeBall;
    private Field field;
    private Generator generator;

    public Game(Generator generator) {
        this.generator = generator;
        start();
    }

    private ArrayList<Gate> gateList = new ArrayList<Gate>();


    public Field getField(){return field; }

    /**
     * Постоить поле и обстановку на нем
     */
    private void build() {
        field = generator.buildField();
    }

    public void setActiveBall(Ball ball) {
        this.activeBall = ball;
    }

    public Ball getActiveBall() {
        return activeBall;
    }

    /**
     * Проверить закончилась ли игра
     * @return результат проверки
     */
    private boolean end() {
        if (field.hasBall().size()!=0)
            return true;
        else return false;
    }

    /**
     * Начать игру
     */
    private void start() {
        build();

        for(var i: field.hasBall()){
            i.addBallListener(new BallObserver());
        }

        for(var j: field.hasGate()){
            j.addGateListener(new GateObserver());
        }

    }

    /**
     * Задать активному шарику направление движения(заставить его двигаться)
     * @param direction - направление движения
     */
    public void setDirection(Direction direction) {
        activeBall.move(direction);
    }


    /**
     * События
     */

    private class GateObserver implements GateListener {

        @Override
        public void ballIsGoal(GateEvent e) {
            setActiveBall(null);
            field.removeBall(e.getBall());
            end();
        }
    }


    private class BallObserver implements BallListener {

        @Override
        public void ballMoved(BallEvent e) {
            setActiveBall(null);
            end();
        }
    }
}
