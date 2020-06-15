package org.omarsalem.zombies;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SimulatorTest {

    private final Simulator target = new Simulator();

    @Test
    public void run() {
        //Arrange
        final int dimension = 4;
        final Point zombiePosition = new Point(2, 1);
        final Point[] creaturesPositions = {new Point(0, 1), new Point(1, 2), new Point(3, 1)};
        final String moves = "DLUURR";

        //Act
        final SimulationResult simulationResult = target.run(dimension,
                zombiePosition,
                creaturesPositions,
                moves);

        //Assert
        assertEquals(3, simulationResult.getScore());
        final Point[] expected = {new Point(3, 0),
                new Point(2, 1),
                new Point(1, 0),
                new Point(0, 0)};
        final Point[] actual = simulationResult.getZombiePositions().toArray(new Point[0]);
        assertArrayEquals(expected, actual);
    }
}