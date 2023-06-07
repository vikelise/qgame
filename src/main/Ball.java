package main;

import main.events.BallEvent;
import main.events.BallListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

abstract public class Ball extends ColorUnit{
    private Timer timer ;
    private Direction direction;
    public Direction getDirection(){return direction;}
    public void setDirection(Direction dir){this.direction = dir;}
    /**
     * Сместиться взаданном направление пока это возможно (нет препядствий или поле не закончилось)
     * @param direction - направление движения
     */
    public void startMove(Direction direction){

    }

    public void startTimer(){
        ActionListener timerListener = new TimerController();
        timer = new Timer(250, timerListener);
        timer.start();
    }

    protected abstract void Moving();
        /**
     * Сместиться на один шаг (ячейку) в заданном направление, если это возможно
     * @return успешность смещения
     */
    protected abstract boolean moveOnStep();

    // ---------------------- Порождает события -----------------------------

    private ArrayList ballListener =  new ArrayList();

    // Присоединяет слушателя
    public void addBallListener(BallListener l){
        ballListener.add(l);
    }

    // Отсоединяет слушателя
    public void removeBallListener(BallListener l){
        ballListener.remove(l);
    }

    // Оповещает слушателей о событии
    protected void ballEndMoving(){
        BallEvent event = new BallEvent(this);
        event.setBall(this);
        timer.stop();
        for (Object listener : ballListener){
            ((BallListener)listener).ballEndMoving(event);
        }
    }

    protected void moveOnStep(Cell cell){
        BallEvent event = new BallEvent(this);
        event.setBall(this);
        event.setOldPosition(cell);
        for (Object listener : ballListener){
            ((BallListener)listener).moveOnStep(event);
        }
    }

    private class TimerController implements ActionListener{

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Moving();
        }
    }










}
