import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

/**
 * This is the Main class.  The older testing class(ClickTest.java) shall still be used to test new features before they are implemented here.
 * @author jpd
 */
public class Main {
	public static AutoClicker clicked;
	
	/**
	 * Runs the autoclicker with the rate.
	 * @param rate
	 */
	public static void RunAutoClicker(int rate) {
		clicked.setclickRate(rate);
		clicked.autoclick();
	}
	
	public static void main(String[]args) throws NativeHookException{
		 clicked= new AutoClicker();

		GlobalScreen.registerNativeHook();

		// Clear previous logging configurations.
		LogManager.getLogManager().reset();
		// Get the logger for "org.jnativehook" and set the level to off.
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
		
		//Set up the key listener
		GlobalKeyListener gKL=new GlobalKeyListener(clicked);
		GlobalScreen.addNativeKeyListener(gKL);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClickFrame frame = new ClickFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//TODO: implement a goodbye message when the user closes the JFrame.
	}
}
