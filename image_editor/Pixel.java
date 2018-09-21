import java.lang.*;

public class Pixel {
   public int red;
   public int green;
   public int blue;
   
   public Pixel() {
      red = 0;
      green = 0;
      blue = 0;
   }
   
   public Pixel(int newRed, int newGreen, int newBlue) {
      red = newRed;
      green = newGreen;
      blue = newBlue;
   }
   
   public void InvertPixel() {
      red = Math.abs(255 - red);
      green = Math.abs(255 - green);
      blue = Math.abs(255 - blue);
   } 
   
   public void MakeGrey() {
      int average = (red + green + blue) / 3;
      red = average;
      green = average;
      blue = average;
   }
   
   public void SetColors(int newColor) {
      red = newColor;
      green = newColor;
      blue = newColor;
   }
}