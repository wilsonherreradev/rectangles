package com.rectangle.operators;

import com.rectangle.entities.Line;
import com.rectangle.entities.Rectangle;

import com.rectangle.entities.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * A set of operations to be performed over Rectangle objects
 *
 * @author      Wilson Herrera
 * @since       1.0
 */
public class RectangleOperator {

    /**
     * Returns a list of points where the 2 rectangles intersection
     * if not intersection, returns an empty list
     *
     * @param rectangleOne
     * @param rectangleTwo
     * @return
     */
    public List<Point> getIntersectionPoints(Rectangle rectangleOne, Rectangle rectangleTwo){
        List<Point> intersectionPoints = new ArrayList<>();
        for(Line rectangleOneLine : rectangleOne.getAllLines()){
            for(Line rectangleTwoLine : rectangleTwo.getAllLines()){
                Point intersectPoint = getIntersectionBetweenLines(rectangleOneLine, rectangleTwoLine);
                if(intersectPoint != null) intersectionPoints.add(intersectPoint);
            }
        }
        return intersectionPoints;
    }

    /**
     * Compares 2 lines and if they are not in the same orientation (Horizontal or vertical) return the intersection
     * if exists, else return null
     *
     * @param lineA
     * @param lineB
     * @return
     */
    public Point getIntersectionBetweenLines(Line lineA, Line lineB){
        if(lineA.isHorizontal() && lineB.isVertical())
            return doLinesIntersect(lineA, lineB) ? new Point(lineB.getPointA().x, lineA.getPointA().y) : null;

        if(lineA.isVertical() && lineB.isHorizontal())
            return doLinesIntersect(lineB, lineA) ? new Point(lineA.getPointA().x, lineB.getPointA().y) : null;

        return null;
    }

    /**
     * return true if the lines intersects
     *
     * @param lineA
     * @param lineB
     * @return
     */
    public boolean doLinesIntersect(Line lineA, Line lineB){
        int maxX = Math.max(lineA.getPointA().x, lineA.getPointB().x);
        int minX = Math.min(lineA.getPointA().x, lineA.getPointB().x);
        int maxY = Math.max(lineB.getPointA().y, lineB.getPointB().y);
        int minY = Math.min(lineB.getPointA().y, lineB.getPointB().y);
        return maxX > lineB.getPointA().x && minX < lineB.getPointA().x &&
                maxY > lineA.getPointA().y && minY < lineA.getPointA().y  ;
    }

    /**
     * returns true if the first rectangle contains the second one
     *
     * @param container
     * @param contained
     * @return
     */
    public boolean isContained(Rectangle container, Rectangle contained){
        return container.getUpperLeft().x <= contained.getUpperLeft().x &&
                container.getUpperLeft().y >= contained.getUpperLeft().y &&
                container.getUpperRight().x >= contained.getUpperRight().x &&
                container.getUpperRight().y >= contained.getUpperRight().y &&
                container.getLoweLeft().x <= contained.getLoweLeft().x &&
                container.getLoweLeft().y <= contained.getLoweLeft().y &&
                container.getLowerRight().x >= contained.getLowerRight().x &&
                container.getLowerRight().y <= contained.getLowerRight().y;
    }

    /**
     * Compares the 4 lines of the first rectangle with the 4 of the second
     * @param rectangleOne
     * @param rectangleTwo
     * @return the adjacent lines
     */
    public List<String> getAdjacentLines(Rectangle rectangleOne, Rectangle rectangleTwo){
        List<String> adjacentLines = new ArrayList<>();
        for(Line rectangleOneLine : rectangleOne.getAllLines()){
            for(Line rectangleTwoLine : rectangleTwo.getAllLines()){
                String isAdjacent = getAdjacentDescriptionIfAdjacent(rectangleOneLine, rectangleTwoLine);
                if(isAdjacent != null) adjacentLines.add(isAdjacent);
            }
        }
        return adjacentLines;
    }

    /**
     * check if the lines have the same orientation Horizontal or vertical
     * @param lineA
     * @param lineB
     * @return description of the adjacent line if adjacent
     */
    public String getAdjacentDescriptionIfAdjacent(Line lineA, Line lineB){
        if(lineA.isHorizontal() && lineB.isHorizontal() && lineA.getPointA().y == lineB.getPointA().y ){
            return getAdjacentMessage(lineA, lineB, lineA.getPointA().x, lineA.getPointB().x,
                    lineB.getPointA().x, lineB.getPointB().x);
        }
        if(lineA.isVertical() && lineB.isVertical() && lineA.getPointA().x == lineB.getPointA().x){
            return getAdjacentMessage(lineA, lineB, lineA.getPointA().y, lineA.getPointB().y,
                    lineB.getPointA().y, lineB.getPointB().y);
        }
        return null;
    }

    /**
     * checks if 2 lines are adjacent and return the type of adjacency if adjacent
     * @param lineA
     * @param lineB
     * @param lineAInit
     * @param lineAEnd
     * @param lineBInit
     * @param lineBEnd
     * @return
     */
    public String getAdjacentMessage(Line lineA, Line lineB, int lineAInit, int lineAEnd, int lineBInit, int lineBEnd){
        if(lineAEnd < lineBInit && lineAInit > lineBEnd)
            return null;

        if(lineAInit == lineBInit && lineAEnd == lineBEnd )
            return "Proper adjacent: Rectangle A " + lineA + " rectangle B "+ lineB;

        if(lineAInit >= lineBInit && lineAEnd <= lineBEnd )
            return "Rectangle A " + lineA + " is Sub-line of rectangle B "+ lineB;

        if(lineBInit >= lineAInit && lineBEnd <= lineAEnd )
            return "Rectangle B " + lineB + " is Sub-line of rectangle A "+ lineA;

        if((lineAInit < lineBInit && lineAEnd > lineBInit) ||
                (lineAInit < lineBEnd && lineAEnd > lineBEnd) )
            return "Partial adjacent: Rectangle A " + lineA + " rectangle B "+ lineB;
        return null;
    }

}
