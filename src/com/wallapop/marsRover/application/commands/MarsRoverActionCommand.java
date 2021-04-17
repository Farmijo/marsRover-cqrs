package com.wallapop.marsRover.application.commands;

import com.wallapop.marsRover.domain.MarsRoverId;

import java.util.UUID;

public abstract class MarsRoverActionCommand {
    Action action;
    public UUID id;
    public MarsRoverActionCommand(UUID id) {
        this.id = id;
    }
}

