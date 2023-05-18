package main.ui;

import main.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class FieldWidget extends JPanel {
    private final Field field;

    private Map<Ball, BallWidget> ballWidgets = new HashMap<>();;
    private  Map<Cell, CellWidget> cellsWidgets = new HashMap<>();

    public FieldWidget(Field field){
        this.field = field;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        fillField();
    }

    public void addBallWidget(Ball b, BallWidget bw){
        this.ballWidgets.put(b, bw);
    }

    public BallWidget getBallWidget(Ball b){
        return ballWidgets.get(b);
    }

    public void dellBallWidget (Ball b){
        ballWidgets.remove(b);
    }

    public CellWidget getCellWidget(Cell c){
        return cellsWidgets.get(c);
    }

    private void fillField(){
        for(int i=0; i< field.getHeight(); i++){
            JPanel row = createRow(i);
            add(row);
            JPanel rowWalls = createRowWalls(i, Direction.SOUTH);
            add(rowWalls);
        }

    }

    private JPanel createRow(int rowIndex) {
        JPanel row = new JPanel();
        row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));

        for(int i = 0; i < field.getWidth(); ++i) {
            Cell cell = field.getCell(new Point(i, rowIndex));
            CellWidget cellWidget = new CellWidget();

            if(cell.getUnit() instanceof Ball){
                BallWidget ballWidget = new BallWidget((Ball) cell.getUnit());
                addBallWidget((Ball)cell.getUnit(), ballWidget);
                cellWidget.addItem(ballWidget);
            }else if (cell.getUnit() instanceof Gate){
                GateWidget gateWidget = new GateWidget((Gate) cell.getUnit());
                cellWidget.setBackground(Color.decode(gateWidget.getColor()));
            }else if (cell.getUnit() instanceof Wall){
                WallWidget wallWidget = new WallWidget((Wall) cell.getUnit());
                cellWidget.setBackground(Color.decode(wallWidget.getWallColor()));
            }
//widgets[cell.getUnit().getClass()].call();
            // cell.getUnit().createWidget();
            cellsWidgets.put(cell, cellWidget);

            BetweenCellsWidget westCellWidget = new BetweenCellsWidget(Orientation.VERTICAL);
            row.add(westCellWidget);

            row.add(cellWidget);

            BetweenCellsWidget eastCellWidget = new BetweenCellsWidget(Orientation.VERTICAL);

            row.add(eastCellWidget);
        }
        return row;
    }

    private JPanel createRowWalls(int rowIndex, Direction direction) {
        if(direction == Direction.EAST || direction == Direction.WEST) throw new IllegalArgumentException();
        JPanel row = new JPanel();
        row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));

        for(int i = 0; i < field.getWidth(); ++i) {

            BetweenCellsWidget southCellWidget = new BetweenCellsWidget(Orientation.HORIZONTAL);

            row.add(southCellWidget);
        }
        return row;
    }


}
