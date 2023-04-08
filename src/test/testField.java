package test;


import main.Direction;
import main.Field;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class testField {
    @Test
    public  void verticalField(){
        Field field = new Field(1, 3);

        Assert.assertEquals(null, field.getCell(new Point(0,0)).getNeighbour(Direction.EAST));
        Assert.assertEquals(null, field.getCell(new Point(0,0)).getNeighbour(Direction.WEST));
        Assert.assertEquals(null, field.getCell(new Point(0,0)).getNeighbour(Direction.NORTH));
        Assert.assertEquals(field.getCell(new Point(0,1)), field.getCell(new Point(0,0)).getNeighbour(Direction.SOUTH));

        Assert.assertEquals(null, field.getCell(new Point(0,1)).getNeighbour(Direction.EAST));
        Assert.assertEquals(null, field.getCell(new Point(0,1)).getNeighbour(Direction.WEST));
        Assert.assertEquals(field.getCell(new Point(0,0)), field.getCell(new Point(0,1)).getNeighbour(Direction.NORTH));
        Assert.assertEquals(field.getCell(new Point(0,2)), field.getCell(new Point(0,1)).getNeighbour(Direction.SOUTH));

        Assert.assertEquals(null, field.getCell(new Point(0,2)).getNeighbour(Direction.EAST));
        Assert.assertEquals(null, field.getCell(new Point(0,2)).getNeighbour(Direction.WEST));
        Assert.assertEquals(field.getCell(new Point(0,1)), field.getCell(new Point(0,2)).getNeighbour(Direction.NORTH));
        Assert.assertEquals(null, field.getCell(new Point(0,2)).getNeighbour(Direction.SOUTH));
    }

    @Test
    public  void horizontalField(){
        Field field = new Field(3, 1);

        Assert.assertEquals(null, field.getCell(new Point(0,0)).getNeighbour(Direction.WEST));
        Assert.assertEquals(field.getCell(new Point(1,0)), field.getCell(new Point(0,0)).getNeighbour(Direction.EAST));
        Assert.assertEquals(null, field.getCell(new Point(0,0)).getNeighbour(Direction.NORTH));
        Assert.assertEquals(null, field.getCell(new Point(0,0)).getNeighbour(Direction.SOUTH));

        Assert.assertEquals(field.getCell(new Point(0,0)), field.getCell(new Point(1,0)).getNeighbour(Direction.WEST));
        Assert.assertEquals(field.getCell(new Point(2,0)), field.getCell(new Point(1,0)).getNeighbour(Direction.EAST));
        Assert.assertEquals(null, field.getCell(new Point(1,0)).getNeighbour(Direction.NORTH));
        Assert.assertEquals(null, field.getCell(new Point(1,0)).getNeighbour(Direction.SOUTH));

        Assert.assertEquals(field.getCell(new Point(1, 0)), field.getCell(new Point(2,0)).getNeighbour(Direction.WEST));
        Assert.assertEquals(null, field.getCell(new Point(2,0)).getNeighbour(Direction.EAST));
        Assert.assertEquals(null, field.getCell(new Point(2,0)).getNeighbour(Direction.NORTH));
        Assert.assertEquals(null, field.getCell(new Point(2,0)).getNeighbour(Direction.SOUTH));
    }
}
