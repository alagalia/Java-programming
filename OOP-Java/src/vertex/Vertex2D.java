package vertex;

public class Vertex2D extends Vertex {
    public Vertex2D(double x, double y) {
        super(x, y);
    }

    public static double getDistance(Vertex2D start, Vertex2D end) {
        double distance =
                Math.sqrt(Math.pow(start.getX()-end.getX(),2)
                        + (Math.pow(start.getY()-end.getY(),2)));
        return distance;
    }
}
