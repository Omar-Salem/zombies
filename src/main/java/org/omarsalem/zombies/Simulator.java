package org.omarsalem.zombies;

import java.awt.*;
import java.util.ArrayList;

class Simulator {
    SimulationResult run(int dimension,
                         Point zombiePosition,
                         Point[] creaturesPositions,
                         String moves) {
        int score = 0;
        int currentX = zombiePosition.x;
        int currentY = zombiePosition.y;
        final ArrayList<Point> zombiePositions = new ArrayList<>();
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    currentY--;
                    if (currentY < 0) {
                        currentY += 10;
                    }
                    break;
                case 'D':
                    currentY++;
                    break;
                case 'L':
                    currentX--;
                    if (currentX < 0) {
                        currentX += 10;
                    }
                    break;
                case 'R':
                    currentX++;
                    break;
            }
            currentX %= 10;
            currentY %= 10;
            zombiePositions.add(new Point(currentX, currentY));
        }
        return new SimulationResult(score, zombiePositions);
    }
}
