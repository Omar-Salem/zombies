package org.omarsalem.zombies;

import lombok.Data;

import java.awt.*;
import java.util.List;

@Data
public class SimulationResult {
    private int score;
    private List<Point> zombiePositions;
}
