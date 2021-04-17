package com.wallapop.Tests;

import com.wallapop.marsRover.domain.*;
import org.junit.Test;
import org.testng.Assert;

import java.util.UUID;

public class TestCoordinatesMovement {

    @Test
    public void rover_moves_positive_onXCoordinates() throws Exception {
        var initialOrientation = Orientation.EAST;

        var map = new Field.Builder(4, 4).build();

        var initialCoordinates = new CoordinateSystem(1, 1, map);
        var id = new MarsRoverId(UUID.randomUUID());
        var marsRover = new MarsRover(id, initialCoordinates, initialOrientation);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverX(), 2);
    }

    @Test
    public void rover_moves_negative_onXCoordinates() throws Exception {
        var initialOrientation = Orientation.WEST;

        var map = new Field.Builder(4, 4).build();
        var initialCoordinates = new CoordinateSystem(1, 1, map);

        var id = new MarsRoverId(UUID.randomUUID());
        var marsRover = new MarsRover(id, initialCoordinates, initialOrientation);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverX(), 0);
    }

    @Test
    public void rover_moves_positive_onYCoordinates() throws Exception {
        var initialOrientation = Orientation.NORTH;

        var map = new Field.Builder(4, 4).build();
        var initialCoordinates = new CoordinateSystem(1, 1, map);

        var id = new MarsRoverId(UUID.randomUUID());
        var marsRover = new MarsRover(id, initialCoordinates, initialOrientation);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverY(), 2);
    }

    @Test
    public void rover_moves_negative_onYCoordinates() throws Exception {
        var initialOrientation = Orientation.SOUTH;

        var map = new Field.Builder(4, 4).build();
        var initialCoordinates = new CoordinateSystem(1, 1, map);

        var id = new MarsRoverId(UUID.randomUUID());
        var marsRover = new MarsRover(id, initialCoordinates, initialOrientation);

        marsRover.moveForward();
        Assert.assertEquals(marsRover.getRoverY(), 0);
    }

}