package africa.paint.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represent a drawing
 * A drawing has a list of shape to be drawed
 * @author 53100
 */
public class Drawing {

    private List<Shape> shapeL;

    private int height;
    private int width;
    private static final int DEFAULT_HEIGHT = 60;
    private static final int DEFAULT_WIDTH = 125;
    /**
     * Default drawing constructorhn
     */
    public Drawing(){
        this(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
    /**
     * Drawing constructor
     * @param width the width of the drawing
     * @param height the height of the drawing
     */
    public Drawing(int width, int height){
    
        this.height = height;
        this.width = width;
        this.shapeL = new ArrayList<Shape>();

    }
    /**
     * Adds a shape to the list of shape of a drawing
     * @param shape the shape to be added
     */
    public void addShape(Shape shape){
        shapeL.add(shape);
    }
    /**
     * Gets the shape at a given point
     * @param p the given point
     * @return the shape at the given point
     */
    public Shape getShapeAt(Point p){
        Shape result = null;
        for (Shape s : shapeL){
            if (s.isInside(p)){
                result = s;
            }        
        }
        return result;
    }
    /**
     * Gets the height of a drawing 
     * @return the height of a drawing
     */
    int getHeight(){
        return height;
    }
    /**
     * Gets the width of a drawing 
     * @return the width of a drawing
     */
    int getWidth(){
        return width;
    }
    /**
     * Gets the shape in the list present at the given index
     * @param index the given index
     * @return the shape at the given index.
     */
    protected Shape getShapeByIndex(int index){
        return shapeL.get(index);
    }
    
    
    protected void remove(int index){
        shapeL.remove(index);
    }
    
    protected List<Shape> getList(){
        return shapeL;
    }   

    protected void removeByShape(Shape shape) {
        shapeL.remove(shape);
    }
 

    protected void removeByIndex(int index) {
        shapeL.remove(index);
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.shapeL);
        hash = 67 * hash + this.height;
        hash = 67 * hash + this.width;
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
        final Drawing other = (Drawing) obj;
        if (this.height != other.height) {
            return false;
        }
        if (this.width != other.width) {
            return false;
        }
        if (!this.shapeL.equals(other.shapeL)) {
            return false;
        }
        return true;
    }
    
}