package utilityClasses;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

/*
 * It looks like this entire class could be rolled into one method:
 * public static checkPort(String host, int port, boolean printStatus)
 * which would check host and then port.
 * (You can't check the port anyway unless you've connected to the host)
 */
public class CheckPort {

	public static boolean checkPort(String host, int port, boolean printStatus) {

		try {
			Socket s = new Socket(host, port);
			
			if (printStatus) System.out.println("Open");
			return true;
			
		} catch (IOException e) {
			
			if (printStatus) System.out.println("Closed");
			return false;

		}

	}
	
	public static boolean checkPort(String host, int port) {

		try {
			Socket s = new Socket(host, port);
			
			System.out.println("Open");
			return true;
			
		} catch (IOException e) {
			
			System.out.println("Closed");
			return false;

		}

	}

}
