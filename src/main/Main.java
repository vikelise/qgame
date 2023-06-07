package main;

import main.events.GameEvent;
import main.events.GameListener;
import main.ui.FieldWidget;
import main.ui.GameWidget;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        SwingUtilities.invokeLater(GamePanel::new);
    }

    static class GamePanel extends JFrame {

        private Game game;

        private GameWidget gameWidget;
        public GamePanel() throws HeadlessException {
            setVisible(true);
            game = new Game(new Generator());
            gameWidget = new GameWidget(game);
            game.setActiveBall(game.getField().hasBall().get(0));
            game.addGameListener(new GameController());
            JPanel content = (JPanel) this.getContentPane();
            FieldWidget fieldWidget = new FieldWidget(game.getField());
            gameWidget.setFieldWidget(fieldWidget);
            fieldWidget.getBallWidget(game.getActiveBall()).setActive(true);
            content.add(gameWidget);
            content.add(fieldWidget);
            gameWidget.setFocusTraversalKeysEnabled(false);
            pack();
            setResizable(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

        private final class GameController implements GameListener {

            @Override
            public void gameStatusChanged( GameEvent event) {
                boolean victory = event.getVictory();
                if (victory) {
                    JOptionPane.showMessageDialog(GamePanel.this, "Вы выйграли! ");
                }
            }

            @Override
            public void repaintMovedBall(Cell oldPosition) {
                gameWidget.getFieldWidget().getCellWidget(oldPosition).removeItem(gameWidget.getFieldWidget().getBallWidget(game.getActiveBall()));
                gameWidget.getFieldWidget().getCellWidget(game.getActiveBall().owner()).addItem(gameWidget.getFieldWidget().getBallWidget(game.getActiveBall()));
            }

            @Override
            public void repaintGoalBall(Cell oldPosition, Ball dellBall) {
                gameWidget.getFieldWidget().getCellWidget(oldPosition).removeItem(gameWidget.getFieldWidget().getBallWidget(dellBall));
                gameWidget.getFieldWidget().dellBallWidget(dellBall);
                gameWidget.getFieldWidget().getBallWidget(game.getActiveBall()).setActive(true);


            }

            @Override
            public void dellLastBall(Cell oldPosition, Ball dellBall) {
                gameWidget.getFieldWidget().getCellWidget(oldPosition).removeItem(gameWidget.getFieldWidget().getBallWidget(dellBall));
                gameWidget.getFieldWidget().dellBallWidget(dellBall);
            }

            @Override
            public void ballMoved() {
                gameWidget.setFocusable(true);
                gameWidget.requestFocus();
            }
        }
    }

}
