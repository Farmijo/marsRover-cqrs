package com.wallapop.Tests;

import com.wallapop.marsRover.domain.*;
import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class TestObstacles {

    @Test
    public void obstacles_are_added_to_map() throws Exception {
        var initialOrientation = Orientation.EAST;
        var list = new ArrayList<Coordinate>();
        var obstacle = new Coordinate(2, 1);
        list.add(obstacle);
        var map = new Field.Builder(4, 4).addObstacles(list).build();
        var cointainsObstacle = map.getObstaclePositions().contains(obstacle);
        Assert.assertEquals(cointainsObstacle, true);
    }
    @Test
    public void cannot_move_to_nonEmpty_coordinate_onXAxis() throws Exception {
        var initialOrientation = Orientation.EAST;
        var list = new ArrayList<Coordinate>();
        var obstacle = new Coordinate(2, 1);
        list.add(obstacle);
        var map = new Field.Builder(4, 4).addObstacles(list).build();

        var initialCoordinates = new CoordinateSystem(1, 1, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.moveForward();

        Assert.assertEquals(marsRover.getRoverX(), 1);
    }
    @Test
    public void cannot_move_to_nonEmpty_coordinate_onYAxis() throws Exception {
        var initialOrientation = Orientation.NORTH;
        var list = new ArrayList<Coordinate>();
        var obstacle = new Coordinate(1, 2);
        list.add(obstacle);
        var map = new Field.Builder(4, 4).addObstacles(list).build();
        var initialCoordinates = new CoordinateSystem(1, 1, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.moveForward();

        Assert.assertEquals(marsRover.getRoverY(), 1);
    }
    @Test
    public void cannot_move_to_nonEmpty_coordinate_onYAxis_negativeDirection() throws Exception {
        var initialOrientation = Orientation.NORTH;
        var list = new ArrayList<Coordinate>();
        var obstacle = new Coordinate(1, 0);
        list.add(obstacle);
        var map = new Field.Builder(4, 4).addObstacles(list).build();
        var initialCoordinates = new CoordinateSystem(1, 1, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.moveBackwards();

        Assert.assertEquals(marsRover.getRoverY(), 1);
    }
    @Test
    public void cannot_move_to_nonEmpty_coordinate_onXAxis_negativeDirection() throws Exception {
        var initialOrientation = Orientation.EAST;
        var list = new ArrayList<Coordinate>();
        var obstacle = new Coordinate(0, 0);
        list.add(obstacle);
        var map = new Field.Builder(4, 4).addObstacles(list).build();
        var initialCoordinates = new CoordinateSystem(1, 0, map);

        var marsRover = new MarsRover(initialCoordinates, initialOrientation);

        marsRover.moveBackwards();

        Assert.assertEquals(marsRover.getRoverX(), 1);
    }
}