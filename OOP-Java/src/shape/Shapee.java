package shape;

import vertex.Vertex;
import java.util.List;

public abstract class Shapee {
    private List<Vertex> vertexes;

    protected Shapee(List<Vertex> vertexes) {
        this.setVertexes(vertexes);
    }

    public Iterable<Vertex> getVertexes() {
        return vertexes;
    }

    public void setVertexes(List<Vertex> vertexes) {
        this.vertexes = vertexes;
    }
}
