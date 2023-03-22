package africa.paint.model;

import java.util.Objects;

/**
* This class represents a rectangle  
*/
public class Rectangle extends ColoredShape implements Shape {
    private Point bl; //bottom left corner
    private double width;
    private double height;

    /**
     * Rectangle constructor
     * @param bottomLeft the bottom left point of a rectangle.
     * @param width the width of a rectangle.
     * @param color the color of the rectangle
     * @param height the height of a recta
     */
    public Rectangle(Point bottomLeft, double width, double height, char color) {
        super(color);
        this.bl = new Point(bottomLeft);
        this.width = width-1;
        this.height = height-1;
    }
    /**
     * Moves a rectangle.
     * @param dx y is moved by dx 
     * @param dy y is moved by dy
     */
    @Override
    public void move(double dx, double dy) {
        bl.move(dx, dy);
    }
    /**
     * Print a rectangle
     * @return a rectangle in a string form
     */
    @Override
    public String toString() {
        Point ur = new Point(bl.getX() + width,bl.getY() + height );
        return "Rectangle : ["+bl+", "+ur+"]";
    }

    /**
     * Checks if a Point is in a rectangle
     * @param the Point to be checked
     * @return true if the Point is in the shape, false otherwise  
     */
    @Override
    public boolean isInside(Point p) {
        Point ur = new Point(bl.getX() + height,bl.getY() + width );
        return p.getX() <= ur.getX() && p.getX() >= bl.getX() &&
               p.getY() >= bl.getY() && p.getY() <= ur.getY();
               
    }
    
    /**
     * Gets the output character of a rectangle
     * @return the output character of a rectangle
     */
    @Override
    public char getColor() {
        return super.getColor();
    }
    /**
     * Sets the color of a Rectangle
     * @param color the color to be set
     */
    @Override
    public void setColor(char color) {
         super.setColor(color);
    }
    
    protected Point getBottomLeft(){
        return bl;
    }
    
    protected double getHeight(){
        return height;
    }
    
    protected double getWidth(){
        return width;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.bl);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.width) ^ (Double.doubleToLongBits(this.width) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rectangle other = (Rectangle) obj;
        if (this.width != other.width) {
            return false;
        }
        if (this.height != other.height) {
            return false;
        }
        if (!this.bl.equals(other.bl)) {
            return false;
        }
        return true;
    }
    
}