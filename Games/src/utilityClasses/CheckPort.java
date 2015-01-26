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

	public String host;
	public int port;

	public static void main(String[] args) {
		CheckPort runIt = new CheckPort();
		runIt.runFromMain();
	}

	public void runFromMain() {

		CheckPort cp = new CheckPort("localhost", 45017);
		System.out.println(cp.checkPort(cp.host, cp.port, true));

	}

	public CheckPort() {
		// TODO Auto-generated constructor stub
	}

	public CheckPort(String host, int port) {

		this.host = host;
		this.port = port;

	}

	public CheckPort(int port) {

		this.port = port;

	}

	public boolean checkPort(String host, int port, boolean printStatus) {

		try {
			Socket s = new Socket(host, port);
			
			if (printStatus) System.out.println("Open");
			return true;
			
		} catch (IOException e) {
			
			if (printStatus) System.out.println("Closed");
			return false;

		}

	}

}
