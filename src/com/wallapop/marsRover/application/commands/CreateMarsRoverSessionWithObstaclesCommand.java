package com.wallapop.marsRover.application.commands;

public class CreateMarsRoverSessionWithObstaclesCommand {
    public int sizeMapX;
    public int sizeMapY;
    public String initialOrientation;
    public int initialPositionX;
    public int initialPositionY;

    public CreateMarsRoverSessionWithObstaclesCommand(
            int sizeMapX,
            int sizeMapY,
            String initialOrientation,
            int initialPositionX,
            int initialPositionY
    ) {
        this.initialOrientation = initialOrientation;
        this.initialPositionX = initialPositionX;
        this.initialPositionY = initialPositionY;
        this.sizeMapX = sizeMapX;
        this.sizeMapY = sizeMapY;
    }

}
