package main;

import main.events.GateEvent;
import main.events.GateListener;

import java.util.ArrayList;

public class Gate extends Unit{
    private String color;

    public Gate(String c){
        this.color = c;

    }

    /**
     * Попытаться поглотить мячик воротами
     * @param ball - поглощаемый (забиваемый) мячик
     */
    @Override
    public void goal(Ball ball){
        if(ball.getColor()==this.color) {
            ball.owner().setUnit(null);
            ball.setOwner(null);
            ballIsGoal(ball);
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
    protected void ballIsGoal(Ball ball){
        GateEvent event = new GateEvent(this);
        event.setGate(this);
        event.setBall(ball);

        for(Object listener : gateListeners){
            ((GateListener)listener).ballIsGoal(event);
        }

    }
}
