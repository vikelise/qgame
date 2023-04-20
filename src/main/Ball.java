package main;

import main.events.BallEvent;
import main.events.BallListener;

import java.util.ArrayList;

public class Ball extends Unit{
    private String color;

    /**
     *
     * @param c - цвет мячика
     */
    public Ball(String c){
        this.color = c;
    }

    /**
     * Сместиться взаданном направление пока это возможно (нет препядствий или поле не закончилось)
     * @param direction - направление движения
     */
    public void move(Direction direction){
        boolean isMoved = true;
        do{
            isMoved = moveOnOneCell(direction);
            if(!isMoved){
                if (this.owner().getNeighbour(direction).getUnit() instanceof Gate) {
                    this.owner().getNeighbour(direction).getUnit().goal(this);
                }
            }
        }
        while (this.owner().getNeighbour(direction)!=null && isMoved);
        ballMoved();
    }

    public String getColor(){
        return this.color;
    }

    /**
     * Сместиться на один шаг (ячейку) в заданном направление, если это возможно
     * @param direction - направление смещения
     * @return успешность смещения
     */
    private boolean moveOnOneCell(Direction direction){
        if(this.owner().getNeighbour(direction).getUnit()==null) {
                this.owner().setUnit(null);
                this.setOwner(this.owner().getNeighbour(direction));
                this.owner().setUnit(this);
                return true;
        }else return false;

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
    protected void ballMoved(){
        BallEvent event = new BallEvent(this);
        event.setBall(this);

        for (Object listener : ballListener){
            ((BallListener)listener).ballMoved(event);
        }
    }


}
