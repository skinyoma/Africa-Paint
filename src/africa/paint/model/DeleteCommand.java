
package africa.paint.model;

/**
 *
 * @author Soki_
 */
public class DeleteCommand implements Command{
    
    int Shapeindex;
    private Drawing drawing;
    private Shape shape;

    public DeleteCommand(Drawing drawing, int index) {
        this.Shapeindex = index;
        this.drawing = drawing;
    }

    @Override
    public void execute() {
        shape = drawing.getShapeByIndex(Shapeindex);
        drawing.remove(Shapeindex);
    }

    @Override
    public void unexecute() {
        drawing.addShape(shape);
    }
    
}
