package main;

public class OrdinaryBall extends Ball{
    private Ordinary _interface = new Ordinary();


    public void startMove(Direction direction){
        _interface.startMove(direction);
    }


    @Override
    protected void Moving(){
        boolean isMoved;
        if(this.owner()!=null) {
            isMoved = moveOnStep();
            if (!isMoved) {
                if (this.owner().getNeighbour(getDirection()).getUnit() instanceof Gate) {
                    ((Gate)this.owner().getNeighbour(getDirection()).getUnit()).goal(this);
                }
                ballEndMoving();
            } else
                moveOnStep(this.owner().getNeighbour(getDirection().getOppositeDirection()));
        }
    }



    /**
     * Сместиться на один шаг (ячейку) в заданном направление, если это возможно
     * @return успешность смещения
     */
    @Override
    protected boolean moveOnStep(){
        if(this.owner().getNeighbour(getDirection()).getUnit()==null) {
            this.owner().setUnit(null);
            this.setOwner(this.owner().getNeighbour(getDirection()));
            this.owner().setUnit(this);
            return true;
        }
        return false;

    }

    private class Ordinary implements InterfaceOrdinaryBall{

        @Override
        public void startMove(Direction direction) {
            setDirection(direction);
            startTimer();
        }
    }
}
