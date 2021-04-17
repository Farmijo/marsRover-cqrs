package com.wallapop.marsRover.application.commands;

import com.wallapop.marsRover.domain.MarsRoverId;

import java.util.UUID;

public class MarsRoverRotationLeftCommand extends MarsRoverActionCommand {
    public MarsRoverRotationLeftCommand(UUID id) {
        super(id);
        action = Action.ROTATE_LEFT;
    }
}
