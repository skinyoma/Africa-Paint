package africa.paint.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Soki_
 */
public class GroupCommand implements Command{
    
    private int index1;
    private int index2;
    private Drawing drawing;

    public GroupCommand(int index1, int index2, Drawing drawing) {
        this.index1 = index1;
        this.index2 = index2;
        this.drawing = drawing;
    }
    

    @Override
    public void execute() {
        group();
    }

    @Override
    public void unexecute() {
        int group = drawing.getList().size()-1;
        for (Shape shape : ((Group)drawing.getShapeByIndex(group)).getList()){
            drawing.addShape(shape);
        }
        drawing.removeByIndex(group);
        
    }

        
    private void group(){
        List<Shape> l = new ArrayList<Shape>();
        Shape s1= drawing.getShapeByIndex(index1);
        Shape s2 = drawing.getShapeByIndex(index2);
        if (s1.getClass().getSimpleName().equals("Group") &&
            !s2.getClass().getSimpleName().equals("Group")){
            groupS1(s1,s2);
        } else if ( s2.getClass().getSimpleName().equals("Group") &&
                    !s1.getClass().getSimpleName().equals("Group")){
            groupS2(s1,s2);
        } else if ( s2.getClass().getSimpleName().equals("Group") &&
                    s1.getClass().getSimpleName().equals("Group")){
            groupTwoGroup(s1,s2);
        } else {
            groupSimple(l, s1, s2);
        }

    }
    
    private void groupSimple(List<Shape> l, Shape s1, Shape s2){
            l.add(s1);
            l.add(s2);
            drawing.remove(index1);
            drawing.remove(index2-1);
            Group newp = new Group(l);
            drawing.addShape(newp);
    }
    
    private void groupTwoGroup(Shape s1, Shape s2){
        for (Shape s : ((Group) s2).getList()) {
                ((Group) s1).addShape(s);
            }  
            drawing.remove(index2);
    }
    
    private void groupS1(Shape s1, Shape s2){
        ((Group) s1).addShape(s2);
            drawing.remove(index2);   
    }
    private void groupS2(Shape s1, Shape s2){
        ((Group) s2).addShape(s1);
            drawing.remove(index1);
    }
    
}
