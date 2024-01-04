import com.rectangle.entities.Rectangle;
import com.rectangle.operators.RectangleOperator;

import com.rectangle.entities.Point;
import java.util.List;
import java.util.Scanner;

/**
 * Main console class for executing the rectangle operations
 *
 * @author Wilson Herrera
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point rectangleAFirstPoint = askForPoint("Insert first point (x,y) for Rectangle A", scanner);
        Point rectangleASecondPoint = askForPoint("Insert second point (x,y) for Rectangle A " +
                "(this point should be diagonal to the previous point)", scanner);
        Point rectangleBFirstPoint = askForPoint("Insert first point (x,y) for Rectangle B", scanner);
        Point rectangleBSecondPoint = askForPoint("Insert second point (x,y) for Rectangle B " +
                "(this point should be diagonal to the previous point)", scanner);
        Rectangle rectangleA = new Rectangle(rectangleAFirstPoint, rectangleASecondPoint);
        Rectangle rectangleB = new Rectangle(rectangleBFirstPoint, rectangleBSecondPoint);
        RectangleOperator operator = new RectangleOperator();

        //Intersection
        List<Point> intersectionPoints = operator.getIntersectionPoints(rectangleA, rectangleB);
        if(!intersectionPoints.isEmpty()){
            System.out.println("Rectangles intersect in points:");
            intersectionPoints.forEach(System.out::println);
        }else{
            System.out.println("No Intersection");
        }
        System.out.println();

        //Containment
        boolean aContainsB = operator.isContained(rectangleA, rectangleB);
        boolean bContainsA = operator.isContained(rectangleB, rectangleA);
        if(aContainsB && bContainsA){
            System.out.println("Containment: Rectangles ar equal");
        }else if(aContainsB){
            System.out.println("Rectangle B is contained in rectangle A");
        }else if(bContainsA){
            System.out.println("Rectangle A is contained in rectangle B");
        }else{
            System.out.println("No containment");
        }
        System.out.println();

        //Adjacency
        List<String> adjacentLines = operator.getAdjacentLines(rectangleA, rectangleB);
        if(adjacentLines.isEmpty()){
            System.out.println("No adjacent lines");
        }else{
            System.out.println("Adjacent lines found:");
            adjacentLines.forEach(System.out::println);
        }

    }

    public static Point askForPoint(String messageToShow, Scanner scanner){
        Point point = new Point();
        System.out.println(messageToShow);
        String rectanglePoint = scanner.nextLine();
        try{
            point.x = Integer.parseInt(rectanglePoint.split(",")[0]);
            point.y = Integer.parseInt(rectanglePoint.split(",")[1]);
        }catch(Exception e){
            System.out.println("Invalid point, the correct format is x,y (example: '0,0')");
            System.exit(0);
        }
        return point;
    }
}