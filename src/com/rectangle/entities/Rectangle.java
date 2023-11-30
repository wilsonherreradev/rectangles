package com.rectangle.entities;
import java.util.List;

/**
 * A Rectangle representation, it will receive 2 cartesian points and will generate the 4 vertices
 *
 * @author      Wilson Herrera
 * @since       1.0
 */
public class Rectangle {
    private Point upperLeft;
    private Point upperRight;
    private Point loweLeft;
    private Point lowerRight;

    public Rectangle(Point pointOne, Point pointTwo) {
        initializeVertices(pointOne, pointTwo);
    }

    public void initializeVertices(Point pointOne, Point pointTwo){
        int minX = Math.min(pointOne.x, pointTwo.x);
        int minY = Math.min(pointOne.y, pointTwo.y);
        int maxX = Math.max(pointOne.x, pointTwo.x);
        int maxY = Math.max(pointOne.y, pointTwo.y);
        this.upperLeft = new Point(minX, maxY);
        this.upperRight = new Point(maxX, maxY);
        this.loweLeft = new Point(minX, minY);
        this.lowerRight = new Point(maxX, minY);
    }

    public List<Point> getAllPoints(){
        return List.of(this.upperLeft, this.upperRight, this.loweLeft, this.lowerRight);
    }

    public List<Line> getAllLines(){
        return List.of(
                new Line(this.upperLeft, this.upperRight),
                new Line(this.loweLeft, this.lowerRight),
                new Line(this.lowerRight, this.upperRight),
                new Line(this.loweLeft, this.upperLeft)
                );
    }

    public Point getUpperLeft() {
        return upperLeft;
    }

    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }

    public Point getUpperRight() {
        return upperRight;
    }

    public void setUpperRight(Point upperRight) {
        this.upperRight = upperRight;
    }

    public Point getLoweLeft() {
        return loweLeft;
    }

    public void setLoweLeft(Point loweLeft) {
        this.loweLeft = loweLeft;
    }

    public Point getLowerRight() {
        return lowerRight;
    }

    public void setLowerRight(Point lowerRight) {
        this.lowerRight = lowerRight;
    }
}
