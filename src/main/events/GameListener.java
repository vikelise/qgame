package main.events;

import main.Ball;
import main.Cell;

import java.util.EventListener;

public interface GameListener extends EventListener {
    void gameStatusChanged(GameEvent event);



    void repaintMovedBall(Cell oldPosition);

    void repaintGoalBall(Cell oldPosition, Ball delBall);

    void dellLastBall(Cell oldPosition, Ball dellBall);
}
