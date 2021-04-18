package com.wallapop.Tests.domain;

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
        var containsObstacle = map.getObstaclePositions().contains(obstacle);
        Assert.assertEquals(containsObstacle, true);
    }
    @Test
    public void cannot_move_to_nonEmpty_coordinate_onXAxis() throws Exception {
        var initialOrientation = Orientation.EAST;

        var list = new ArrayList<Coordinate>();
        var obstacle = new Coordinate(2, 1);
        list.add(obstacle);

        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(1,1);
        var marsRover = MarsRoverFactory.buildOnFieldWithObstacles(initialOrientation,sizeField, initialCoordinate, list);

        marsRover.moveForward();

        Assert.assertEquals(marsRover.getRoverX(), 1);
    }
    @Test
    public void cannot_move_to_nonEmpty_coordinate_onYAxis() throws Exception {
        var initialOrientation = Orientation.NORTH;
        var list = new ArrayList<Coordinate>();
        var obstacle = new Coordinate(1, 2);
        list.add(obstacle);

        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(1,1);
        var marsRover = MarsRoverFactory.buildOnFieldWithObstacles(initialOrientation,sizeField, initialCoordinate, list);

        marsRover.moveForward();

        Assert.assertEquals(marsRover.getRoverY(), 1);
    }
    @Test
    public void cannot_move_to_nonEmpty_coordinate_onYAxis_negativeDirection() throws Exception {
        var initialOrientation = Orientation.NORTH;
        var list = new ArrayList<Coordinate>();
        var obstacle = new Coordinate(1, 0);
        list.add(obstacle);

        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(1,1);
        var marsRover = MarsRoverFactory.buildOnFieldWithObstacles(initialOrientation,sizeField, initialCoordinate, list);

        marsRover.moveBackwards();

        Assert.assertEquals(marsRover.getRoverY(), 1);
    }
    @Test
    public void cannot_move_to_nonEmpty_coordinate_onXAxis_negativeDirection() throws Exception {
        var initialOrientation = Orientation.EAST;
        var list = new ArrayList<Coordinate>();
        var obstacle = new Coordinate(0, 0);
        list.add(obstacle);

        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(1,0);
        var marsRover = MarsRoverFactory.buildOnFieldWithObstacles(initialOrientation,sizeField, initialCoordinate, list);

        marsRover.moveBackwards();

        Assert.assertEquals(marsRover.getRoverX(), 1);
    }
}