import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int numpt=0;
        for(Point pt :s.getPoints()){
        numpt=numpt+1;
        }
        return numpt;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double avg=getPerimeter(s)/getNumPoints(s);
        
        return avg;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double large=0;
        Point prev = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point Pt : s.getPoints()) {
            double currDist = prev.distance(Pt);
            if(currDist>large){
            large=currDist;
            }
            prev = Pt;
        }
        return large;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largeX=0;
        // For each point currPt in the shape,
        for (Point Pt : s.getPoints()) {
            if(Pt.getX()>largeX){
            largeX=Pt.getX();
            }
        }
        return largeX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largePeri=0;
        double perimeter;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
             perimeter=getPerimeter(s);
             if(perimeter>largePeri){
                 largePeri=perimeter;
             } 
        }

        return largePeri;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        double largePeri=0;
        double perimeter;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
             perimeter=getPerimeter(s);
             if(perimeter>largePeri){
                 largePeri=perimeter;
                 temp=f;
             } 
        }

        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int num = getNumPoints(s);
        System.out.println("No of points = " + num);
        double avg = getAverageLength(s);
        System.out.println("Average Length = " + avg);
        double large = getLargestSide(s);
        System.out.println("Largest Length = " + large);
        double largeX = getLargestX(s);
        System.out.println("Largest X = " + largeX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largeperi = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter = " + largeperi);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String largeperiF = getFileWithLargestPerimeter();
        System.out.println("Largest perimeter filename = " + largeperiF);

    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
