package main.events;

import java.util.EventObject;

public class GameEvent extends EventObject {

    private boolean victory;

    public boolean getVictory() {
        return victory;
    }
    public void setVictory(boolean vic){
        this.victory=vic;
    }

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public GameEvent(Object source) {
        super(source);
    }
}
