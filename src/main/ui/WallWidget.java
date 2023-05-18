package main.ui;

import main.Wall;

import javax.swing.*;

public class WallWidget extends JPanel {
    private Wall wall ;
    private static final String WALL_COLOR = "#B3B3B3";
    public WallWidget(Wall w){
        this.wall = w;
    }

    public String getWallColor(){
        return WALL_COLOR;
    }

}
