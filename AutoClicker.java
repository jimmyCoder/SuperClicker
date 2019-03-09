import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;


/**
 * Autoclicker class.  Code modified from https://stackoverflow.com/questions/20615451/robot-mousepress-auto-clicker-how-to-make-it-stop
 * 
 * @author jpd
 *
 */
public class AutoClicker{
/**
 * Rate of clicking
 */
private static int rate;
/**
 * Boolean that tells you if it's time to kill the clicker.
 */
public static boolean killClicker;
public AutoClicker(int rate){
	this.rate=rate;
}
/**
 * Click automatically according to the clicking rate 
 */
	public static void autoclick () {
		// TODO: use user input from GUI to set rate
		// TODO: If there are safety concerns with autoclickers, make sure to add a speed limitation
		killClicker=false;
		try {
			Robot robot = new Robot();
			while (killClicker==false) {
				
				try {
					Thread.sleep(rate);
					robot.mousePress(InputEvent.BUTTON1_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
				} catch (InterruptedException ex) {}
			} 
		}catch (AWTException e) {}
	}

	public static void main(String[] args){
		AutoClicker clicked= new AutoClicker(1000);
		clicked.autoclick();
		
	}
}
