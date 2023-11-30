# Rectangles
This challenge has the following points:
- create a Class rectangle
- verify if two rectangles intersect and return the points if an intersection
- verify if one rectangle contains another one
- verify if one rectangle is adjacent to another one

# Type of project
This is a Java console application, so rectangles should be inserted via the command line

# How to run 
Download the project and open it up in a Java IDE (IntelliJ recommended)
Run the Main class

# How to insert the two rectangles
The command line will ask you for 2 diagonal cartesian points for each rectangle (the program will calculate the missing vertex of each rectangle)
Example:
```
Insert first point (x,y) for Rectangle A
1,2
Insert second point (x,y) for Rectangle A
4,4
Insert first point (x,y) for Rectangle B
3,3
Insert second point (x,y) for Rectangle B
6,5

(Output)
Rectangles intersect in points:
[3,4]
[4,3]

No containment

No adjacent lines

Process finished with exit code 0
```

Another example:
```
Insert first point (x,y) for Rectangle A
2,2
Insert second point (x,y) for Rectangle A (this point should be diagonal to the previous point)
3,3
Insert first point (x,y) for Rectangle B
2,2
Insert second point (x,y) for Rectangle B (this point should be diagonal to the previous point)
3,4

(Output)
No Intersection

Rectangle A is contained in rectangle B

Adjacent lines found:
Proper adjacent: Rectangle A Line([2,2],[3,2]) rectangle B Line([2,2],[3,2])
Rectangle A Line([3,2],[3,3]) is Sub-line of rectangle B Line([3,2],[3,4])
Rectangle A Line([2,2],[2,3]) is Sub-line of rectangle B Line([2,2],[2,4])

Process finished with exit code 0
```
