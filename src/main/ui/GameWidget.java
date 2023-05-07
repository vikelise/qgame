package main.ui;


import main.*;

import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameWidget extends JPanel {
    private final Game game;
   private FieldWidget fieldWidget;

    public GameWidget(Game game){
        this.game = game;
        addKeyListener(new KeyController());
        setFocusable(true);
        requestFocus();

    }



public FieldWidget getFieldWidget(){
        return fieldWidget;
}
public void setFieldWidget(FieldWidget fw){
        this.fieldWidget = fw;
}

    private class KeyController implements KeyListener {

        @Override
        public void keyTyped(KeyEvent arg0) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            int keyCode = ke.getKeyCode();

            moveAction(keyCode);
            replaceBall(keyCode);



        }

        @Override
        public void keyReleased(KeyEvent arg0) {
        }

        private void moveAction(int keyCode){
            Direction direction = directionByKeyCode(keyCode);
            if(direction != null && game.getActiveBall()!=null) {
                game.getActiveBall().move(direction);
            }
        }


        private void replaceBall(int keyCode){
            if(keyCode == KeyEvent.VK_TAB){
                if(game.getField().hasBall().indexOf(game.getActiveBall()) == game.getField().hasBall().size()-1){
                    fieldWidget.getBallWidget(game.getActiveBall()).setActive(false);
                    game.setActiveBall(game.getField().hasBall().get(0));
                    fieldWidget.getBallWidget(game.getActiveBall()).setActive(true);
                }else{
                    fieldWidget.getBallWidget(game.getActiveBall()).setActive(false);
                    game.setActiveBall(game.getField().hasBall().get(game.getField().hasBall().indexOf(game.getActiveBall())+1));
                    fieldWidget.getBallWidget(game.getActiveBall()).setActive(true);
                };
            }
        }

        private Direction directionByKeyCode( int keyCode) {
            Direction direction = null;
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    direction = Direction.NORTH;
                    break;
                case KeyEvent.VK_DOWN:
                    direction = Direction.SOUTH;
                    break;
                case KeyEvent.VK_LEFT:
                    direction = Direction.WEST;
                    break;
                case KeyEvent.VK_RIGHT:
                    direction = Direction.EAST;
                    break;
            }
            return direction;
        }
    }




}
