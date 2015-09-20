package shape.shape3D;

import vertex.Vertex3D;

import java.util.Arrays;

public class Cuboid extends SpaceShape{
    private Vertex3D vertex;
    private double width;
    private double height;
    private double depth;

    public Cuboid(Vertex3D vertex, double width, double height, double depth) {
        super(Arrays.asList(vertex));
        this.setVertex(vertex);
        this.setWidth(width);
        this.setHeight(height);
        this.setDepth(depth);
    }

    public Vertex3D getVertex() {
        return vertex;
    }

    public void setVertex(Vertex3D vertex) {
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

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    @Override
    public double getArea() {
        return 2*this.width*this.depth+2*this.depth*this.height+2*this.height*this.width;
    }

    @Override
    public double getVolume() {
        // Volume = Depth ? Width ?  Height
        return this.depth*this.width*this.height;
    }

    @Override
    public String toString() {
        String str = super.toString()+ String.format
                (" %s, \ncoordinate:\r\n" +
                                " Start vertex %s\r\n" +
                                " width: %.2f\n" +
                                " height: %.2f\n" +
                                " depth: %.2f\n"+
                                " Area: %.2f\n" +
                                " Volume: %.2f",
                        getClass().getSimpleName(),this.getVertexes(), this.width, this.height,this.depth, this.getArea(),this.getVolume());

        return str.toString();
    }
}
