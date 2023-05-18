package main;

import main.events.BallEvent;
import main.events.BallListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class Ball extends Unit{

    private Timer timer ;
    private Direction direction;

    private String color;
    public void setColor(String c){
        this.color = c;
    }

    public String getColor(){return color;}



    public Ball(){
        ActionListener timerListener = new TimerController();
        timer = new Timer(250, timerListener);
    }



    /**
     * Сместиться взаданном направление пока это возможно (нет препядствий или поле не закончилось)
     * @param direction - направление движения
     */
    public void startMove(Direction direction){
        this.direction = direction;
        timer.start();
    }

    private void Moving(){
        boolean isMoved;
        if(this.owner()!=null) {
            isMoved = moveOnStep();
            if (!isMoved) {
                if (this.owner().getNeighbour(this.direction).getUnit() instanceof Gate) {
                    this.owner().getNeighbour(this.direction).getUnit().goal(this);
                }
                ballEndMoving();
            } else
                moveOnStep(this.owner().getNeighbour(this.direction.getOppositeDirection()));
        }
    }



    /**
     * Сместиться на один шаг (ячейку) в заданном направление, если это возможно
     * @return успешность смещения
     */
    private boolean moveOnStep(){
        if(this.owner().getNeighbour(this.direction).getUnit()==null) {
                this.owner().setUnit(null);
                this.setOwner(this.owner().getNeighbour(this.direction));
                this.owner().setUnit(this);
                return true;
        }
        return false;

    }

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
