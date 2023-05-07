package main.ui;

import main.Cell;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class CellWidget extends JPanel {
//public enum Layer{
//    TOP,
//    BOTTOM
//}
private ArrayList<BallWidget> items = new ArrayList<>();
private static final int CELL_SIZE = 120;


public CellWidget() {
    setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
    setBackground(Color.decode("#EFEFEF"));
    }

    public void addItem(BallWidget item){

    int index = 0;
    items.add(item);
    add(item, index);
    repaint();

    }

    public void removeItem(BallWidget item){
    if(items.contains(item)){
        int index = 0;
        remove(index);
        items.remove(item);
        repaint();

    }

    }

}
