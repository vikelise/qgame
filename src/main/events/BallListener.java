package main.events;

import java.util.EventListener;

public interface BallListener extends EventListener {
    public void ballEndMoving(BallEvent e);

    public void moveOnStep(BallEvent e);
}
