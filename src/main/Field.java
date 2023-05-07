package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Field {
    private int width;
    private int height;
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    private ArrayList<Ball> balls = new ArrayList<>();
    private Map<Point, Cell> cells = new HashMap<>();

    private ArrayList<Gate> gates = new ArrayList<>();

    public Field(int width, int height){
        if(width <= 0) throw new IllegalArgumentException("Field width must be more than 0");
        if(height <= 0) throw new IllegalArgumentException("Field height must be more than 0");
        this.width = width;
        this.height = height;

        setupField();
    }

    /**
     * Породить ячейки, наполняющие поле, и связи между ними и полем
     */
    private void setupField() {
        for(int y = 0; y < height; ++y) {
            for(int x = 0; x < width; ++x) {
                Point p = new Point(x, y);
                Cell cell = new Cell();
                if(x > 0) getCell(new Point((int) (p.getX()-1), (int) p.getY())).setNeighbour(cell, Direction.EAST);
                if(y > 0) getCell(new Point((int) p.getX(), (int) (p.getY() - 1))).setNeighbour(cell, Direction.SOUTH);
                cells.put(p, cell);
            }
        }
    }

    public Cell getCell(Point point){return cells.get(point); }

    public void addGate(Gate gate){this.gates.add(gate);}

    public ArrayList<Gate> hasGate(){
        return gates;
    }


    public ArrayList<Ball> hasBall(){
        return balls;
    }

    public void addBall(Ball b){
        this.balls.add(b);
    }

    public void removeBall(Ball b){
        this.balls.remove(b);
    }



}
