package com.wallapop.marsRover.application.commands;

import com.wallapop.marsRover.domain.MarsRoverId;

import java.util.UUID;

public class MarsRoverMoveForwardCommand extends MarsRoverActionCommand {
    public MarsRoverMoveForwardCommand(UUID id) {
        super(id);
        action = Action.MOVE_FORWARD;
    }
}
