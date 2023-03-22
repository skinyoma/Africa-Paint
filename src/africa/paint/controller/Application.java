package africa.paint.controller;

import africa.paint.model.AsciiPaint;
import africa.paint.model.Shape;
import africa.paint.view.View;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Soki_
 */
public class Application {
    private AsciiPaint paint;
    private View view;
    private int speed = 0;
    /**
     * AsciiPaint constructor
     */
    public Application(){
        paint = new AsciiPaint();
        view = new View();
    }
    /**
     * Starts the controller.
     */
    //public void start(){
        //Controller c = new Controller(new View(), paint);
        //c.start();
    //}
   
    /**
     * Initialize the view
     */
    public void initialize(){
        view.initialized();
    }
    /**
     * Starts a painting
     */
    public void start(){
        String command;
        this.initialize();
        view.Help();
        command = view.askCommand();
        while (!command.equals("quit")){
            startDrawing(command);
            command = view.askCommand();
        }
        System.out.println("Bye");
    }
    
    
    
    /**
     * Executes a command
     * @param command the command to be executed
     */
    private void startDrawing(String command){
        if (command.equals("show")){
            view.asAscii(paint);
        } 
        String[] commandTab = command.split(" ");
        if (commandTab[0].equals("add")){
            startDrawingAdd(commandTab);
        } else if (commandTab[0].equals("move")){
            startDrawingMove(commandTab);
        } else if (commandTab[0].equals("group")){
            startDrawingGroup(commandTab);
        } else if (commandTab[0].equals("delete")){
            startDrawingRemove(commandTab);
        } else if (commandTab[0].equals("list")){
            startDrawingList();
        } else if (commandTab[0].equals("ungroup")){
            startDrawingUngoup(commandTab);
        } else if (commandTab[0].equals("color")){
            startDrawingColor(commandTab);
        } else if (commandTab[0].equals("load")){
            startDrawingWithFile(commandTab);
        } else if (commandTab[0].equals("eof")){
            view.setInput(System.in);
        } else if (commandTab[0].equals("speed")){
            setSpeed(Integer.parseInt(commandTab[1]));
        } else if (commandTab[0].equals("redo")){
            paint.redo();
        } else if (commandTab[0].equals("undo")){
            paint.undo();
        }
        pause();
        if (speed > 0){
            view.asAscii(paint);
        }
    }
    
    
    private void startDrawingAdd(String[] commandTab){
        switch (commandTab[1]){
            case "rectangle": paint.newRectangle(Integer.parseInt(commandTab[2]),
                                                 Integer.parseInt(commandTab[3]),
                                                 Integer.parseInt(commandTab[4]),
                                                 Integer.parseInt(commandTab[5]),
                                                 commandTab[6].charAt(0)); break;
                        
            case "square": paint.newSquare(Integer.parseInt(commandTab[2]),
                                           Integer.parseInt(commandTab[3]),
                                           Integer.parseInt(commandTab[4]),
                                           commandTab[5].charAt(0)); break;
                                          
            case "circle": paint.newCircle(Integer.parseInt(commandTab[2]),
                                           Integer.parseInt(commandTab[3]),
                                           Integer.parseInt(commandTab[4]),
                                           commandTab[5].charAt(0)); break; 
                                           
            case "line": paint.newLine(Integer.parseInt(commandTab[2]),
                                       Integer.parseInt(commandTab[3]),
                                       Integer.parseInt(commandTab[4]), 
                                       Integer.parseInt(commandTab[5]), 
                                       commandTab[6].charAt(0));break;
                                       
            }
        
    }

    private void startDrawingMove(String[] commandTab) {
        paint.move(Integer.parseInt(commandTab[1]), 
                   Integer.parseInt(commandTab[2]),
                   Integer.parseInt(commandTab[3]));
    }

    private void startDrawingGroup(String[] commandTab) {
        paint.groupExecute(Integer.parseInt(commandTab[1]),
                    Integer.parseInt(commandTab[2]));
    }

    private void startDrawingRemove(String[] commandTab) {
        paint.remove(Integer.parseInt(commandTab[1]));
    }

    private void startDrawingList() {
        List<Shape> drawingList = paint.getListDrawing();
        for (Shape coloredShape : drawingList) {
            view.print(coloredShape);
        }
    }

    private void startDrawingUngoup(String[] commandTab) {
        paint.ungroupExecute(Integer.parseInt(commandTab[1]));
    }

    private void startDrawingColor(String[] commandTab) {
        paint.setColor(commandTab[2].charAt(0), paint, Integer.parseInt(commandTab[1]));
    }

    private void startDrawingWithFile(String[] commandTab) {
        String file = commandTab[1];
        try{
            InputStream in = new FileInputStream(file);
            view.setInput(in);
        } catch(FileNotFoundException f){
            System.err.println("Fichier inexistant: " + file);
        }         
    }
    
    private void setSpeed(int speed){
        this.speed = speed;
    }

    private void pause() {
        try{
            Thread.sleep(speed);
            
        } catch(InterruptedException i){
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, i);
        }
    }
}
