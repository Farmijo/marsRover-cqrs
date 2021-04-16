package com.wallapop.Tests;

import com.wallapop.marsRover.domain.CoordinateSystem;
import com.wallapop.marsRover.domain.Field;
import com.wallapop.marsRover.domain.MarsRover;
import com.wallapop.marsRover.domain.Orientation;
import org.testng.Assert;
import org.junit.Test;

public class TestRotation {

    @Test
    public void rotateToLeft_beingOnEast_endsOnNorth() throws Exception {
        var initialOrientation = Orientation.EAST;
        var map = new Field(4,4);
        var initialCoordinates = new CoordinateSystem(1,1, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.rotateLeft();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.NORTH);
    }
    @Test
    public void rotateToLeft_beingOnNorth_endsOnWest() throws Exception {
        var initialOrientation = Orientation.NORTH;
        var map = new Field(4,4);
        var initialCoordinates = new CoordinateSystem(1,1, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.rotateLeft();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.WEST);
    }
    @Test
    public void rotateToLeft_beingOnWest_endsOnSouth() throws Exception {
        var initialOrientation = Orientation.WEST;
        var map = new Field(4,4);
        var initialCoordinates = new CoordinateSystem(1,1, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.rotateLeft();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.SOUTH);
    }
    @Test
    public void rotateToLeft_beingOnSouth_endsOnWest() throws Exception {
        var initialOrientation = Orientation.SOUTH;
        var map = new Field(4,4);
        var initialCoordinates = new CoordinateSystem(1,1, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.rotateLeft();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.EAST);
    }
    @Test
    public void rotateToRight_beingOnSouth_endsOnWest() throws Exception {
        var initialOrientation = Orientation.SOUTH;
        var map = new Field(4,4);
        var initialCoordinates = new CoordinateSystem(1,1, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.rotateRight();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.WEST);
    }
    @Test
    public void rotateToRight_beingOnWest_endsOnNorth() throws Exception {
        var initialOrientation = Orientation.WEST;
        var map = new Field(4,4);
        var initialCoordinates = new CoordinateSystem(1,1, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.rotateRight();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.NORTH);
    }
    @Test
    public void rotateToRight_beingOnNorth_endsOnEast() throws Exception {
        var initialOrientation = Orientation.NORTH;
        var map = new Field(4,4);
        var initialCoordinates = new CoordinateSystem(1,1, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.rotateRight();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.EAST);
    }
    @Test
    public void rotateToRight_beingOnEast_endsOnSouth() throws Exception {
        var initialOrientation = Orientation.EAST;
        var map = new Field(4,4);
        var initialCoordinates = new CoordinateSystem(1,1, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.rotateRight();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.SOUTH);
    }

}