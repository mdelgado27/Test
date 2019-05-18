package cs3331.noapplet;
/*
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Timer;

public class Ball {


    private Color color = Color.GREEN;
    private int radius = 20;
    private int x, y;
    private int dx = -2, dy = -4;
        
    private Image image;
    private Graphics offScreen;
    private Dimension dim;
    
    private Timer timer;
    private int delay = 10;
    
    public void update(Graphics g) {
    	// create an off-screen image and its grapchics
    	if (image == null) {
    		image = createImage(dim.width, dim.height);
    		offScreen = image.getGraphics();
    	}
    	
    	// fill the background
    	offScreen.setColor(Color.white);
    	offScreen.fillRect(0, 0, dim.width, dim.height);
    	
    	// adjust the position of the ball
    	if (x < radius || x > dim.width - radius) {
    		dx = -dx;
        }
    	if (y < radius || y > dim.height - radius) {
    		dy = -dy;
        }
    	x += dx;
    	y += dy;
        
    	// draw the ball and dump the off-screen image
    	offScreen.setColor(color);
    	offScreen.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    	g.drawImage(image,  0,  0,  this);
    }
}
*/