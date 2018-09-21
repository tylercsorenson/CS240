import java.util.*;
import java.io.*;
import java.lang.*;

public class Image {
   public int width;
   public int height;
   public Pixel[][] pixelArray;
   
   public class InvalidNumberOfPixels extends Exception {
   }
   
   public void LoadImage(String inputFile) throws Exception {
      Scanner input = new Scanner(new File(inputFile));
      ArrayList<String> ppmHeader = new ArrayList<String>();
      int newRed = 0;
      int newGreen = 0;
      int newBlue = 0;
      
      input.useDelimiter("((#[^\\n]*\\n)|(\\s+))+");
      
      for (int i = 0; i < 4; ++i) {
         if (!input.hasNext()) {
            throw new InvalidNumberOfPixels();
         }   
         ppmHeader.add(input.next());
      }
      
      width = Integer.parseInt(ppmHeader.get(1));
      height = Integer.parseInt(ppmHeader.get(2));
      pixelArray = new Pixel[width][height];
      
      ArrayList<Integer> colorList = new ArrayList<Integer>();
      
      while (input.hasNext()) {
         colorList.add(Integer.parseInt(input.next()));
      }
      
      if (colorList.size() != 3 * width * height) {
         throw new InvalidNumberOfPixels();
      }
      
      int counter = 0;
      
      for (int row = 0; row < height; row++) {
         for (int column = 0; column < width; column++) {
            newRed = colorList.get(counter);
            newGreen = colorList.get(counter + 1);
            newBlue = colorList.get(counter + 2);
            pixelArray[column][row] = new Pixel(newRed, newGreen, newBlue);
            counter += 3;
         }
      }
      
      input.close();
   }
   
   public void SaveImage(String outputFile) throws Exception {
      StringBuilder outputString = new StringBuilder();
      outputString.append("P3\n" + width + " " + height + "\n255");
      
      for (int row = 0; row < height; row++) {
         for (int column = 0; column < width; column++) {
            outputString.append("\n" + pixelArray[column][row].red + "\n" + pixelArray[column][row].green + "\n" + pixelArray[column][row].blue);
         }
      }
      
      PrintWriter output = new PrintWriter(outputFile);
      output.println(outputString);
      output.close();
   }
   
   public void InvertImage() {
      for (int row = 0; row < height; row++) {
         for (int column = 0; column < width; column++) {
            pixelArray[column][row].InvertPixel();
         }
      }
   }
   
   public void Grayscale() {
      for (int row = 0; row < height; row++) {
         for (int column = 0; column < width; column++) {
            pixelArray[column][row].MakeGrey();
         }
      }
   }
   
   public void Emboss() {
      Pixel[][] oldPixelArray = new Pixel[width][height];
      for (int row = 0; row < height; row++) {
         for (int column = 0; column < width; column++) {
            oldPixelArray[column][row] = new Pixel(pixelArray[column][row].red, pixelArray[column][row].green, pixelArray[column][row].blue);
         }
      }
      
      int redDiff = 0;
      int greenDiff = 0;
      int blueDiff = 0;
      int maxDiff = 0;
      int newValue = 0;
      
      for (int row = 0; row < height; row++) {
         pixelArray[0][row].SetColors(128);
      }
      
      for (int column = 0; column < width; column++) {
         pixelArray[column][0].SetColors(128);
      }
      
      for (int row = 1; row < height; row++) {
         for (int column = 1; column < width; column++) {
            redDiff = oldPixelArray[column][row].red - oldPixelArray[column - 1][row - 1].red;
            greenDiff = oldPixelArray[column][row].green - oldPixelArray[column - 1][row - 1].green;
            blueDiff = oldPixelArray[column][row].blue - oldPixelArray[column - 1][row - 1].blue;
            
            maxDiff = Math.max(Math.abs(redDiff), Math.max(Math.abs(greenDiff), Math.abs(blueDiff)));
            
            if (maxDiff == Math.abs(redDiff)) {
               newValue = 128 + redDiff;
            }
            else if (maxDiff == Math.abs(greenDiff)) {
               newValue = 128 + greenDiff;
            }
            else {
               newValue = 128 + blueDiff;
            }
            
            if (newValue < 0) {
               newValue = 0;
            }
            else if (newValue > 255) {
               newValue = 255;
            }
            
            pixelArray[column][row].SetColors(newValue);
         }
      }
   }
   
   public void MotionBlur(int blurValue) {
      Pixel[][] oldPixelArray = new Pixel[width][height];
      for (int row = 0; row < height; row++) {
         for (int column = 0; column < width; column++) {
            oldPixelArray[column][row] = new Pixel(pixelArray[column][row].red, pixelArray[column][row].green, pixelArray[column][row].blue);
         }
      }
      
      int redAvg = 0;
      int greenAvg = 0;
      int blueAvg = 0;
      int redSum = 0;
      int greenSum = 0;
      int blueSum = 0;
      
      for (int row = 0; row < height; row++) {
         for (int column = 0; column < width; column++) {
            int counter = 1;
            redSum = oldPixelArray[column][row].red;
            greenSum = oldPixelArray[column][row].green;
            blueSum = oldPixelArray[column][row].blue;
            
            while (counter < blurValue && column + counter < width) {
               redSum += oldPixelArray[column + counter][row].red;
               greenSum += oldPixelArray[column + counter][row].green;
               blueSum += oldPixelArray[column + counter][row].blue;
               counter++;
            }
            
            redAvg = redSum / counter;
            greenAvg = greenSum / counter;
            blueAvg = blueSum / counter;
            
            pixelArray[column][row].red = redAvg;
            pixelArray[column][row].green = greenAvg;
            pixelArray[column][row].blue = blueAvg;
         }
      }
   }
}