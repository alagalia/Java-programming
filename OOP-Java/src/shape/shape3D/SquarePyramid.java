package shape.shape3D;

import vertex.Vertex3D;

import java.util.ArrayList;
import java.util.Arrays;

public class SquarePyramid extends SpaceShape{

    private Vertex3D baseCenter;
    double baseWidth;
    double piramidHeight;

    public SquarePyramid(Vertex3D baseCenter, double baseWidth, double piramidHeight) {
        super(new ArrayList(Arrays.asList(baseCenter)));
        this.setBaseCenter(baseCenter);
        this.setBaseWidth(baseWidth);
        this.setPiramidHeight(piramidHeight);
    }

    public Vertex3D getBaseCenter() {
        return baseCenter;
    }

    public void setBaseCenter(Vertex3D baseCenter) {
        this.baseCenter = baseCenter;
    }

    public double getBaseWidth() {
        return baseWidth;
    }

    public void setBaseWidth(double baseWidth) {
        this.baseWidth = baseWidth;
    }

    public double getPiramidHeight() {
        return piramidHeight;
    }

    public void setPiramidHeight(double piramidHeight) {
        this.piramidHeight = piramidHeight;
    }

    @Override
    public double getArea() {
        return this.baseWidth*this.baseWidth+2*this.baseWidth*
                Math.sqrt((this.baseWidth*this.baseWidth/4)+this.piramidHeight*this.piramidHeight);
    }

    @Override
    public double getVolume() {
        return this.baseWidth*this.baseWidth*(this.piramidHeight/3);
    }

    @Override
    public String toString() {
        String str = super.toString() + String.format
                (" %s, \ncoordinate:\r\n" +
                                " Center %s\r\n" +
                                " BaseWidth: %.2f\n" +
                                " Piramid height: %.2f\n" +
                                " Area: %.2f\n" +
                                " Volume: %.2f",
                        getClass().getSimpleName(),
                        this.getVertexes(),
                        this.baseWidth,
                        this.piramidHeight,
                        this.getArea(),
                        this.getVolume());

        return str.toString();
    }
}
