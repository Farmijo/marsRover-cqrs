package com.wallapop.Tests.domain;

import com.wallapop.marsRover.domain.*;

import java.util.ArrayList;

public class MarsRoverFactory {

    public static MarsRover build(Orientation orientation, Coordinate sizeField,Coordinate initialCoordinate){
        var map = new Field.Builder(sizeField.getCoordinateX(), sizeField.getCoordinateY()).build();
        var orientationSystem = new OrientationSystem(orientation);
        var coordinateSystem = new CoordinateSystem(initialCoordinate.getCoordinateX(), initialCoordinate.getCoordinateY(), map );
        return new MarsRover(coordinateSystem, orientationSystem);
    }

    public static MarsRover buildOnFieldWithObstacles(Orientation orientation, Coordinate sizeField, Coordinate initialCoordinate, ArrayList<Coordinate> obstacles){
        var map = new Field.Builder(sizeField.getCoordinateX(), sizeField.getCoordinateY()).addObstacles(obstacles).build();
        var orientationSystem = new OrientationSystem(orientation);
        var coordinateSystem = new CoordinateSystem(initialCoordinate.getCoordinateX(), initialCoordinate.getCoordinateY(), map );
        return new MarsRover(coordinateSystem, orientationSystem);
    }

}
