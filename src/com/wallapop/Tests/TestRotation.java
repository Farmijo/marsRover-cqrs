package com.wallapop.Tests;

import com.wallapop.marsRover.domain.*;
import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestRotation {

    @Test
    public void rotateToLeft_beingOnEast_endsOnNorth() throws Exception {
        var initialOrientation = Orientation.EAST;
        var map = new Field.Builder(4, 4).build();
        var initialCoordinates = new CoordinateSystem(1, 1, map);

        var id = new MarsRoverId(UUID.randomUUID());
        var marsRover = new MarsRover(id, initialCoordinates, initialOrientation);

        marsRover.rotateLeft();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.NORTH);
    }

    @Test
    public void rotateToLeft_beingOnNorth_endsOnWest() throws Exception {
        var initialOrientation = Orientation.NORTH;
        var map = new Field.Builder(4, 4).build();
        var initialCoordinates = new CoordinateSystem(1, 1, map);

        var id = new MarsRoverId(UUID.randomUUID());
        var marsRover = new MarsRover(id, initialCoordinates, initialOrientation);

        marsRover.rotateLeft();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.WEST);
    }

    @Test
    public void rotateToLeft_beingOnWest_endsOnSouth() throws Exception {
        var initialOrientation = Orientation.WEST;
        var map = new Field.Builder(4, 4).build();
        var initialCoordinates = new CoordinateSystem(1, 1, map);

        var id = new MarsRoverId(UUID.randomUUID());
        var marsRover = new MarsRover(id, initialCoordinates, initialOrientation);

        marsRover.rotateLeft();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.SOUTH);
    }

    @Test
    public void rotateToLeft_beingOnSouth_endsOnWest() throws Exception {
        var initialOrientation = Orientation.SOUTH;
        var map = new Field.Builder(4, 4).build();
        var initialCoordinates = new CoordinateSystem(1, 1, map);

        var id = new MarsRoverId(UUID.randomUUID());
        var marsRover = new MarsRover(id, initialCoordinates, initialOrientation);

        marsRover.rotateLeft();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.EAST);
    }

    @Test
    public void rotateToRight_beingOnSouth_endsOnWest() throws Exception {
        var initialOrientation = Orientation.SOUTH;
        var map = new Field.Builder(4, 4).build();
        var initialCoordinates = new CoordinateSystem(1, 1, map);

        var id = new MarsRoverId(UUID.randomUUID());
        var marsRover = new MarsRover(id, initialCoordinates, initialOrientation);

        marsRover.rotateRight();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.WEST);
    }

    @Test
    public void rotateToRight_beingOnWest_endsOnNorth() throws Exception {
        var initialOrientation = Orientation.WEST;
        var map = new Field.Builder(4, 4).build();
        var initialCoordinates = new CoordinateSystem(1, 1, map);

        var id = new MarsRoverId(UUID.randomUUID());
        var marsRover = new MarsRover(id, initialCoordinates, initialOrientation);

        marsRover.rotateRight();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.NORTH);
    }

    @Test
    public void rotateToRight_beingOnNorth_endsOnEast() throws Exception {
        var initialOrientation = Orientation.NORTH;
        var map = new Field.Builder(4, 4).build();
        var initialCoordinates = new CoordinateSystem(1, 1, map);

        var id = new MarsRoverId(UUID.randomUUID());
        var marsRover = new MarsRover(id, initialCoordinates, initialOrientation);

        marsRover.rotateRight();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.EAST);
    }

    @Test
    public void rotateToRight_beingOnEast_endsOnSouth() throws Exception {
        var initialOrientation = Orientation.EAST;
        var map = new Field.Builder(4, 4).build();
        var initialCoordinates = new CoordinateSystem(1, 1, map);

        var id = new MarsRoverId(UUID.randomUUID());
        var marsRover = new MarsRover(id, initialCoordinates, initialOrientation);

        marsRover.rotateRight();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.SOUTH);
    }

}