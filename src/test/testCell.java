package test;


import main.Cell;
import main.Direction;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class testCell {
    @Test
    public  void setNeighbourEast(){
        Cell cell1 = new Cell();
        Cell cell2 = new Cell();

        cell1.setNeighbour(cell2, Direction.EAST);

        Assert.assertEquals(cell2, cell1.getNeighbour(Direction.EAST));

        Assert.assertEquals(cell1, cell2.getNeighbour(Direction.WEST));
    }

    @Test
    public  void setNeighbourWest(){
        Cell cell1 = new Cell();
        Cell cell2 = new Cell();

        cell1.setNeighbour(cell2, Direction.WEST);

        Assert.assertEquals(cell2, cell1.getNeighbour(Direction.WEST));

        Assert.assertEquals(cell1, cell2.getNeighbour(Direction.EAST));
    }

    @Test
    public  void setNeighbourNorth(){
        Cell cell1 = new Cell();
        Cell cell2 = new Cell();

        cell1.setNeighbour(cell2, Direction.NORTH);

        Assert.assertEquals(cell2, cell1.getNeighbour(Direction.NORTH));

        Assert.assertEquals(cell1, cell2.getNeighbour(Direction.SOUTH));
    }

    @Test
    public  void setNeighbourSouth(){
        Cell cell1 = new Cell();
        Cell cell2 = new Cell();

        cell1.setNeighbour(cell2, Direction.SOUTH);

        Assert.assertEquals(cell2, cell1.getNeighbour(Direction.SOUTH));

        Assert.assertEquals(cell1, cell2.getNeighbour(Direction.NORTH));
    }

    @Test
    public  void reSetNeighbour(){
        Cell cell1 = new Cell();
        Cell cell2 = new Cell();
        Cell cell3 = new Cell();

        try {
            cell1.setNeighbour(cell2, Direction.SOUTH);
            cell1.setNeighbour(cell3, Direction.SOUTH);
        }catch (Exception e){assertThat(e.getMessage(), is("wrong data"));}

        Assert.assertEquals(cell2, cell1.getNeighbour(Direction.SOUTH));

        Assert.assertEquals(cell1, cell2.getNeighbour(Direction.NORTH));
    }

    @Test
    public  void neighbourAlreadyExist(){
        Cell cell1 = new Cell();
        Cell cell2 = new Cell();

        try {
            cell1.setNeighbour(cell2, Direction.SOUTH);
            cell1.setNeighbour(cell2, Direction.NORTH);
        }catch (Exception e){assertThat(e.getMessage(), is("wrong data"));}

        Assert.assertEquals(cell2, cell1.getNeighbour(Direction.SOUTH));

        Assert.assertEquals(cell1, cell2.getNeighbour(Direction.NORTH));
    }


}
