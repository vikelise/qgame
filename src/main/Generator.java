package main;

import com.sun.source.tree.LabeledStatementTree;

import java.awt.*;

public  class Generator {

    private static final int FIELD_HEIGHT = 10;
    private static final int FIELD_WIDTH = 10;
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
        Wall wall00 = new Wall();
        Wall wall10 = new Wall();
        Wall wall20 = new Wall();
        Wall wall30 = new Wall();
        Wall wall40 = new Wall();
        Wall wall41 = new Wall();
        Wall wall43 = new Wall();
        Wall wall53 = new Wall();
        Wall wall63 = new Wall();
        Wall wall64 = new Wall();
        Wall wall65= new Wall();
        Wall wall66 = new Wall();
        Wall wall76 = new Wall();
        Wall wall86 = new Wall();
        Wall wall96 = new Wall();
        Wall wall97 = new Wall();
        Wall wall98 = new Wall();
        Wall wall99 = new Wall();
        Wall wall89 = new Wall();
        Wall wall79 = new Wall();
        Wall wall69 = new Wall();
        Wall wall59 = new Wall();
        Wall wall39 = new Wall();
        Wall wall29 = new Wall();
        Wall wall19 = new Wall();
        Wall wall09 = new Wall();
        Wall wall07 = new Wall();
        Wall wall06 = new Wall();

        Wall wall04 = new Wall();
        Wall wall03 = new Wall();
        Wall wall02 = new Wall();
        Wall wall01 = new Wall();


        field.getCell(new Point(0, 0)).setUnit(wall00);
        wall00.setOwner(field.getCell(new Point(0,0)));

        field.getCell(new Point(1,0 )).setUnit(wall10);
        wall10.setOwner(field.getCell(new Point(1,0)));

        field.getCell(new Point(2, 0)).setUnit(wall20);
        wall20.setOwner(field.getCell(new Point(2,0)));

        field.getCell(new Point(3, 0)).setUnit(wall30);
        wall30.setOwner(field.getCell(new Point(3,0)));

        field.getCell(new Point(4, 0)).setUnit(wall40);
        wall40.setOwner(field.getCell(new Point(4,0)));

        field.getCell(new Point(4, 1)).setUnit(wall41);
        wall41.setOwner(field.getCell(new Point(4,1)));

        field.getCell(new Point(4, 3)).setUnit(wall43);
        wall43.setOwner(field.getCell(new Point(4,3)));

        field.getCell(new Point(5, 3)).setUnit(wall53);
        wall53.setOwner(field.getCell(new Point(5,3)));

        field.getCell(new Point(6, 3)).setUnit(wall63);
        wall63.setOwner(field.getCell(new Point(6,3)));

        field.getCell(new Point(6, 4)).setUnit(wall64);
        wall64.setOwner(field.getCell(new Point(6,4)));

        field.getCell(new Point(6, 5)).setUnit(wall65);
        wall65.setOwner(field.getCell(new Point(6,5)));

        field.getCell(new Point(6, 6)).setUnit(wall66);
        wall66.setOwner(field.getCell(new Point(6,6)));

        field.getCell(new Point(7, 6)).setUnit(wall76);
        wall76.setOwner(field.getCell(new Point(7,6)));

        field.getCell(new Point(8, 6)).setUnit(wall86);
        wall86.setOwner(field.getCell(new Point(8,6)));

        field.getCell(new Point(9,6 )).setUnit(wall96);
        wall96.setOwner(field.getCell(new Point(9,6)));

        field.getCell(new Point(9, 7)).setUnit(wall97);
        wall97.setOwner(field.getCell(new Point(9,7)));

        field.getCell(new Point(9, 8)).setUnit(wall98);
        wall98.setOwner(field.getCell(new Point(9,8)));

        field.getCell(new Point(9, 9)).setUnit(wall99);
        wall99.setOwner(field.getCell(new Point(9,9)));

        field.getCell(new Point(8, 9)).setUnit(wall89);
        wall89.setOwner(field.getCell(new Point(8,9)));

