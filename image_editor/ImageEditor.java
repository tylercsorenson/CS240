import java.util.*;

public class ImageEditor {
   public static void main(String[] args) {
      try {
         ImageEditor imageEditor = new ImageEditor();
         imageEditor.run(args);
      }
      catch(Exception exception) {
         exception.printStackTrace();
      }
   }
   
   Image image = new Image();
   
   public class InvalidCommandLineArgumentsException extends Exception {
   }
   
   public void run(String[] args) throws Exception {
      try {
         if (args.length == 3 && (args[2].equals("invert") || args[2].equals("grayscale") || args[2].equals("emboss")) || args.length == 4 && args[2].equals("motionblur")) {
            
            image.LoadImage(args[0]);
            
            if (args[2].equals("invert")) {
               image.InvertImage();
            }
            else if (args[2].equals("grayscale")) {
               image.Grayscale();
            }
            else if (args[2].equals("emboss")) {
               image.Emboss();
            }
            else if (args[2].equals("motionblur")) {
               image.MotionBlur(Integer.parseInt(args[3]));
            }
            
            image.SaveImage(args[1]);
         }
         else {
            throw new InvalidCommandLineArgumentsException();
         }
      }
      catch(InvalidCommandLineArgumentsException exception) {
         System.out.println("USAGE: java ImageEditor  in-file out-file (grayscale|invert|emboss|motionblur motion-blur-length)");
      }
      catch(Image.InvalidNumberOfPixels exception) {
         System.out.println("File contains an invalid number of pixels and/or color values...");
      }
   }
}