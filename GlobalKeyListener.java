import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
/**
 * This class listens to key strokes.
 * I made this class by editing the program from a jnativehook example program on github.
 * You can find it at: https://github.com/kwhat/jnativehook/wiki/Keyboard
 * @author jpd
 *
 */
public class GlobalKeyListener implements NativeKeyListener {
	private static AutoClicker clicked;
	public GlobalKeyListener(AutoClicker clicked) {
		this.clicked=clicked;
	}

	public void nativeKeyPressed(NativeKeyEvent e) {
		//TODO: Later on, I'm going to want to be able to stop the clicker when a combination of keys are pressed at once.
	}
	/**
	 * When the s key is pressed, a boolean in the AutoClicker is set that will make it stop clicking.
	 */
	public void nativeKeyReleased(NativeKeyEvent e) {
		if(NativeKeyEvent.getKeyText(e.getKeyCode())=="S"){
			clicked.killClicker=true;
		}
	}

	public void nativeKeyTyped(NativeKeyEvent e) {
		
	}

/*	public static void main(String[] args) {
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}
		// Clear previous logging configurations.
		LogManager.getLogManager().reset();

		// Get the logger for "org.jnativehook" and set the level to off.
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
		GlobalScreen.addNativeKeyListener(new GlobalKeyListener());
	}*/
}