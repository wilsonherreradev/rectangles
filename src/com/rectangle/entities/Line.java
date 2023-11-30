package com.rectangle.entities;

/**
 * A line in the Castesian plane. it has two points
 *
 * @author      Wilson Herrera
 * @since       1.0
 */
public class Line {
    private Point pointA;
    private Point pointB;

    public Line(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    @Override
    public String toString() {
        return "Line(" + pointA + "," + pointB + ")";
    }

    public boolean isHorizontal(){
        return pointA.getY() == pointB.getY();
    }

    public boolean isVertical(){
        return pointA.getX() == pointB.getX();
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }
}
