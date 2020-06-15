package org.omarsalem.zombies;

import lombok.Data;

@Data
public class Cordinates {
    private int x;
    private int y;

    public Cordinates() {
    }

    public Cordinates(int currentX, int currentY) {
        this.x = currentX;
        this.y = currentY;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", x, y);
    }
}
