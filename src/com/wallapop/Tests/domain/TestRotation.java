package com.wallapop.Tests.domain;

import com.wallapop.marsRover.domain.*;
import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class TestRotation {

    @Test
    public void rotateToLeft_beingOnEast_endsOnNorth() throws Exception {
        var initialOrientation = Orientation.EAST;
        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(1,1);

        var marsRover = MarsRoverFactory.build(initialOrientation,sizeField, initialCoordinate);

        marsRover.rotateLeft();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.NORTH);
    }

    @Test
    public void rotateToLeft_beingOnNorth_endsOnWest() throws Exception {
        var initialOrientation = Orientation.NORTH;
        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(1,1);

        var marsRover = MarsRoverFactory.build(initialOrientation,sizeField, initialCoordinate);

        marsRover.rotateLeft();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.WEST);
    }

    @Test
    public void rotateToLeft_beingOnWest_endsOnSouth() throws Exception {
        var initialOrientation = Orientation.WEST;
        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(1,1);

        var marsRover = MarsRoverFactory.build(initialOrientation,sizeField, initialCoordinate);


        marsRover.rotateLeft();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.SOUTH);
    }

    @Test
    public void rotateToLeft_beingOnSouth_endsOnWest() throws Exception {
        var initialOrientation = Orientation.SOUTH;
        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(1,1);

        var marsRover = MarsRoverFactory.build(initialOrientation,sizeField, initialCoordinate);

        marsRover.rotateLeft();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.EAST);
    }

    @Test
    public void rotateToRight_beingOnSouth_endsOnWest() throws Exception {
        var initialOrientation = Orientation.SOUTH;
        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(1,1);

        var marsRover = MarsRoverFactory.build(initialOrientation,sizeField, initialCoordinate);

        marsRover.rotateRight();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.WEST);
    }

    @Test
    public void rotateToRight_beingOnWest_endsOnNorth() throws Exception {
        var initialOrientation = Orientation.WEST;
        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(1,1);

        var marsRover = MarsRoverFactory.build(initialOrientation,sizeField, initialCoordinate);

        marsRover.rotateRight();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.NORTH);
    }

    @Test
    public void rotateToRight_beingOnNorth_endsOnEast() throws Exception {
        var initialOrientation = Orientation.NORTH;
        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(1,1);

        var marsRover = MarsRoverFactory.build(initialOrientation,sizeField, initialCoordinate);

        marsRover.rotateRight();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.EAST);
    }

    @Test
    public void rotateToRight_beingOnEast_endsOnSouth() throws Exception {
        var initialOrientation = Orientation.EAST;
        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(1,1);

        var marsRover = MarsRoverFactory.build(initialOrientation,sizeField, initialCoordinate);

        marsRover.rotateRight();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.SOUTH);
    }

}