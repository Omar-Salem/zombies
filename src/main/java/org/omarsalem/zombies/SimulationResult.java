package org.omarsalem.zombies;

import lombok.Data;

import java.awt.*;
import java.util.List;

@Data
class SimulationResult {
    private final int score;
    private final List<Point> zombiePositions;
}
