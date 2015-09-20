package shape.shapes2D;

import interfaces.AreaMeasurable;
import interfaces.PerimeterMeasurable;
import shape.Shapee;
import vertex.Vertex2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class PlaneShape extends Shapee implements PerimeterMeasurable, AreaMeasurable{

    public PlaneShape(List<Vertex2D> vertex2Ds) {
        super(new ArrayList(Arrays.asList(vertex2Ds)));
    }

    public abstract double getPerimeter();
    public abstract double getArea();

    @Override
    public String toString() {
        return "Shape 2D:";
    }
}
