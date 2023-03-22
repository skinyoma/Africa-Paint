package africa.paint.model;

import java.util.Objects;

/**
 * This class represents a Cirle and implements Shape.
 * A Cirlce is represented by a radius and a center.
 * @author 53100
 */
public class Circle extends ColoredShape implements Shape{

    private double radius;
    private Point center;

    /**
     * Circle constructor
     * @param center the center of the circle
     * @param radius the radius of the circle
     */
    public Circle(Point center, double radius, char color) {
        super(color);
        if (radius <= 0) {
            throw new IllegalArgumentException("radius must be positive" +
                     ", received: " + radius);
        }
        this.radius = radius;
        this.center = new Point(center); //copie défensive
    }

    /**
     * Moves a circle.
     * @param dx y is moved by dx 
     * @param dy y is moved by dy
     */
    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    /**
     * Gets the center of a circle 
     * @return the center of a circle
     */
    public Point getCenter() {
        return new Point(center); //copie défensive
    }

    /**
     * Prints a cicrle
     * @return a circle in a string form
     */
    @Override
    public String toString() {
        return "Circle : [" + center + ", " + radius + "]";
    }

    /**
     * Checks if a Point is in a circle
     * @param p the Point to be checked
     * @return true if the Point is in the shape, false otherwise  
     */
    @Override
    public boolean isInside(Point p){              // distance point-centre < rayon
        return center.distanceTo(p) <= radius;      
    }
    
    
    /**
     * Gets the output character of a cirlce
     * @return the output character of a circle
     */
    @Override
    public char getColor(){
        return super.getColor();
    }
    /**
     * Sets the color of a Circle
     * @param color the color to be set
     */
    @Override
    public void setColor(char color) {
        super.setColor(color); 
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.radius) ^ (Double.doubleToLongBits(this.radius) >>> 32));
        hash = 11 * hash + Objects.hashCode(this.center);
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
        final Circle other = (Circle) obj;
        if (Double.doubleToLongBits(this.radius) != Double.doubleToLongBits(other.radius)) {
            return false;
        }
        if (!((this.center).equals(other.center))){
            return false;
        } if (other.radius != this.radius){
            return false;
        }
        return true;
    }
    
}
