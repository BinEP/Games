package gameActions;

import java.awt.BorderLayout;
import java.awt.Window;
import java.lang.reflect.Method;

import javax.swing.JFrame;

import utilityClasses.Windows;

/**
 * Runs the game. Makes a new JFrame and adds the UserGame to the frame
 */
public class Runner extends JFrame {
	
	public static void main(String[] args) {
		
		Runner r = new Runner();
		Runner.enterFullScreen(r);
		
	}
	
//	public static void run(Control game) {
//		
//		JFrame frame = new JFrame(game.NAME + "!");
//
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLayout(new BorderLayout());
//		
//		frame.setResizable(Windows.RESIZEABLE);
//		frame.setAlwaysOnTop(Windows.ALWAYS_ON_TOP);
//		
//		frame.add(game, BorderLayout.CENTER);
//
//		frame.setSize(Windows.WIDTH, Windows.REAL_HEIGHT);
//		
//		tryFullScreen(frame);
//		frame.setVisible(true);
//	}
	
	public static void tryFullScreen(Window window) {
		
		if (isMacOSX()) {
            enableFullScreenMode(window);
            enterFullScreen(window);
        }
		
	}
	
	public static void enableFullScreenMode(Window window) {
 
        try {
        	
            Class<?> FSUClass = Class.forName("com.apple.eawt.FullScreenUtilities");
            Class params[] = new Class[]{Window.class, Boolean.TYPE};
            Method allowFullScreen = FSUClass.getMethod("setWindowCanFullScreen", params);
            
            allowFullScreen.invoke(FSUClass, window, true);
        } catch (Throwable t) {
            System.err.println("Full screen mode is not supported");
            t.printStackTrace();
        }
    }
	
	public static void enterFullScreen(Window window) {
		
		try {
			Class<?> appClass = Class.forName("com.apple.eawt.Application");
			Class params[] = new Class[]{};
			
			Method getApplication = appClass.getMethod("getApplication", params);
			Object application = getApplication.invoke(appClass);
			
			Method toggleFullScreen = application.getClass().getMethod("requestToggleFullScreen", Window.class);
         
			toggleFullScreen.invoke(application, window);
		} catch (Exception e) {
			System.out.println("An exception occurred while trying to toggle full screen mode");
			e.printStackTrace();
		}

		
	}
	
	private static boolean isMacOSX() {
        return System.getProperty("os.name").indexOf("Mac OS X") >= 0;
    }

	public Runner() {
		
		enableFullScreenMode(this);
		setVisible(true);
	}
	
	public Runner(Control game) {
		super(game.NAME + "!");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		setResizable(Windows.RESIZEABLE);
		setAlwaysOnTop(Windows.ALWAYS_ON_TOP);
		
		add(game, BorderLayout.CENTER);

		setSize(Windows.WIDTH, Windows.REAL_HEIGHT);
		
		enableFullScreenMode(this);
		
		setVisible(true);
	}

}
