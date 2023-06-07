package main;

import main.events.*;

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
        return field.hasBall().size()==0;
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
        activeBall.startMove(direction);
    }


    /**
     * События
     */

    private class GateObserver implements GateListener {

        @Override
        public void ballIsGoal(GateEvent e) {
            setActiveBall(null);
            field.removeBall(e.getBall());
            if(!end()){
                setActiveBall(field.hasBall().get(0));
                repaintGoalBall(e.getOldPosition(), e.getBall());
            }else
            {
                dellLastBall(e.getOldPosition(), e.getBall());
                fireGameStatusIsChanged(true);
            }


        }
    }

    private class BallObserver implements BallListener {

        @Override
        public void ballEndMoving(BallEvent e) {
            ballMoved();
        }

        @Override
        public void moveOnStep(BallEvent e) {
            repaintMovedBall(e.getOldPosition());
        }
    }

    private ArrayList<GameListener> gameListeners = new ArrayList<>();

    public void addGameListener(GameListener listener) {
        gameListeners.add(listener);
    }

    public void removeGameListener( GameListener listener) {
        gameListeners.remove(listener);
    }

    public void ballMoved(){
        for(GameListener listener: gameListeners){
            listener.ballMoved();
        }
    }

    public void repaintMovedBall(Cell oldPosition){
        for(GameListener listener: gameListeners) {
            listener.repaintMovedBall(oldPosition);
        }
    }

    public void repaintGoalBall(Cell oldPosition, Ball dellBall){
        for(GameListener listener: gameListeners) {
            listener.repaintGoalBall(oldPosition, dellBall);
        }
    }

    private void dellLastBall(Cell oldPosition, Ball dellBall){
        for(GameListener listener: gameListeners) {
            listener.dellLastBall(oldPosition, dellBall);
        }
    };

    private void fireGameStatusIsChanged( boolean victory) {
        for(GameListener listener: gameListeners) {
            GameEvent event = new GameEvent(listener);
            event.setVictory(victory);
            listener.gameStatusChanged(event);
        }
    }
}
