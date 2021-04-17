package com.wallapop.marsRover.domain.Repository;

import com.wallapop.marsRover.domain.MarsRover;
import com.wallapop.marsRover.domain.MarsRoverId;

public interface MarsRoverRepository {
    public MarsRover getMarsRover(MarsRoverId Id);
    public void saveMarsRover(MarsRover marsRover);
    public void updateMarsRover(MarsRover marsRover);
}
