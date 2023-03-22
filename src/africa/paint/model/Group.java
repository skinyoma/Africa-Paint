package africa.paint.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Soki_
 */
public class Group extends ColoredShape {
    
    private List<Shape> shapes;
    
    public Group(List<Shape> shapes){
        super(shapes.get(0).getColor());
        this.shapes = shapes;
    }
    
    @Override
    public boolean isInside(Point p){
        for (Shape shape : shapes) {
            if (shape.isInside(p)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void move(double dx, double dy){
        for (Shape shape : shapes) {
            shape.move(dx, dy);
        }
    }
    
    @Override
    public void setColor(char color){
        super.setColor(color);
    }

    protected List<Shape> getList() {
        return shapes;
    }

    @Override
    public String toString() {
        String affiche = "";
        for (Shape shape : shapes) {
            affiche += ""+shape+",  ";
        }
        return affiche;
    } 
    
    public void addShape(Shape s){
        shapes.add(s);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.shapes);
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
        final Group other = (Group) obj;
        if (!this.shapes.equals(other.shapes)) {
            return false;
        }
        return true;
    }
    
    
}
