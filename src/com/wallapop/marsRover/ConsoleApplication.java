package com.wallapop.marsRover;

import com.wallapop.marsRover.application.commands.*;
import com.wallapop.marsRover.application.handlers.CreateSessionCommandHandler;
import com.wallapop.marsRover.application.handlers.MarsRoverActionCommandHandler;
import com.wallapop.marsRover.application.services.MarsRoverService;
import com.wallapop.marsRover.infrastructure.InMemoryMarsRoverRepository;

import java.util.Scanner;

public class ConsoleApplication {
    CreateSessionCommandHandler sessionCommandHandler;
    MarsRoverActionCommandHandler actionsCommandHandler;

    ConsoleApplication() {
        var repository = new InMemoryMarsRoverRepository();
        var service = new MarsRoverService(repository);
        this.sessionCommandHandler = new CreateSessionCommandHandler(service);
        this.actionsCommandHandler = new MarsRoverActionCommandHandler(service);
    }

    public void run() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Insert horizontal map size:");
        int sizex = reader.nextInt();

        System.out.println("Insert vertical map size:");
        int sizey = reader.nextInt();

        System.out.println("Insert horizontal initial rover position:");
        int roverx = reader.nextInt();

        System.out.println("Insert vertical initial rover position:");
        int rovery = reader.nextInt();

        System.out.println("Insert initial rover direction:n = north, e = east, w = west, s = south");
        String roverz = reader.next(); //n = north, e = east, w = west, s = south

        System.out.println("Do you want obstacles? (y/n)");
        String obstaclesDesired = reader.next();

        switch (obstaclesDesired) {
            case "y":
                this.sessionCommandHandler.dispatch(new CreateMarsRoverSessionWithObstaclesCommand(sizex, sizey, roverz, roverx, rovery));
                break;
            case "n":
                var sessionCreationCommand = new CreateMarsRoverSessionCommand(sizex, sizey, roverz, roverx, rovery);
                this.sessionCommandHandler.dispatch(sessionCreationCommand);
                break;
            default:
                throw new RuntimeException("Not valid answer");
        }

        do {
            System.out.println("Insert command (f = forward, b = backward, l = turn left, r = turn right):");
            String keyPress = reader.next();
            switch (keyPress) {
                case "l":
                    this.actionsCommandHandler.dispatch(new MarsRoverRotationLeftCommand());
                    break;
                case "r":
                    this.actionsCommandHandler.dispatch(new MarsRoverRotationRightCommand());
                    break;
                case "f":
                    this.actionsCommandHandler.dispatch(new MarsRoverMoveForwardCommand());
                    break;
                case "b":
                    this.actionsCommandHandler.dispatch(new MarsRoverMoveBackwardCommand());
                    break;
                default:
                    throw new RuntimeException("Not valid direction");
            }
        } while (true);
    }
}
