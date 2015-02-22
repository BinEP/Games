package utilityClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ScanNetwork {

	private static final int DEFAULT_PORT = 45017;
	public String subnetIP;

	public static void main(String[] args) {

		checkHosts();

	}

	public static String getCurrentIP() {

		try {

			return InetAddress.getLocalHost().getHostAddress();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return "";
	}

	public static String[] checkHosts() {
		String subnet;
		
		ArrayList<String> openHosts;
		
		String IPAddr = getCurrentIP();
		System.out.println(IPAddr);
		
		
		int endSubStr = IPAddr.lastIndexOf(".");
		boolean multipleSubnets = checkSubnets();
		
		subnet = IPAddr.substring(0, endSubStr);
		
		if (multipleSubnets) {
			endSubStr = subnet.lastIndexOf(".");
			subnet = IPAddr.substring(0, endSubStr);
		}

		openHosts = new ArrayList<String>();
		if (multipleSubnets) {
			
			openHosts = loopMultipleSubnets(subnet);
			
		} else {
			
		openHosts = loopHosts(subnet);
		}
		System.out.println("Done checking or found enough hosts");

		String[] hostsString = new String[openHosts.size()];
		hostsString = openHosts.toArray(hostsString);
		return hostsString;
	}
	
	public static ArrayList<String> loopHosts(String subnet) {
		
		int timeout = 10;
		ArrayList<String> openHosts = new ArrayList<String>();
		
		for (int i = 1; i < 254 && openHosts.size() < 30; i++) {
			String host = subnet + "." + i;
			try {
				if (InetAddress.getByName(host).isReachable(timeout)) {

					System.out.println(host + " is reachable");
					openHosts.add(host);

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return openHosts;
		
	}
	
	public static ArrayList<String> loopMultipleSubnets(String partSubnet) {
		ArrayList<String> openHosts = new ArrayList<String>();
		
		for (int k = 5; k < 6; k++) {
			
			String subnet = partSubnet + "." + k;
			openHosts.addAll(loopHosts(subnet));
			
			
		}
		
		return openHosts;
	}
	
	public static String[] checkHostsAtPort(int port) {
				
		String[] ips = checkHosts();
								
		ArrayList<String> openHosts = new ArrayList<String>();
		System.out.println("Checking Port " + port);
		System.out.println();
		
		for (int i = 0; i < ips.length; i++) {
			String host = ips[i];
			
			System.out.print("Checking " + host + "\t");
				
			if (CheckPort.checkPort(host, port)) {

					openHosts.add(host);

				}
			
		}
		System.out.println("Done checking or found enough hosts");

		String[] hostsString = new String[(openHosts.size() == 0) ? 1 : openHosts.size()];
		hostsString = openHosts.toArray(hostsString);
		
		
		if (hostsString.length == 1 && hostsString[0] == null) hostsString[0] = "localhost";
		
		return hostsString;
		
		
		
	}
	
	public static String getPublicIP() {
		String ip = "";
		URL whatismyip;
		try {
			whatismyip = new URL("http://checkip.amazonaws.com");
			BufferedReader in = new BufferedReader(new InputStreamReader(
	                whatismyip.openStream()));

	ip = in.readLine(); //you get the IP as a String
	System.out.println(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ip;
		
	}
	
	public static String getGateway() {
		
		
		 
	        String thisLine;
	        String gateway = "";
			try {
				Process result = Runtime.getRuntime().exec("traceroute -m 1 www.amazon.com");

		        BufferedReader output = new BufferedReader(new InputStreamReader(result.getInputStream()));
				thisLine = output.readLine();
				 StringTokenizer st = new StringTokenizer(thisLine);
			        st.nextToken();
			        gateway = st.nextToken();
			        System.out.printf("The gateway is %s\n", gateway);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				gateway = "127.0.0.1";
				e.printStackTrace();
			}
	       
	        return gateway;
		
	}
	
	public static boolean checkSubnets() {
		
		String routerAddress = getGateway();
		
		String subnetDigit = getIPtoNumber(routerAddress, 3);
		String comDigit = getIPtoNumber(getCurrentIP(), 3);
		
		return !subnetDigit.equals(comDigit);
				
	}
	
	public static String getIPtoNumber(String routerAddress, int numOfNums) {
		
		int period = routerAddress.length();
		for (int i = 0; i < 4 - numOfNums; i++) {
			period = routerAddress.lastIndexOf('.', period - 1);
			
		}
		
		return routerAddress.substring(0, period);
		
		
	}
	
	public static String[] addRecentServers(String[] scannedIPS, String folderPath) {
		
		ArrayList<String> recentList = FileList.getFileList(folderPath + "recentServers");
		
		for (String currentServer : scannedIPS) {
			
			if (!recentList.contains(currentServer)) {
				
				FileList.addToFile(folderPath + "recentServer", currentServer);
				
			}
		}
		scannedIPS = recentList.toArray(scannedIPS);
		return scannedIPS;
		
	}
	
	public static void addServer(String server, String folderPath) {
		
		String[] s = {server};
		addRecentServers(s, folderPath);
		
		
	}
}
