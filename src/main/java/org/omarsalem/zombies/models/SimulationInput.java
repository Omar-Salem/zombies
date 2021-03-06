package org.omarsalem.zombies.models;

import lombok.Data;

import java.util.Set;

@Data
public class SimulationInput {
    private int dimension;
    private Cordinates initialPosition;
    private Set<Cordinates> creaturesPositions;
    private String move;
}
