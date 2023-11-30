package com.rectangle.entities;

/**
 * A point representing a location in {@code (x,y)} coordinate space,
 * specified in integer precision.
 *
 * @author      Wilson Herrera
 * @since       1.0
 */
public class Point extends java.awt.Point {
    public Point(int x, int y) {
        super(x, y);
    }

    public Point() {
    }

    @Override
    public String toString() {
        return "[" + x + "," + y +']';
    }
}
