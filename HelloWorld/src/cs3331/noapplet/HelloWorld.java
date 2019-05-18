package cs3331.noapplet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

//import noapplet.NoApplet;

/**
 * Sample NoAppet to draw a text and an image. The displayed image 
 * is from the file <code>src/image/rabbit.jpg</code>.
 * See Section 3.3.2 on pages 67-72.
 */
@SuppressWarnings("serial")
public class HelloWorld extends NoApplet {

    public HelloWorld() {
    }
	
    public HelloWorld(String[] params) {
	super(params);
    }
	
    public void paintComponent(Graphics g) {
        Dimension d = getSize();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, d.width, d.height);
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.setColor(new Color(255, 215,0));
        g.drawString("Hello from Rabbit!", 60, 40);
        g.drawImage(getImage(getCodeBase(), "image/rabbit.jpg"), 
        // g.drawImage(getImage("image/rabbit.jpg"), // same as the above line
           40, 60, this);
    }  

    public static void main(String[] args) {
    	//new HelloWorld().run();
    	// use the following to specify optional parameters like the window size
        new HelloWorld(new String[] {"width=330", "height=350"}).run();
    	// new HelloWorld(args).run();
    }
}