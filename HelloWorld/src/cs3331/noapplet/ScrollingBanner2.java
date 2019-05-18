package cs3331.noapplet;

import java.awt.Graphics;
import java.awt.Image;

/** 
 * Double-buffered scrolling banner. See Section 5.5.3 on page 193.
 */
@SuppressWarnings("serial")
public class ScrollingBanner2 extends ScrollingBanner {

    private Image image;
    private Graphics offscreen;

    public ScrollingBanner2(String[] args) {
    	super(args);
    }
    
    @Override
    public void update(Graphics g) {
        if (image == null) {
            image = createImage(dim.width, dim.height);
            offscreen = image.getGraphics();
        }
        super.paint(offscreen);
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void paintComponent(Graphics g) {
        update(g);
    }

    public static void main(String[] args) {
    	new ScrollingBanner(new String[] {"width=250", "height=50"}).run();
    }
}