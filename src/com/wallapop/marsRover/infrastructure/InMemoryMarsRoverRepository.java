package com.wallapop.marsRover.infrastructure;

import com.wallapop.marsRover.domain.MarsRover;
import com.wallapop.marsRover.domain.MarsRoverId;
import com.wallapop.marsRover.domain.Repository.MarsRoverRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class InMemoryMarsRoverRepository implements MarsRoverRepository {
    private Collection<MarsRover> marsRovers;

    public InMemoryMarsRoverRepository(){
        this.marsRovers = new ArrayList<>();
    }

    @Override
    public MarsRover getMarsRover(MarsRoverId id) {
        var marsRover= this.marsRovers.stream().filter(item -> id.equals(item.getID()))
                .findAny()
                .orElse(null);
        if(marsRover == null) throw new NullPointerException();
        return marsRover;
    }

    @Override
    public void saveMarsRover(MarsRover marsRover) {
        marsRovers.add(marsRover);
    }
}
