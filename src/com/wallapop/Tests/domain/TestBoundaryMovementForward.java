package com.wallapop.Tests.domain;

import com.wallapop.marsRover.domain.*;
import org.junit.Test;
import org.testng.Assert;

public class TestBoundaryMovementForward {

    @Test
    public void rover_returns_to_initMapX_if_is_at_endOfMapX() throws Exception {
        var initialOrientation = Orientation.EAST;
        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(4,4);
        var marsRover = MarsRoverFactory.build(initialOrientation,sizeField, initialCoordinate);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverX(), 0);
    }

    @Test
    public void rover_returns_to_initMapY_if_is_at_endOfMapY() throws Exception {
        var initialOrientation = Orientation.NORTH;
        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(4,4);

        var marsRover = MarsRoverFactory.build(initialOrientation,sizeField, initialCoordinate);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverY(), 0);
    }

    @Test
    public void rover_returns_to_endMapX_if_is_at_initOfMapX() throws Exception {
        var initialOrientation = Orientation.WEST;
        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(0,0);

        var marsRover = MarsRoverFactory.build(initialOrientation,sizeField, initialCoordinate);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverX(), 4);
    }

    @Test
    public void rover_returns_to_endMapY_if_is_at_initOfMapY() throws Exception {
        var initialOrientation = Orientation.SOUTH;
        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(0,0);

        var marsRover = MarsRoverFactory.build(initialOrientation,sizeField, initialCoordinate);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverY(), 4);
    }
}