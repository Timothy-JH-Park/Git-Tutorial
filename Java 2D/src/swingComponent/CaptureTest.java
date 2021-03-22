package swingComponent;


import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class CaptureTest{
    public static void main(String[] args){
    	try {
    		Toolkit toolkit = Toolkit.getDefaultToolkit();
    		Dimension screenSize = toolkit.getScreenSize();
    		Rectangle rectangle = new Rectangle(0, 0, screenSize.width, screenSize.height);
    		
            Robot robot = new Robot();
            BufferedImage image = robot.createScreenCapture(rectangle);
            ImageIO.write(image, "png", new File("c:/Download/captureImage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
   
//   public static void captureScreen(String fileName) {
 //       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 //       Rectangle screenRectangle = new Rectangle(screenSize);
      
        


