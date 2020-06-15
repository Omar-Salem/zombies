package org.omarsalem.zombies;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SimulatorTest {

    private final Simulator target = new Simulator();

    @Test
    public void run_edgeMovementHorizontal() {
        //Arrange
        final int dimension = 10;
        final Point zombiePosition = new Point(0, 4);
        final String moves = "L";

        //Act
        final SimulationResult simulationResult = target.run(dimension,
                zombiePosition,
                new Point[0],
                moves);

        //Assert
        assertEquals(new Point(9, 4), simulationResult.getZombiePositions().get(0));
    }

    @Test
    public void run_edgeMovementVertical() {
        //Arrange
        final int dimension = 10;
        final Point zombiePosition = new Point(3, 9);
        final String moves = "D";

        //Act
        final SimulationResult simulationResult = target.run(dimension,
                zombiePosition,
                new Point[0],
                moves);

        //Assert
        assertEquals(new Point(3, 0), simulationResult.getZombiePositions().get(0));
    }

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