package main;

public enum Direction {
    NORTH, SOUTH, WEST, EAST;
    /**
     * Противоположное направление.
     */
    private Direction opposite;

    static  {
        NORTH.opposite = SOUTH;
        SOUTH.opposite = NORTH;
        WEST.opposite = EAST;
        EAST.opposite = WEST;
    }

    /**
     * Получить противоположное направление {@link Direction#opposite}.
     * @return противоположное направление.
     */
    public Direction getOppositeDirection() {
        return opposite;
    }

}
