package main;

public class JumpingBall extends Ball{
    private int countJump = 1;
    private Jumping jumpingInterface = new Jumping();
    private Cell oldPosition;


    public void startMove(Direction direction){
        jumpingInterface.startMove(direction);
    }
    @Override
    protected void Moving() {
        boolean isMoved;
        if(this.owner()!=null) {
            isMoved = moveOnStep();
            if (!isMoved) {
                if (this.owner().getNeighbour(getDirection()).getUnit() instanceof Gate) {
                    ((Gate)this.owner().getNeighbour(getDirection()).getUnit()).goal(this);
                }
                ballEndMoving();
            } else
                moveOnStep(oldPosition);
        }
    }

    /**
     * Сместиться на один шаг (ячейку) в заданном направление, если это возможно
     *
     * @return успешность смещения
     */
    @Override
    protected boolean moveOnStep() {
        oldPosition = this.owner();
        if(this.owner().getNeighbour(getDirection()).getUnit()==null) {
            this.owner().setUnit(null);
            this.setOwner(this.owner().getNeighbour(getDirection()));
            this.owner().setUnit(this);
            return true;
        } else {
            if(this.owner().getNeighbour(getDirection()).getUnit() instanceof Ball && countJump!=0 && this.owner().getNeighbour(getDirection()).getNeighbour(getDirection()).getUnit() == null ) {
                countJump--;
                this.owner().setUnit(null);
                this.setOwner(this.owner().getNeighbour(getDirection()).getNeighbour(getDirection()));
                this.owner().setUnit(this);
                return true;
                }
        }return false;
    }




    private class Jumping implements InterfaceJumpingBall{

        @Override
        public void startMove(Direction direction) {
            setDirection(direction);
            startTimer();
        }
    }
}
