package cs3331.noapplet;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CounterNoApplet extends NoApplet {

    public CounterNoApplet() {
        this(new String[0]);
    }
	
    public CounterNoApplet(String[] params) {
        super(params);
		
        //- WRITE YOUR CODE HERE
        
        Counter counter = new Counter();
        
        JLabel label = new JLabel("Value: ");
        JTextField display = new JTextField(5);
        JButton button = new JButton("Increment");
        JButton dcrButton = new JButton("Decrement");
        
        add(label);
        add(display);
        add(button);
        add(dcrButton);
        
        display.setText(Integer.toString(counter.value()));
        button.addActionListener(event -> {
        	//System.out.println("button clicked");
        	counter.incr();
        	display.setText(Integer.toString(counter.value()));
        });
        
        display.setText(Integer.toString(counter.value()));
        button.addActionListener(event -> { 
        	counter.dcr();
        	display.setText(Integer.toString(counter.value()));
        });
    }

    public static void main(String[] args) {
        new CounterNoApplet(new String[] {"width=330", "height=350"}).run();
    }
    
    private static class Counter{
    	private int value;
    	
    	public void incr() {
    		
    		value++;
    	}
    	
    	public int value() {
    		
    		return value;
    	}
    	
    	public void dcr() {
    		
    		value--;
    	}
    	
    	public int valueD() {
    		
    		return value;
    	}
    }
}