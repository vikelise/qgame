package main;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RandomlyMovingBall extends Ball{
    private int numberSteps;
    private Randomly _interface = new Randomly();



    public void startMove(Direction direction){
        _interface.startMove(direction);
    }
    @Override
    protected void Moving() {
        boolean isMoved;
        if(this.owner()!=null && numberSteps!=0) {
            isMoved = moveOnStep();
            if (!isMoved) {
                if (this.owner().getNeighbour(getDirection()).getUnit() instanceof Gate) {
                    ((Gate)this.owner().getNeighbour(getDirection()).getUnit()).goal(this);
                }
                ballEndMoving();
            } else {
                moveOnStep(this.owner().getNeighbour(getDirection().getOppositeDirection()));
            }
            numberSteps--;
        } else  ballEndMoving();

    }

    /**
     * Сместиться на один шаг (ячейку) в заданном направление, если это возможно
     *
     * @return успешность смещения
     */
    @Override
    protected boolean moveOnStep() {
        if(this.owner().getNeighbour(getDirection()).getUnit()==null) {
            this.owner().setUnit(null);
            this.setOwner(this.owner().getNeighbour(getDirection()));
            this.owner().setUnit(this);
            return true;
        }
        return false;
    }

    private class Randomly implements InterfaceRandomlyMovingBall{

        @Override
        public void startMove(Direction direction) {
            setDirection(direction);
            startTimer();
            numberSteps = (int) (Math.random() * 7) + 1;
        }
    }
}
