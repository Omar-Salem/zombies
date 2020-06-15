package org.omarsalem.zombies;

import java.awt.*;
import java.util.*;
import java.util.Queue;

class Simulator {
    SimulationResult run(int dimension,
                         Point initialPosition,
                         Set<Point> creaturesPositions,
                         String moves) {
        int score = 0;
        final ArrayList<Point> zombiePositions = new ArrayList<>();
        Queue<Point> infected = new LinkedList<>();
        infected.add(initialPosition);
        char[] charArray = moves.toCharArray();

        while (!infected.isEmpty()) {
            Point zombiePosition = ((LinkedList<Point>) infected).pop();
            int currentX = zombiePosition.x;
            int currentY = zombiePosition.y;

            for (int i = 0; i < charArray.length; i++) {
                char heading = charArray[i];
                final Point newPosition = getNewPosition(dimension,
                        heading,
                        currentX,
                        currentY);
                currentX = newPosition.x;
                currentY = newPosition.y;
                final Optional<Point> potentialInfection = creaturesPositions
                        .stream()
                        .filter(p -> p.equals(newPosition))
                        .findAny();

                if (potentialInfection.isPresent()) {
                    score++;
                    infected.add(potentialInfection.get());
                    creaturesPositions.remove(potentialInfection.get());
                }
                if (charArray.length - 1 == i) {
                    zombiePositions.add(newPosition);
                }
            }
        }

        return new SimulationResult(score, zombiePositions);
    }

    private Point getNewPosition(int dimension, char heading, int currentX, int currentY) {
        switch (heading) {
            case 'U':
                currentY--;
                if (currentY < 0) {
                    currentY += dimension;
                }
                break;
            case 'D':
                currentY++;
                break;
            case 'L':
                currentX--;
                if (currentX < 0) {
                    currentX += dimension;
                }
                break;
            case 'R':
                currentX++;
                break;
        }
        currentX %= dimension;
        currentY %= dimension;
        return new Point(currentX, currentY);
    }
}
