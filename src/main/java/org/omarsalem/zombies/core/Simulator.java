package org.omarsalem.zombies.core;

import org.omarsalem.zombies.models.Cordinates;
import org.omarsalem.zombies.models.SimulationInput;
import org.omarsalem.zombies.models.SimulationResult;

import java.util.*;

public class Simulator {
    public SimulationResult run(SimulationInput simulationInput) {
        int score = 0;
        final ArrayList<Cordinates> zombiePositions = new ArrayList<>();
        Queue<Cordinates> infected = new LinkedList<>();
        infected.add(simulationInput.getInitialPosition());
        char[] charArray = simulationInput.getMove().toCharArray();
        final int dimension = simulationInput.getDimension();
        final Set<Cordinates> creaturesPositions = simulationInput.getCreaturesPositions();

        while (!infected.isEmpty()) {
            Cordinates zombiePosition = ((LinkedList<Cordinates>) infected).pop();

            for (int i = 0; i < charArray.length; i++) {
                char heading = charArray[i];
                zombiePosition = getNewPosition(dimension,
                        heading,
                        zombiePosition.getX(),
                        zombiePosition.getY());

                if (creaturesPositions != null) {
                    Cordinates finalZombiePosition = zombiePosition;
                    final Optional<Cordinates> potentialInfection = creaturesPositions
                            .stream()
                            .filter(p -> p.equals(finalZombiePosition))
                            .findAny();

                    if (potentialInfection.isPresent()) {
                        score++;
                        final Cordinates infection = potentialInfection.get();
                        infected.add(infection);
                        creaturesPositions.remove(infection);
                    }
                }
                if (charArray.length - 1 == i) {
                    zombiePositions.add(zombiePosition);
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
