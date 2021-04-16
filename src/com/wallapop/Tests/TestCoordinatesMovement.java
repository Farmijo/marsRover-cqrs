package com.wallapop.Tests;

import com.wallapop.marsRover.domain.CoordinateSystem;
import com.wallapop.marsRover.domain.Field;
import com.wallapop.marsRover.domain.MarsRover;
import com.wallapop.marsRover.domain.Orientation;
import org.testng.Assert;
import org.junit.Test;

public class TestCoordinatesMovement {

    @Test
    public void rover_moves_positive_onXCoordinates() throws Exception {
        var initialOrientation = Orientation.EAST;

        var map = new Field(4,4);
        var initialCoordinates = new CoordinateSystem(1,1, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverX(), 2);
    }
    @Test
    public void rover_moves_negative_onXCoordinates() throws Exception {
        var initialOrientation = Orientation.WEST;

        var map = new Field(4,4);
        var initialCoordinates = new CoordinateSystem(1,1, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverX(), 0);
    }
    @Test
    public void rover_moves_positive_onYCoordinates() throws Exception {
        var initialOrientation = Orientation.NORTH;

        var map = new Field(4,4);
        var initialCoordinates = new CoordinateSystem(1,1, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverY(), 2);
    }
    @Test
    public void rover_moves_negative_onYCoordinates() throws Exception {
        var initialOrientation = Orientation.SOUTH;

        var map = new Field(4,4);
        var initialCoordinates = new CoordinateSystem(1,1, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverY(), 0);
    }

}