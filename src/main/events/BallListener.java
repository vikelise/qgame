package main.events;

import java.util.EventListener;

public interface BallListener extends EventListener {
    public void ballMoved(BallEvent e);

    public void ballMovedOneCell(BallEvent e);
}
