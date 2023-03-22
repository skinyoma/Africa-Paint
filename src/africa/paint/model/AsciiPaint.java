package africa.paint.model;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * 
 * @author 53100
 */
public class AsciiPaint {
    private Stack<Command> undoStack;
    private Stack<Command> redoStrack;
    private Drawing drawing;
    
    /**
     * AsciiPaint default constructor
     */
    public AsciiPaint(){
        drawing = new Drawing();
        undoStack = new Stack<>();
        redoStrack = new Stack<>();
    }
    /**
     * AsciiPaint constructor
     * @param width the width of the drawing of the AsciiPaint
     * @param height the height of the drawing of the AsciiPaint 
     */
    public AsciiPaint(int width, int height){
        drawing = new Drawing(width, height);
    }
 
       
    /**
     * Adds a Circle to the AsciiPaint
     * @param x the abscissa of the center of the circle
     * @param y the ordinate of the center of the circle
     * @param radius the radius of the circle
     * @param color the color of the circle
     */
    public void newCircle(int x, int y, double radius, char color){
        Command addCircle = new AddCommand(new Circle(new Point(x,y), radius, color), drawing);
        addCircle.execute();
        undoStack.add(addCircle);
        redoStrack.clear();
    }
    /**
     * Adds a rectangle to the AsciiPaint
     * @param x the abscissa of the bottom left point of the rectangle
     * @param y the ordinate of the bottom left point of the rectangle
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @param color the color of the rectangle
     */
    public void newRectangle(int x, int y, double width, double height, char color){
        Command addRec = new AddCommand(new Rectangle(new Point(x,y), width, height, color), drawing);
        addRec.execute();
        undoStack.add(addRec);
        redoStrack.clear();
    }
    /**
     * Adds a square to the AsciiPaint
     * @param x the abscissa of the bottom left point of the square
     * @param y the ordinate of the botton left point of the rectangle
     * @param side the length of the side of the square
     * @param color the color of the square
     */
    public void newSquare(int x, int y, double side, char color){
        Command addSquare = new AddCommand(new Square(new Point(x,y), side, color), drawing);
        addSquare.execute();
        undoStack.add(addSquare);
        redoStrack.clear();
    }
    
    /**
     * Adds a line to the AsciiPaint
     * @param p1 the firt point included in the line
     * @param p2 the second point included in the line
     */
    public void newLine(int x, int y,int x2, int y2,char color){
        Command addLine = new AddCommand(new Line(new Point(x,y), new Point(x2,y2), color), drawing);
        addLine.execute();
        undoStack.add(addLine);
        redoStrack.clear();
    }

    
    /**
     * Gets the height of the drawing
     * @return the height of the drawing
     */
    public int getHeight() {
        return drawing.getHeight();
    }
    /**
     * Gets the width of the drawing 
     * @return the width of the drawing
     */
    public int getWidth(){
        return drawing.getWidth();
    }
    /**
     * Gets the color of the drawing at a given position
     * @param line the abscissa of the position
     * @param index the ordinate of the position
     * @return the color at the position (line,index)
     */
    public char getColorAt(int line, int index) {
        Shape s = drawing.getShapeAt(new Point(line, index));
        return s != null ?  s.getColor() : ' ';
    }
    /**
     * Moves the shape at the given index.
     * @param ShapeIndex the given index
     * @param dx the abscissa of the shape is moved by dx
     * @param dy the ordinate of the shape is moves by dy
     */
    public void move(int ShapeIndex, int dx, int dy){
        Command d = new MoveCommand(drawing, ShapeIndex, dx, dy);
        d.execute();
        undoStack.add(d);
    }
    
    /**
     * Groups two shapes together.
     * @param index1
     * @param index2 
     */
    public void groupExecute(int index1, int index2){
        Command group = new GroupCommand(index1, index2, drawing);
        group.execute();
        undoStack.add(group);

    }
    
    
    public void remove(int index){
        Command remove = new DeleteCommand(drawing, index);
        remove.execute();
        undoStack.add(remove);
    }
    
    public List<Shape> getListDrawing(){
        return drawing.getList();
    }
    
    
    public Shape getShapeByIndex(int index){
        return drawing.getShapeByIndex(index);
    }

    protected Drawing getDrawing() {
        return drawing;
    }
    
    public void setColor(char c, AsciiPaint p, int shapeIndex){
        Command setColor = new ColorCommand(c, p, shapeIndex);
        setColor.execute();
        undoStack.add(setColor);
    }

    public void ungroupExecute(int index) {
        Command ungroup = new UngroupCommand(index, this);
        ungroup.execute();
        undoStack.add(ungroup);
    }
    
    public void undo(){
        try{
            Command undo = undoStack.pop();
            undo.unexecute();
            redoStrack.add(undo);
        } catch (EmptyStackException e){
            System.err.println("Nothing to undo");
        }
    }
    
    public void redo(){
        try{
        Command redo = redoStrack.pop();
        redo.execute();
        } catch (EmptyStackException e){
            System.err.println("Nothing to redo");
        }
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.drawing);
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
        final AsciiPaint other = (AsciiPaint) obj;
        if (!this.drawing.equals(other.drawing)) {
            return false;
        }
        return true;
    }
    
    
    

}
