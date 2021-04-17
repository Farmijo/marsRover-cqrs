package com.wallapop.marsRover.application.commands;

import java.util.UUID;

public class MarsRoverRotationRightCommand extends MarsRoverActionCommand {
    public MarsRoverRotationRightCommand(UUID id) {
        super(id);
        action = Action.ROTATE_RIGHT;
    }
}
