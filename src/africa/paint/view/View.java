package africa.paint.view;

import africa.paint.model.AsciiPaint;
import africa.paint.model.Color;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author 53100
 */
public class View {
    private Scanner in;
    private AsciiPaint paint;
    
    
    
    /**
     * View constructor.
     */
    public View() {
        in = new Scanner(System.in);
        paint = new AsciiPaint();
    }

    /**
     * Prints a "welcome" message.
     */
    public void initialized() {
        System.out.println("Welcome to AsciiPaint");
    }
    
    /**
     * Prints the list of commands that the user can use.
     */
    public void Help() {
        System.out.println("COMMANDS:");
        System.out.println("          * Write 'add <circle centerX centerY radius color>' to add a circle ");
        System.out.println("          * Write 'add <rectangle bottomLeftX bottomLeftY width height color>' to add a rectangle ");
        System.out.println("          * Write 'add <square bottomLeftX bottomLeftY side color>' to add a square ");
        System.out.println("          * Write 'show' to output the drawing");
        System.out.println("          * Write 'quit' to exit");
        System.out.println();

    }
    
    /**
     * Asks the user a command.
     *
     */
    public String askCommand() {
        String command;                             
        System.out.println("Please enter a command.");
        command = in.nextLine();
        return command;
    }
    /**
     * Prints a String
     * @param str the object to be printed
     */
    public void print(Object str){
        System.out.println(str);
    }
    
    /**
     * Represent the drawing of an asciiPaint in a String form
     */
    public void asAscii(AsciiPaint paint){
            String illustr = "";
            for (int line = 0; line < paint.getHeight(); line++) {
                for (int index = 0; index < paint.getWidth(); index++) {
                        switch(paint.getColorAt(line, index)){
                            case 'a' : illustr += Color.ANSI_RED_BACKGROUND+  "   " + Color.ANSI_RESET;break;
                            case 'z' : illustr += Color.ANSI_CYAN_BACKGROUND + "   " + Color.ANSI_RESET; break;
                            case 'e' : illustr += Color.ANSI_BLUE_BACKGROUND+ "   " + Color.ANSI_RESET;break;
                            case 'r' : illustr += Color.ANSI_PURPLE_BACKGROUND + "   " + Color.ANSI_RESET;break;
                            case 't' : illustr += Color.ANSI_YELLOW_BACKGROUND + "   " + Color.ANSI_RESET; break;
                            case 'y' : illustr += Color.ANSI_GREEN_BACKGROUND + "   " + Color.ANSI_RESET; break;
                            case ' ' : illustr += "   ";break;
                            default: illustr += paint.getColorAt(line, index)+ "  ";break;
                        }
                }
                illustr += "\n";
            }
            System.out.println(illustr);
    }
    
    public void setInput(InputStream in){
        this.in = new Scanner(in);
    }
}
