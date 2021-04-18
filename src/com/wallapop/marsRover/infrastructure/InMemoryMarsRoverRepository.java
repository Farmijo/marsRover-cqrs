package com.wallapop.marsRover.infrastructure;

import com.wallapop.marsRover.domain.MarsRover;
import com.wallapop.marsRover.domain.MarsRoverRepository;

public class InMemoryMarsRoverRepository implements MarsRoverRepository {
    MarsRover marsRover;
    @Override
    public MarsRover getMarsRover() {
        return marsRover;
    }

    @Override
    public void saveMarsRover(MarsRover marsRover) {
        this.marsRover = marsRover;
    }
}
