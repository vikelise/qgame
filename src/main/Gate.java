package main;

import main.events.GateEvent;
import main.events.GateListener;

import java.util.ArrayList;

public class Gate extends ColorUnit{
    /**
     * Попытаться поглотить мячик воротами
     * @param ball - поглощаемый (забиваемый) мячик
     */

    public void goal(Ball ball){
        if(ball.getColor()==this.getColor()) {
            Cell oldOwner = ball.owner();
            ball.owner().setUnit(null);
            ball.setOwner(null);
            ballIsGoal(ball, oldOwner);
        }

    }

    // ---------------------- Порождает события -----------------------------

    private ArrayList gateListeners = new ArrayList();

    // Присоединяет слушателя
    public void addGateListener(GateListener l){
        gateListeners.add(l);
    }

    // Отсоединяет слушателя
    public void removeGateListener(GateListener l){
        gateListeners.remove(l);
    }

    // Оповещает слушателей о событии
    protected void ballIsGoal(Ball ball, Cell cell){
        GateEvent event = new GateEvent(this);
        event.setGate(this);
        event.setBall(ball);
        event.setOldPosition(cell);

        for(Object listener : gateListeners){
            ((GateListener)listener).ballIsGoal(event);
        }

    }
}
