package shape.shapes2D;

import vertex.Vertex2D;

import java.util.ArrayList;
import java.util.Arrays;

public class Rectangle extends PlaneShape {
    private Vertex2D vertex;
    private double width;
    private double height;

    public Rectangle(Vertex2D vertex, double width, double height) {
        super(new ArrayList(Arrays.asList(vertex)));
        this.setVertex(vertex);
        this.setWidth(width);
        this.setHeight(height);
    }

    public Vertex2D getVertex() {
        return vertex;
    }

    public void setVertex(Vertex2D vertex) {
        this.vertex = vertex;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return this.width*this.height;
    }

    @Override
    public double getPerimeter() {
        return 2*(this.width+this.height);
    }

    @Override
    public String toString() {
        String str = super.toString()+ String.format
                (" %s, \ncoordinate:\r\n" +
                                " Start vertex (left-down)%s\r\n" +
                                " width: %.2f\n" +
                                " height: %.2f\n" +
                                " Area: %.2f\n" +
                                " Perimeter: %.2f",
                        getClass().getSimpleName(),this.getVertexes(), this.width, this.height,this.getArea(),this.getPerimeter());

        return str.toString();
    }
}
