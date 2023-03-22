package africa.paint.model;
/**
 * This class represents a point.
 * A point has an abscissa and a ordinate
 * @author 53100
 */
public class Point {
    
    private double x;
    private double y;
    
    /**
     * Copy constructor of a Point
     * @param p the point to be copied.
     */
    public Point(Point p) {    // constructeur de recopie
        this(p.x, p.y);
    }

    /**
     * Default constructor of a point
     */
    public Point() {
        //System.out.println(" test " );
        this(0,0);
    }
   
    /**
     * Point constructor
     * @param x the abscissa of a point
     * @param y the ordinate of a point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Gets the abscissa of a point
     * @return the abscissa of a point
     */
    public double getX() {
        return x;}
    /**
     * Gets the ordinate of a point
     * @return the ordinate of a point
     */
    public double getY() {
        return y;
    }
    
    /**
     * Moves a point
     * @param dx y is moved by dx 
     * @param dy y is moved by dy
     */
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }
    
    /**
     * Prints a point
     * @return the point in a string form
     */
    @Override
    public String toString() {
        return "("+x+", "+y+")";
    }
    
    /**
     * Moves a point.
     * @param dx y is moved by dx 
     * @param dy y is moved by dy
     */
    public void move(int dx, int dy) {
        System.out.println("méthode move(int, int)");
        x += dx;
        y += dy;
    }
    /**
     * Calculates the distance between two points
     * @param w the other point
     * @return the distance between two points
     */
    public double distanceTo(Point other){
        return Math.sqrt(Math.pow((this.getX() - other.getX()),2) +
               Math.pow((this.getY() - other.getY()),2));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
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
        final Point other = (Point) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
    
}

    