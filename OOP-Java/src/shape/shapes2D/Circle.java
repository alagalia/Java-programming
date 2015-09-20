package shape.shapes2D;

        import vertex.Vertex2D;

        import java.util.ArrayList;
        import java.util.Arrays;

public class Circle extends PlaneShape {

    private double radius;

    public Circle(Vertex2D center, double radius) {
        super(new ArrayList<>(Arrays.asList(center)));
        this.setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI*this.radius*this.radius;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*this.radius;
    }

    @Override
    public String toString() {
        String str = super.toString()+ String.format
                (" %s, \n" +
                                "coordinate:\r\n" +
                                " center: %s\r\n" +
                                " radius: %.2f \r\n" +
                                " Area: %.2f\n" +
                                " Perimeter: %.2f",
                        getClass().getSimpleName(),this.getVertexes(), this.radius, this.getArea(), this.getPerimeter());

        return str.toString();
    }



}
