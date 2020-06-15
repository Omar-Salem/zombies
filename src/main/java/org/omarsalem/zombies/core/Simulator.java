package org.omarsalem.zombies.core;

import org.omarsalem.zombies.models.Cordinates;
import org.omarsalem.zombies.models.SimulationInput;
import org.omarsalem.zombies.models.SimulationResult;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Simulator {
    public SimulationResult run(SimulationInput simulationInput) {
        int score = 0;
        final ArrayList<Cordinates> zombiePositions = new ArrayList<>();
        Queue<Cordinates> infected = new LinkedList<>();
        infected.add(simulationInput.getInitialPosition());
        char[] charArray = simulationInput.getMove().toCharArray();

        while (!infected.isEmpty()) {
            Cordinates zombiePosition = ((LinkedList<Cordinates>) infected).pop();
            int currentX = zombiePosition.getX();
            int currentY = zombiePosition.getY();

            for (int i = 0; i < charArray.length; i++) {
                char heading = charArray[i];
                final Cordinates newPosition = getNewPosition(simulationInput.getDimension(),
                        heading,
                        currentX,
                        currentY);
                currentX = newPosition.getX();
                currentY = newPosition.getY();
                if (simulationInput.getCreaturesPositions() != null) {
                    final Optional<Cordinates> potentialInfection = simulationInput.getCreaturesPositions()
                            .stream()
                            .filter(p -> p.equals(newPosition))
                            .findAny();

                    if (potentialInfection.isPresent()) {
                        score++;
                        final Cordinates infection = potentialInfection.get();
                        infected.add(infection);
                        simulationInput.getCreaturesPositions().remove(infection);
                    }
                }
                if (charArray.length - 1 == i) {
                    zombiePositions.add(newPosition);
                }
            }
        }

        return new SimulationResult(score, zombiePositions);
    }

    private Cordinates getNewPosition(int dimension, char heading, int currentX, int currentY) {
        switch (heading) {
            case 'U':
                currentY--;
                if (currentY < 0) {
                    currentY += dimension;
                }
                break;
            case 'D':
                currentY++;
                currentY %= dimension;
                break;
            case 'L':
                currentX--;
                if (currentX < 0) {
                    currentX += dimension;
                }
                break;
            case 'R':
                currentX++;
                currentX %= dimension;
                break;
        }
        return new Cordinates(currentX, currentY);
    }
}
