package model.geometryutils;

import model.geometryutils.GeometricElement;
import model.geometryutils.Triangle;

import java.util.List;

public abstract class OperationCircleProperties {

    Triangle triangle;

    public OperationCircleProperties() {
    }

    public OperationCircleProperties(Triangle triangle) {
        this.triangle = triangle;
    }

    public abstract List<GeometricElement> getResultComponents();

}
