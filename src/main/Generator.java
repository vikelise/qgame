package main;

import com.sun.source.tree.LabeledStatementTree;

import java.awt.*;

public  class Generator {

    private static final int FIELD_HEIGHT = 5;
    private static final int FIELD_WIDTH = 5;
    protected Field field;



    public Field buildField(){
         field = new Field(fieldWidth(), fieldHeight());
        addWalls();
        addGates();
        addBalls();
        return field;
    }



    protected int fieldHeight(){
        return FIELD_HEIGHT;
    };

    protected  int fieldWidth(){
        return FIELD_WIDTH;
    };

    protected void addWalls(){
        Wall wall1 = new Wall();
        Wall wall2 = new Wall();
        Wall wall3 = new Wall();
        Wall wall4 = new Wall();
        Wall wall5 = new Wall();
        Wall wall6 = new Wall();
        Wall wall7 = new Wall();
        Wall wall8 = new Wall();
        Wall wall9 = new Wall();
        Wall wall10 = new Wall();
        Wall wall11 = new Wall();
        Wall wall12 = new Wall();
        Wall wall13 = new Wall();
        Wall wall14 = new Wall();

        field.getCell(new Point(0, 0)).setUnit(wall1);
        wall1.setOwner(field.getCell(new Point(0,0)));

        field.getCell(new Point(0, 1)).setUnit(wall2);
        wall2.setOwner(field.getCell(new Point(0,1)));

        field.getCell(new Point(0, 2)).setUnit(wall3);
        wall3.setOwner(field.getCell(new Point(0,2)));

        field.getCell(new Point(0, 4)).setUnit(wall4);
        wall4.setOwner(field.getCell(new Point(0,4)));

        field.getCell(new Point(1, 4)).setUnit(wall5);
        wall5.setOwner(field.getCell(new Point(1,4)));

        field.getCell(new Point(2, 4)).setUnit(wall6);
        wall6.setOwner(field.getCell(new Point(2,4)));

        field.getCell(new Point(3, 4)).setUnit(wall7);
        wall7.setOwner(field.getCell(new Point(3,4)));

        field.getCell(new Point(4, 4)).setUnit(wall8);
        wall8.setOwner(field.getCell(new Point(4,4)));

        field.getCell(new Point(4, 3)).setUnit(wall9);
        wall9.setOwner(field.getCell(new Point(4,3)));

        field.getCell(new Point(4, 2)).setUnit(wall10);
        wall10.setOwner(field.getCell(new Point(4,2)));

        field.getCell(new Point(4, 1)).setUnit(wall11);
        wall11.setOwner(field.getCell(new Point(4,1)));

        field.getCell(new Point(4, 0)).setUnit(wall12);
        wall12.setOwner(field.getCell(new Point(4,0)));

        field.getCell(new Point(2, 0)).setUnit(wall13);
        wall13.setOwner(field.getCell(new Point(2,0)));

        field.getCell(new Point(1, 0)).setUnit(wall14);
        wall14.setOwner(field.getCell(new Point(1,0)));
    };
    protected void addGates(){
        Gate gate1 = new Gate("red");
        Gate gate2 = new Gate("blue");

        field.getCell(new Point(0,3)).setUnit(gate1);
        gate1.setOwner(field.getCell(new Point(0,3)));
        field.addGate(gate1);

        field.getCell(new Point(3,0)).setUnit(gate2);
        gate2.setOwner(field.getCell(new Point(3,0)));
        field.addGate(gate2);
    };
    protected  void addBalls(){
         Ball firstBall = new Ball("red");
         Ball secondBall = new Ball("blue");

         field.getCell(new Point(3,3)).setUnit(firstBall);
         firstBall.setOwner(field.getCell(new Point(3,3)));
         field.addBall(firstBall);

         field.getCell(new Point(2,2)).setUnit(secondBall);
        secondBall.setOwner(field.getCell(new Point(2,2)));
        field.addBall(secondBall);
    };

}
