package africa.paint.model;

/**
 * List the method a shape must have
 * @author g53100
 */
public interface Shape {
    
    /**
     * Moves a shape.
     * @param dx y is moved by dx 
     * @param dy y is moved by dy
     */
    public void move(double dx, double dy);
    /**
     * Checks if a Point is in a shape
     * @param the Point to be checked
     * @return true if the Point is in the shape, false otherwise  
     */
    public boolean isInside(Point p);
    /**
     * Gets the output character of a shape
     * @return the output character of a shape
     */
    public char getColor();

    
    /**
     * Changes the color of a Shape
     * @param color the new color of the shape
     */
    public void setColor(char color);
    
    
}
