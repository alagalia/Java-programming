import interfaces.VolumeMeasurable;
import shape.Shapee;
import shape.shape3D.Cuboid;
import shape.shape3D.SpaceShape;
import shape.shape3D.Sphere;
import shape.shape3D.SquarePyramid;
import shape.shapes2D.Circle;
import shape.shapes2D.PlaneShape;
import shape.shapes2D.Rectangle;
import shape.shapes2D.Triangle;
import vertex.Vertex2D;
import vertex.Vertex3D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //2D shapes
        Circle cir = new Circle(new Vertex2D(9,9),4d);
        Rectangle rec =new Rectangle(new Vertex2D(3,3),10.5f, 2.3f);
        Triangle tri = new Triangle(new Vertex2D(9,9), new Vertex2D(10,10), new Vertex2D(11,9d));

        //3D shapes
        Cuboid cub = new Cuboid(new Vertex3D(3,2, 3), 5, 6.3f, 10.3f);
        Sphere sphere = new Sphere(new Vertex3D(3,2, 3), 15.3);
        SquarePyramid piram = new SquarePyramid(new Vertex3D(3,2, 3), 3.4f, 1.2f);

        List<Shapee> all = new ArrayList<>();

        all.addAll(Arrays.asList(cir, rec, tri, cub, sphere, piram));

        all.forEach(shape -> System.out.printf(shape + "\n---------------\n"));

        System.out.println("=================================");
        System.out.println("VolumeMeasurable shapes whose volume is over 40 are:");
        all.stream().filter(s -> s instanceof VolumeMeasurable)
                .filter(s -> ((SpaceShape) s).getVolume() > 40.0f)
                .forEach(shape -> System.out.println(shape + "\n"));

        List<PlaneShape>  sorted = new ArrayList<>();

        System.out.println("=================================");
        System.out.println("\nPlane shapes and sort them by their perimeter in ascending order:");
        all.stream()
                .filter(shape -> shape instanceof PlaneShape)
                .sorted((s1, s2) -> Double.compare(
                        ((PlaneShape) s1).getPerimeter(),
                        ((PlaneShape) s2).getPerimeter()))
                .forEach(shape -> System.out.printf(
                        "%s - Perimeter: %.2f;\n",
                        shape.getClass().getSimpleName(),
                        ((PlaneShape) shape).getPerimeter()));


    }
}
