package cs3331.noapplet; //make it play sound cukoo
import java.awt.*;
import java.util.Calendar;

public class NewDigitalClock extends DigitalClock {


public NewDigitalClock(String[] args) {
		super(args);
		// TODO Auto-generated constructor stub
	}

public void paintComponent(Graphics g) {
	Calendar calendar = Calendar.getInstance();
	int minute = calendar.get(Calendar.MINUTE);
	int second = calendar.get(Calendar.SECOND);
	if( minute == 0 && second == 0) {
		play(getCodeBase(), "cuckoo.au");
		}
	super.paintComponent(g);
	}
}
