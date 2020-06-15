package org.omarsalem.zombies;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.omarsalem.zombies.core.Simulator;
import org.omarsalem.zombies.models.Cordinates;
import org.omarsalem.zombies.models.SimulationInput;
import org.omarsalem.zombies.models.SimulationResult;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SimulatorTest {

    private final Simulator target = new Simulator();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void run_edgeMovementHorizontal() {
        //Arrange
        final SimulationInput simulationInput = new SimulationInput();
        simulationInput.setDimension(10);
        simulationInput.setInitialPosition(new Cordinates(0, 4));
        simulationInput.setMove("L");

        //Act
        final SimulationResult simulationResult = target.run(simulationInput);

        //Assert
        assertEquals(new Cordinates(9, 4), simulationResult.getZombiePositions().get(0));
    }

    @Test
    public void run_edgeMovementVertical() {
        //Arrange
        final SimulationInput simulationInput = new SimulationInput();
        simulationInput.setDimension(10);
        simulationInput.setInitialPosition(new Cordinates(3, 9));
        simulationInput.setMove("D");

        //Act
        final SimulationResult simulationResult = target.run(simulationInput);

        //Assert
        assertEquals(new Cordinates(3, 0), simulationResult.getZombiePositions().get(0));
    }

    @Test
    public void run() throws IOException {
        //Arrange
        final String json = IOUtils
                .toString(this.getClass().getResourceAsStream("/input.json"),
                        Charset.defaultCharset());
        final SimulationInput simulationInput = objectMapper.readValue(json, SimulationInput.class);


        //Act
        final SimulationResult simulationResult = target.run(simulationInput);

        //Assert
        assertEquals(3, simulationResult.getScore());
        final Cordinates[] expected = {new Cordinates(3, 0),
                new Cordinates(2, 1),
                new Cordinates(1, 0),
                new Cordinates(0, 0)};
        final Cordinates[] actual = simulationResult.getZombiePositions().toArray(new Cordinates[0]);
        assertArrayEquals(expected, actual);
    }
}