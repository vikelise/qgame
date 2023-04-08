package main;

import java.util.EnumMap;
import java.util.Map;

public class Cell {

    private Unit unit;

    private Map<Direction, Cell> neighbours = new EnumMap<>(Direction.class);

    /**
     * Установить соседа в заданном напрвлении
     * @param cell - ячейка, которая должна стать соседом текущей ячейки
     * @param direction - правление соседствования, относительно текущей ячейки
     */
    public void setNeighbour(Cell cell, Direction direction){
        if(neighbours.containsKey(direction) || neighbours.containsValue(cell))
            throw new IllegalArgumentException("wrong data");
        else {
            neighbours.put(direction, cell);
            if(cell.getNeighbour(direction.getOppositeDirection())==null)
                cell.setNeighbour(this, direction.getOppositeDirection());
        }
    }

    /**
     * Получить соседа в заданном направлении
     * @param direction - направление, в котором нужено получить соседа
     * @return ячейка-сосед
     */
    public Cell getNeighbour(Direction direction){
        return neighbours.get(direction);
    }

    public Unit getUnit(){
        return this.unit;
    }

    public void setUnit(Unit unit){
        this.unit = unit;
    }


}
