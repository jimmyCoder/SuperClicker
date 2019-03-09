import java.awt.Dimension;

import javax.swing.JFrame;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

//import junk.GlobalKeyListenerExample;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
/**
 * A testing classfor the autoclicker.
 * I got the code to remove most annoying logging data from: https://stackoverflow.com/questions/30560212/how-to-remove-the-logging-data-from-jnativehook-library
 * @author jpd
 *
 */
public class ClickTest {
	public static void main(String[]args) throws NativeHookException{
		AutoClicker clicked= new AutoClicker(10);

			GlobalScreen.registerNativeHook();

			System.out.println("Welcome to Super Clicker!");
			System.out.println("Press the s key to to stop clicking!");
		// Clear previous logging configurations.
		LogManager.getLogManager().reset();
		// Get the logger for "org.jnativehook" and set the level to off.
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
		
		//Set up the key listener
		GlobalKeyListener gKL=new GlobalKeyListener(clicked);
		GlobalScreen.addNativeKeyListener(gKL);
		//begin autoclicking
		clicked.autoclick();
		//remove the key listener
		GlobalScreen.removeNativeKeyListener(gKL);
		GlobalScreen.unregisterNativeHook();
		
		System.out.println("Thank you for using Super Clicker!");
	}


}
