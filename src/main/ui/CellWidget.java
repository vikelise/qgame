package main.ui;

import main.Cell;

import javax.swing.*;
import java.awt.*;



public class CellWidget extends JPanel {

private BallWidget ballWidget = null;
private static final int CELL_SIZE = 50;

private static final String CELL_COLOR = "#EFEFEF";


public CellWidget() {
    setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
    setBackground(Color.decode(CELL_COLOR));
    }

    public void addItem(BallWidget item){

    int index = 0;
    ballWidget = item;
    add(item, index);
    repaint();

    }

    public void removeItem(BallWidget item){
    if(ballWidget==item){
        int index = 0;
        remove(index);
        ballWidget=null;
        repaint();

    }

    }

}
