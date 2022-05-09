package model.geometryutils;


public class ShapeDrawableFactory {

    public ShapeDrawable getShape(String shapeType){
        if(shapeType==null)
            return null;
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new CircleDrawable();
        } else if(shapeType.equalsIgnoreCase("LINE")){
            return new LineDrawable();
        } else if(shapeType.equalsIgnoreCase("POINT")){
            return new PointDrawable();
        }else if(shapeType.equalsIgnoreCase("POLYGON")){
            return new PointDrawable();
        }

        return null;
    }
}
