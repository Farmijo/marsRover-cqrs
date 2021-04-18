package com.wallapop.Tests.domain;

import com.wallapop.marsRover.domain.Coordinate;
import com.wallapop.marsRover.domain.CoordinateSystem;
import com.wallapop.marsRover.domain.Field;
import com.wallapop.marsRover.domain.Orientation;
import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;

import static org.junit.Assert.assertThrows;

public class TestInitialConditions {

    @Test(expected = IllegalArgumentException.class)
    public void cannotInit_if_initPosition_IsOutsideBoundaries() throws Exception {
        var initialOrientation = Orientation.EAST;
        var map = new Field.Builder(4, 4).build();
        var initialCoordinates = new CoordinateSystem(6, 1, map);
    }
    @Test(expected = IllegalArgumentException.class)
    public void cannotInit_if_initPosition_IsOnObstacle() throws Exception {
        var initialOrientation = Orientation.EAST;
        var list = new ArrayList<Coordinate>();
        var obstacle = new Coordinate(2, 1);
        list.add(obstacle);
        var map = new Field.Builder(4, 4).addObstacles(list).build();
        var initialCoordinates = new CoordinateSystem(2, 1, map);
    }
}
