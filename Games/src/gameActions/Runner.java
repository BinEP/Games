package gameActions;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.lang.reflect.Method;
 
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import utilityClasses.Windows;

public class Runner {
	
	public static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

	public static void main(String[] args) {
		
//		run(new UserGame());
		
	}
	/**
	 * Runs the game. Makes a new JFrame and adds the UserGame to the frame
	 */
	public static void run(Control game) {
		
		if (isMacOSX()) {
            System.setProperty(
                    "com.apple.mrj.application.apple.menu.about.name",
                    "Full Screen Demo");
        }
		
		JFrame frame = new JFrame(game.NAME + "!");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		//so doesn't flicker
		frame.setResizable(Windows.RESIZEABLE);
		frame.setAlwaysOnTop(Windows.ALWAYS_ON_TOP);
		
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		frame.setAlwaysOnTop(true);

		if (isMacOSX()) {
            enableFullScreenMode(frame);
        }
		
//		UserGame game = new UserGame();
//		frame.add((Component) gameClass.cast(game), BorderLayout.CENTER);
		frame.add(game, BorderLayout.CENTER);

		frame.setSize(Windows.WIDTH, Windows.REAL_HEIGHT);
		frame.setVisible(true);
	}
	
	public static void enableFullScreenMode(Window window) {
        String className = "com.apple.eawt.FullScreenUtilities";
        String methodName = "setWindowCanFullScreen";
 
        try {
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getMethod(methodName, new Class<?>[] {
                    Window.class, boolean.class });
            method.invoke(null, window, true);
        } catch (Throwable t) {
            System.err.println("Full screen mode is not supported");
            t.printStackTrace();
        }
    }
	
	private static boolean isMacOSX() {
        return System.getProperty("os.name").indexOf("Mac OS X") >= 0;
    }

	public Runner() {
		// TODO Auto-generated constructor stub
	
	}
	
	public Runner(Control game) {
		
		run(game);
	}

}
