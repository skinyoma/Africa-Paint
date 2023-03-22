
package africa.paint.model;

/**
 *
 * @author Soki_
 */
public class MoveCommand implements Command{
    
    int Shapeindex;
    private Drawing drawing;
    private int dx;
    private int dy;

    public MoveCommand(Drawing drawing, int index, int dx, int dy) {
        this.Shapeindex = index;
        this.drawing = drawing;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void execute() {
       drawing.getShapeByIndex(Shapeindex).move(dx, dy);
    }

    @Override
    public void unexecute() {
        drawing.getShapeByIndex(Shapeindex).move(-dx,-dy);
    }
    
    
    
}
