package com.wallapop.Tests.domain;

import com.wallapop.marsRover.domain.*;
import org.junit.Test;
import org.testng.Assert;

public class TestCoordinatesMovement {

    @Test
    public void rover_moves_positive_onXCoordinates() throws Exception {
        var initialOrientation = Orientation.EAST;
        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(1,1);

        var marsRover = MarsRoverFactory.build(initialOrientation,sizeField, initialCoordinate);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverX(), 2);
    }

    @Test
    public void rover_moves_negative_onXCoordinates() throws Exception {
        var initialOrientation = Orientation.WEST;
        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(1,1);

        var marsRover = MarsRoverFactory.build(initialOrientation,sizeField, initialCoordinate);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverX(), 0);
    }

    @Test
    public void rover_moves_positive_onYCoordinates() throws Exception {
        var initialOrientation = Orientation.NORTH;

        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(1,1);

        var marsRover = MarsRoverFactory.build(initialOrientation,sizeField, initialCoordinate);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverY(), 2);
    }

    @Test
    public void rover_moves_negative_onYCoordinates() throws Exception {
        var initialOrientation = Orientation.SOUTH;

        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(1,1);

        var marsRover = MarsRoverFactory.build(initialOrientation,sizeField, initialCoordinate);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverY(), 0);
    }

}