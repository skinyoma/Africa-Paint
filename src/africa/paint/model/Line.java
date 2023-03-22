
package africa.paint.model;

import java.util.Objects;

/**
 *
 * @author Soki_
 */
public class Line extends ColoredShape {
    private Point p1;
    private Point p2;
    
    public Line(Point p1, Point p2, char color){
        super(color);
        this.p1 = p1;
        this.p2 = p2;
    } 

    /**
     * Checks if a point is inside of a point
     * @param p the point to check
     * @return true if the point is inside, false otherwise
     */
    @Override
    public boolean isInside(Point p){
        double numerator = ((p1.getY() - p2.getY())* p.getX()) + 
                      ((p2.getX() - p1.getX()) * p.getY()) + 
                       (p1.getX() * p2.getY()) - 
                       (p2.getX() *p1.getY());
        
        double denominator = Math.sqrt(Math.pow(p2.getX() - p1.getX(),2) + Math.pow(p2.getY()- p1.getY(),2));
        return numerator / denominator == 0;
    }
    
    @Override
    public void setColor(char c){
        super.setColor(c);
    }
    
  
    @Override
    public void move(double dx, double dy){
        p1.move(dx, dy);
        p2.move(dx, dy);
    }
    
    @Override
    public String toString(){
        return "Line : ["+p1+" :"+p2+"]";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.p1);
        hash = 19 * hash + Objects.hashCode(this.p2);
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
        final Line other = (Line) obj;
        if (!this.p1.equals(other.p1)) {
            return false;
        }
        if (!this.p2.equals(other.p2)) {
            return false;
        }
        return true;
    }
    
}
