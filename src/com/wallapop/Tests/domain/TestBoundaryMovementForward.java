package com.wallapop.Tests.domain;

import com.wallapop.marsRover.domain.CoordinateSystem;
import com.wallapop.marsRover.domain.Field;
import com.wallapop.marsRover.domain.MarsRover;
import com.wallapop.marsRover.domain.Orientation;
import org.junit.Test;
import org.testng.Assert;

public class TestBoundaryMovementForward {

    @Test
    public void rover_returns_to_initMapX_if_is_at_endOfMapX() throws Exception {
        var initialOrientation = Orientation.EAST;
        var map = new Field.Builder(4, 4).build();
        var initialCoordinates = new CoordinateSystem(4, 4, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverX(), 0);
    }

    @Test
    public void rover_returns_to_initMapY_if_is_at_endOfMapY() throws Exception {
        var initialOrientation = Orientation.NORTH;
        var map = new Field.Builder(4, 4).build();
        var initialCoordinates = new CoordinateSystem(4, 4, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverY(), 0);
    }

    @Test
    public void rover_returns_to_endMapX_if_is_at_initOfMapX() throws Exception {
        var initialOrientation = Orientation.WEST;
        var map = new Field.Builder(4, 4).build();
        var initialCoordinates = new CoordinateSystem(0, 0, map);


        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverX(), 4);
    }

    @Test
    public void rover_returns_to_endMapY_if_is_at_initOfMapY() throws Exception {
        var initialOrientation = Orientation.SOUTH;
        var map = new Field.Builder(4, 4).build();
        var initialCoordinates = new CoordinateSystem(0, 0, map);


        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverY(), 4);
    }
}