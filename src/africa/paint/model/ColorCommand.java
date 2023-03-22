package africa.paint.model;

/**
 *
 * @author Soki_
 */
public class ColorCommand implements Command{
    
    private char color;
    private AsciiPaint p;
    private int shapeIndex;
    private char colorSave;

    @Override
    public void execute() {
        colorSave = p.getShapeByIndex(shapeIndex).getColor();
        p.getShapeByIndex(shapeIndex).setColor(color);        
    }

    public ColorCommand(char color, AsciiPaint p, int shapeIndex) {
        this.color = color;
        this.p = p;
        this.shapeIndex = shapeIndex;
    }

    @Override
    public void unexecute() {
       p.getShapeByIndex(shapeIndex).setColor(colorSave);
    }
    
}
