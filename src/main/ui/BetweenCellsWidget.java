package main.ui;

import main.Orientation;

import javax.swing.*;
import java.awt.*;

public class BetweenCellsWidget extends JPanel {
    private final Orientation orientation;

    public BetweenCellsWidget( Orientation orientation) {
        super(new BorderLayout());
        this.orientation = orientation;
        setPreferredSize(getDimensionByOrientation());
        setBackground(Color.BLACK);
    }

    public void setItem( BlockWidget blockWidget) { // !!! Плохое название - add обозначает множественное добавление, а здесь предполагается задание одного элемента
        // DONE: Переименовал addItem -> setItem.
        if(blockWidget.getOrientation() != orientation) throw new IllegalArgumentException();
        add(blockWidget);                                   // !!! Что будет, если ориентация BetweenCellsWidget и BlockWidget не совпадают??
        // DONE: Добавил проверку на несовпадение ориентаций.
    }

    private Dimension getDimensionByOrientation() {
        return (orientation == Orientation.VERTICAL) ? new Dimension(1, 120) : new Dimension(120, 1);
    }
}
