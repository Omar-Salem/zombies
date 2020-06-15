package org.omarsalem.zombies.models;

import lombok.Data;

import java.util.List;

@Data
public class SimulationResult {
    private final int score;
    private final List<Cordinates> zombiePositions;

    @Override
    public String toString() {
        return
                "zombies score:" + score +
                        "\nzombies positions:" + zombiePositions;
    }
}
