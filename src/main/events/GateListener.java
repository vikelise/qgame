package main.events;

import java.util.EventListener;

public interface GateListener extends EventListener {
    public void ballIsGoal(GateEvent e);

}
