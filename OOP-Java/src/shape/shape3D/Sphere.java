package shape.shape3D;

import vertex.Vertex3D;

import java.util.Arrays;

public class Sphere extends SpaceShape {

    private Vertex3D center;
    private double radius;

    public Sphere(Vertex3D center, double radius) {
        super(Arrays.asList(center));
        this.setCenter(center);
        this.setRadius(radius);
    }

    public Vertex3D getCenter() {
        return center;
    }

    public void setCenter(Vertex3D center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
            return 4*Math.PI*this.radius*this.radius;
    }

    @Override
    public double getVolume() {
        return 4/3*Math.PI*this.radius*this.radius*this.radius;
    }

    @Override
    public String toString() {
        String str = super.toString()+ String.format
                (" %s, \ncoordinate:\r\n" +
                                " Center %s\r\n" +
                                " Radius: %.2f\n"+
                                " Area: %.2f\n" +
                                " Volume: %.2f",
                        getClass().getSimpleName(),this.getVertexes(), this.radius, this.getArea(),this.getVolume());

        return str.toString();
    }
}