        field.getCell(new Point(7, 9)).setUnit(wall79);
        wall79.setOwner(field.getCell(new Point(7,9)));

        field.getCell(new Point(6, 9)).setUnit(wall69);
        wall69.setOwner(field.getCell(new Point(6,9)));

        field.getCell(new Point(5, 9)).setUnit(wall59);
        wall59.setOwner(field.getCell(new Point(5,9)));

        field.getCell(new Point(3, 9)).setUnit(wall39);
        wall39.setOwner(field.getCell(new Point(3,9)));

        field.getCell(new Point(2, 9)).setUnit(wall29);
        wall29.setOwner(field.getCell(new Point(2,9)));

        field.getCell(new Point(1, 9)).setUnit(wall19);
        wall19.setOwner(field.getCell(new Point(1,9)));

        field.getCell(new Point(0, 9)).setUnit(wall09);
        wall09.setOwner(field.getCell(new Point(0,9)));

        field.getCell(new Point(0, 7)).setUnit(wall07);
        wall07.setOwner(field.getCell(new Point(0,7)));

        field.getCell(new Point(0, 6)).setUnit(wall06);
        wall06.setOwner(field.getCell(new Point(0,6)));



        field.getCell(new Point(0, 4)).setUnit(wall04);
        wall04.setOwner(field.getCell(new Point(0,4)));

        field.getCell(new Point(0, 3)).setUnit(wall03);
        wall03.setOwner(field.getCell(new Point(0,3)));

        field.getCell(new Point(0, 2)).setUnit(wall02);
        wall02.setOwner(field.getCell(new Point(0,2)));

        field.getCell(new Point(0, 1)).setUnit(wall01);
        wall01.setOwner(field.getCell(new Point(0,1)));




    };
    protected void addGates(){
        Gate gate1 = new Gate();
        gate1.setColor("red");
        Gate gate2 = new Gate();
        gate2.setColor("blue");
        Gate gate3 = new Gate();
        gate3.setColor("green");
        Gate gate4 = new Gate();
        gate4.setColor("purple");

        field.getCell(new Point(0,8)).setUnit(gate1);
        gate1.setOwner(field.getCell(new Point(0,8)));
        field.addGate(gate1);

        field.getCell(new Point(4,2)).setUnit(gate2);
        gate2.setOwner(field.getCell(new Point(4,2)));
        field.addGate(gate2);

        field.getCell(new Point(4,9)).setUnit(gate3);
        gate3.setOwner(field.getCell(new Point(4,9)));
        field.addGate(gate3);

        field.getCell(new Point(0,5)).setUnit(gate4);
        gate4.setOwner(field.getCell(new Point(0,5)));
        field.addGate(gate4);
    };
    protected  void addBalls(){
         //Ball firstBall = new Ball();
        OrdinaryBall firstBall = new OrdinaryBall();
         firstBall.setColor("red");
         //Ball secondBall = new Ball();
        RandomlyMovingBall secondBall = new RandomlyMovingBall();
         secondBall.setColor("blue");
       // Ball thirdBall = new Ball();
        NoConvergingBall thirdBall = new NoConvergingBall();
        thirdBall.setColor("green");

        JumpingBall fourthBall = new JumpingBall();
        fourthBall.setColor("purple");

         field.getCell(new Point(8,8)).setUnit(firstBall);
         firstBall.setOwner(field.getCell(new Point(8,8)));
         field.addBall(firstBall);

         field.getCell(new Point(1,2)).setUnit(secondBall);
        secondBall.setOwner(field.getCell(new Point(1,2)));
        field.addBall(secondBall);

        field.getCell(new Point(4,4)).setUnit(thirdBall);
        thirdBall.setOwner(field.getCell(new Point(4,4)));
        field.addBall(thirdBall);

        field.getCell(new Point(3,7)).setUnit(fourthBall);
        fourthBall.setOwner(field.getCell(new Point(3,7)));
        field.addBall(fourthBall);
    };

}
