package africa.paint.model;

import java.util.List;

/**
 *
 * @author Soki_
 */
public class UngroupCommand implements Command {
    
    private int index;
    private AsciiPaint ascii;
    private List<Shape> shapes;

    public UngroupCommand(int index, AsciiPaint ascii) {
        this.index = index;
        this.ascii = ascii;
    }

    @Override
    public void execute() {
        shapes = ((Group) ascii.getShapeByIndex(index)).getList();
        Command ungroup = new GroupCommand(0, 0, ascii.getDrawing());
        ungroup.unexecute();
        
    }

    @Override
    public void unexecute() {
        Command d = new AddCommand(new Group(shapes), ascii.getDrawing());
        d.execute();
    }
    
    
   
    
}
