package com.wallapop.marsRover.application.commands;

public class CreateMarsRoverSessionCommand {
    public int sizeMapX;
    public int sizeMapY;
    public String initialOrientation;
    public int initialPositionX;
    public int initialPositionY;

    public CreateMarsRoverSessionCommand(
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
