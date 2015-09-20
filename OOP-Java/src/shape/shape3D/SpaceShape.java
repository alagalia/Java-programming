package shape.shape3D;

import interfaces.AreaMeasurable;
import interfaces.VolumeMeasurable;
import shape.Shapee;
import vertex.Vertex3D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class SpaceShape extends Shapee implements AreaMeasurable, VolumeMeasurable {

    private List<Vertex3D> vertex3Ds;

    protected SpaceShape(List<Vertex3D> vertex3Ds) {
        super(new ArrayList(Arrays.asList(vertex3Ds)));
    }

    @Override
    public String toString() {
        return "Shape 3D:";
    }
}
