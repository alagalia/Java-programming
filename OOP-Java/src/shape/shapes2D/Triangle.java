package shape.shapes2D;

import vertex.Vertex2D;

import java.util.ArrayList;
import java.util.Arrays;

import static vertex.Vertex2D.getDistance;

public class Triangle extends PlaneShape {

    private Vertex2D vertA;
    private Vertex2D vertB;
    private Vertex2D vertC;

    public Triangle( Vertex2D vertA, Vertex2D vertB, Vertex2D vertC) {
        super(new ArrayList(Arrays.asList(vertA, vertB, vertC)));
        this.setVertA(vertA);
        this.setVertB(vertB);
        this.setVertC(vertC);
    }

    public Vertex2D getVertA() {
        return vertA;
    }

    public void setVertA(Vertex2D vertA) {
        this.vertA = vertA;
    }

    public Vertex2D getVertB() {
        return vertB;
    }

    public void setVertB(Vertex2D vertB) {
        this.vertB = vertB;
    }

    public Vertex2D getVertC() {
        return vertC;
    }

    public void setVertC(Vertex2D vertC) {
        this.vertC = vertC;
    }

    @Override
    public double getArea() {
        double area =Math.abs(
                vertA.getX()*(vertB.getY()-vertC.getY())+
                vertB.getX()*(vertC.getY()-vertA.getY()+
                vertC.getX()*(vertA.getY()-vertB.getY()))/2);
        return area;
    }

    @Override
    public double getPerimeter() {
        double sideA = getDistance(this.getVertA(), this.getVertB());
        double sideB = getDistance(this.getVertB(), this.getVertC());
        double sideC = getDistance(this.getVertC(),this.getVertA());
        double perimeter = sideA+sideB+sideC;
        return perimeter;
    }


            @Override
    public String toString() {
        String str = super.toString()+ String.format
                (" %s, \ncoordinate:\r\n" +
                                " Vertex A %s\n" +
                                " Vertex B %s\n" +
                                " Vertex C %s\n" +
                                " Area: %.2f\n" +
                                " Perimeter: %.2f",
                        getClass().getSimpleName(),this.vertA, this.vertB, this.vertC, this.getArea(), this.getPerimeter())
                ;

        return str.toString();
    }
}
