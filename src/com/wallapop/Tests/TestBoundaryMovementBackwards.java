package com.wallapop.Tests;

import com.wallapop.marsRover.domain.CoordinateSystem;
import com.wallapop.marsRover.domain.Field;
import com.wallapop.marsRover.domain.MarsRover;
import com.wallapop.marsRover.domain.Orientation;
import org.testng.Assert;
import org.junit.Test;

public class TestBoundaryMovementBackwards {

    @Test
    public void rover_returns_to_initMapX_if_is_at_endOfMapX() throws Exception {
        var initialOrientation = Orientation.WEST;
        var map = new Field(4,4);
        var initialCoordinates = new CoordinateSystem(4,4, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.moveBackwards();
        Assert.assertEquals(marsRover.getRoverX(), 0);
        Assert.assertEquals(marsRover.getRoverY(), 4);
    }
    @Test
    public void rover_returns_to_initMapY_if_is_at_endOfMapY() throws Exception {
        var initialOrientation = Orientation.SOUTH;
        var map = new Field(4,4);
        var initialCoordinates = new CoordinateSystem(4,4, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.moveBackwards();
        Assert.assertEquals(marsRover.getRoverY(), 0);
        Assert.assertEquals(marsRover.getRoverX(), 4);
    }
    @Test
    public void rover_returns_to_endMapX_if_is_at_initOfMapX() throws Exception {
        var initialOrientation = Orientation.EAST;
        var map = new Field(4,4);
        var initialCoordinates = new CoordinateSystem(0,0, map);


        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.moveBackwards();
        Assert.assertEquals(marsRover.getRoverY(), 0);
        Assert.assertEquals(marsRover.getRoverX(), 4);
    }
    @Test
    public void rover_returns_to_endMapY_if_is_at_initOfMapY() throws Exception {
        var initialOrientation = Orientation.NORTH;
        var map = new Field(4,4);
        var initialCoordinates = new CoordinateSystem(0,0, map);


        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.moveBackwards();
        Assert.assertEquals(marsRover.getRoverY(), 4);
        Assert.assertEquals(marsRover.getRoverX(), 0);
    }

}