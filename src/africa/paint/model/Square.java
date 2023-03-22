package africa.paint.model;

/**
 * This class represents a Square, it is a subclass of Rectangle
 * @author g53100
 */
public class Square extends Rectangle implements Shape {
    
    /**
     * Square contructor
     * @param bottomLeft the bottomLeft point of a square
     * @param side the side of a square
     * @param color the color of a square
     */
    public Square(Point bottomLeft, double side, char color){
        super(bottomLeft,side,side,color);
        
    }

    @Override
    public String toString() {
        Point ur = new Point(this.getBottomLeft().getX() + this.getWidth(),
                             this.getBottomLeft().getY() + this.getHeight() );
        return "Rectangle : ["+this.getBottomLeft()+", "+ur+"]";
    }
    
    
    
}
