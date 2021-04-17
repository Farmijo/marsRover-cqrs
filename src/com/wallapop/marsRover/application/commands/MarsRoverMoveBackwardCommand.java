package com.wallapop.marsRover.application.commands;

import com.wallapop.marsRover.domain.MarsRoverId;

import java.util.UUID;

public class MarsRoverMoveBackwardCommand extends MarsRoverActionCommand {
    public MarsRoverMoveBackwardCommand(UUID id) {
        super(id);
        this.action = Action.MOVE_BACKWARD;
    }
}
