package com.wallapop.marsRover;

import com.wallapop.marsRover.domain.CoordinateSystem;
import com.wallapop.marsRover.domain.Field;
import com.wallapop.marsRover.domain.MarsRover;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Insert horizontal map size:");
        int sizex = reader.nextInt();

        System.out.println("Insert vertical map size:");
        int sizey = reader.nextInt();

        System.out.println("Insert horizontal initial rover position:");
        int roverx = reader.nextInt();

        System.out.println("Insert vertical initial rover position:");
        int rovery = reader.nextInt();

        System.out.println("Insert initial rover direction:");
        String roverz = reader.next(); //n = north, e = east, w = west, s = south

        var map = new Field(sizex, sizey);
        var initialOrientation = OrientationBuilder.buildOrientation(roverz);
        var initialCoordinate = new CoordinateSystem(roverx, rovery, map);

        MarsRover rover = new MarsRover(initialCoordinate, initialOrientation);

        do {
            System.out.println("Insert command (f = forward, b = backward, l = turn left, r = turn right):");
            String command = reader.next();

            if(command.equals("l")) rover.rotateLeft();
            if(command.equals("r")) rover.rotateRight();
            if(command.equals("f")) rover.moveForward();
            if(command.equals("b")) rover.moveBackwards();


            System.out.println(String.format("Rover is at x:%d y:%d facing:%s", rover.getRoverX(), rover.getRoverY(), rover.getOrientation().name()));
        } while (true);
    }
}
