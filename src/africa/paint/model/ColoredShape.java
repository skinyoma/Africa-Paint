
package africa.paint.model;

/**
 * This class represent a colored shape
 * A colored shape has a color/
 * @author 53100
 */
public abstract class ColoredShape implements Shape {
    
    private char color;
    
    /**
     * Colored shape constructor
     * @param color the color of the shape
     */
    public ColoredShape(char color){
        this.color = color;
    }
    /**
     * Gets the color of shape
     * @return the color of a shape
     */
    public char getColor(){
        return color;
    }
    /**
     * Sets the color of a shape
     * @param color the color to be set
     */
    public void setColor(char color){
        this.color = color;
    }
    /**
     * Moves a point.
     * @param dx y is moved by dx 
     * @param dy y is moved by dy
     */
    @Override
    public void move(double dx, double dy) {
       this.move(dx, dy);
    }
    /**
     * Checks if a point is inside of a shape
     * @param p the point to be checked
     * @return true if the point is inside, false otherwise
     */
    @Override
    public boolean isInside(Point p) {
        return this.isInside(p);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.color;
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
        final ColoredShape other = (ColoredShape) obj;
        if (this.color != other.color) {
            return false;
        }
        return true;
    }
    
    
    
    
}
