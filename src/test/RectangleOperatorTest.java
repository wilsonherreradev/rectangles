package test;
import com.rectangle.entities.Point;
import com.rectangle.entities.Rectangle;
import com.rectangle.operators.RectangleOperator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RectangleOperatorTest {

    @Test
    public void testGetIntersectionPointsWhenOneVertexInside() {
        // Given
        RectangleOperator rectangleOperator = new RectangleOperator();
        Rectangle rectangle1 = new Rectangle(new Point(1, 2), new Point(4, 4));
        Rectangle rectangle2 = new Rectangle(new Point(3, 3), new Point(6, 5));

        // When
        List<Point> intersectionPoints = rectangleOperator.getIntersectionPoints(rectangle1, rectangle2);

        // Then
        Assertions.assertEquals(2, intersectionPoints.size());
        Assertions.assertTrue(intersectionPoints.contains(new Point(3, 4)));
        Assertions.assertTrue(intersectionPoints.contains(new Point(4, 3)));
    }

    @Test
    public void testGetIntersectionPointsWhenTwoVertexInside() {
        // Given
        RectangleOperator rectangleOperator = new RectangleOperator();
        Rectangle rectangle1 = new Rectangle(new Point(1, 2), new Point(4, 4));
        Rectangle rectangle2 = new Rectangle(new Point(2, 3), new Point(3, 5));

        // When
        List<Point> intersectionPoints = rectangleOperator.getIntersectionPoints(rectangle1, rectangle2);

        // Then
        Assertions.assertEquals(2, intersectionPoints.size());
        Assertions.assertTrue(intersectionPoints.contains(new Point(3, 4)));
        Assertions.assertTrue(intersectionPoints.contains(new Point(2, 4)));
    }

    @Test
    public void testGetIntersectionPointsWhenNoIntersections() {
        // Given
        RectangleOperator rectangleOperator = new RectangleOperator();
        Rectangle rectangle1 = new Rectangle(new Point(1, 2), new Point(4, 4));
        Rectangle rectangle2 = new Rectangle(new Point(4, 4), new Point(5, 5));

        // When
        List<Point> intersectionPoints = rectangleOperator.getIntersectionPoints(rectangle1, rectangle2);

        // Then
        Assertions.assertEquals(0, intersectionPoints.size());
    }

    @Test
    public void testIsContainedWhenTrue() {
        // Given
        RectangleOperator rectangleOperator = new RectangleOperator();
        Rectangle rectangle1 = new Rectangle(new Point(1, 2), new Point(4, 4));
        Rectangle rectangle2 = new Rectangle(new Point(2, 2), new Point(4, 4));

        // When
        boolean isContained = rectangleOperator.isContained(rectangle1, rectangle2);

        // Then
        Assertions.assertTrue(isContained);
    }

    @Test
    public void testIsContainedWhenFalse() {
        // Given
        RectangleOperator rectangleOperator = new RectangleOperator();
        Rectangle rectangle1 = new Rectangle(new Point(1, 2), new Point(4, 4));
        Rectangle rectangle2 = new Rectangle(new Point(2, 2), new Point(4, 5));

        // When
        boolean isContained = rectangleOperator.isContained(rectangle1, rectangle2);

        // Then
        Assertions.assertFalse(isContained);
    }

    @Test
    public void testGetAdjacentLinesWhenProper() {
        // Given
        RectangleOperator rectangleOperator = new RectangleOperator();
        Rectangle rectangle1 = new Rectangle(new Point(1, 2), new Point(4, 4));
        Rectangle rectangle2 = new Rectangle(new Point(4, 2), new Point(5, 4));

        // When
        List<String> intersections = rectangleOperator.getAdjacentLines(rectangle1, rectangle2);

        // Then
        String expectedLine = "Proper adjacent: Rectangle A Line([4,2],[4,4]) rectangle B Line([4,2],[4,4])";
        Assertions.assertTrue(intersections.contains(expectedLine));
    }

    @Test
    public void testGetAdjacentLinesWhenSubLine() {
        // Given
        RectangleOperator rectangleOperator = new RectangleOperator();
        Rectangle rectangle1 = new Rectangle(new Point(1, 2), new Point(4, 4));
        Rectangle rectangle2 = new Rectangle(new Point(4, 2), new Point(5, 5));

        // When
        List<String> intersections = rectangleOperator.getAdjacentLines(rectangle1, rectangle2);

        // Then
        String expectedLine = "Rectangle A Line([4,2],[4,4]) is Sub-line of rectangle B Line([4,2],[4,5])";
        Assertions.assertTrue(intersections.contains(expectedLine));
    }

    @Test
    public void testGetAdjacentLinesWhenPartial() {
        // Given
        RectangleOperator rectangleOperator = new RectangleOperator();
        Rectangle rectangle1 = new Rectangle(new Point(1, 2), new Point(4, 4));
        Rectangle rectangle2 = new Rectangle(new Point(4, 3), new Point(5, 5));

        // When
        List<String> intersections = rectangleOperator.getAdjacentLines(rectangle1, rectangle2);

        // Then
        String expectedLine = "Partial adjacent: Rectangle A Line([4,2],[4,4]) rectangle B Line([4,3],[4,5])";
        Assertions.assertTrue(intersections.contains(expectedLine));
    }
}
