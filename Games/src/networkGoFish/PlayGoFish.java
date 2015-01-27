package networkGoFish;

import goFishCommons.ChatRoomWindow;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import utilityClasses.ScanNetwork;

import java.io.IOException;

import netgame.common.*;


/**
 *  A main class for the network TicTacToe game.  Main routine
 *  shows a dialog where the user can choose to be a server or
 *  a client.  If the user chooses to be a server, then a TicTacToeHub
 *  is created to manage the game; the game will not start until a
 *  second player has connected as a client.  To act as a client,
 *  the user must know the host name or IP address of the computer
 *  and the port number where the server is waiting for a connection.
 *  When run as a client, this program does not create a hub;
 *  rather, it connects to the hub that was created by the server.
 *  In either case, a TicTacToeWindow is created where the game will 
 *  be played.
 */
public class PlayGoFish {

    private static final int DEFAULT_PORT = 45017;
    private final static int CHAT_PORT = 37829;
    
    public static void main(String[] args) {
        
        // First, construct a panel that will be placed into a JOptionPane confirm dialog.
        
        JLabel message = new JLabel("Welcome to Networked Go Fish!", JLabel.CENTER);
        message.setFont(new Font("Serif", Font.BOLD, 16));
//        final JTextField numberOfPlayers = new JTextField("2", 2);
        final JTextField listeningPortInput = new JTextField("" + DEFAULT_PORT, 5);
//        final JTextField hostInput = new JTextField("localhost", 30);
        final JComboBox hostInput = new JComboBox();
//        final String[] choices = {"A", "B"};
        ScanNetwork scanning = new ScanNetwork();
        final String[] choices = scanning.checkHostsAtPort(DEFAULT_PORT);
        
        hostInput.setModel(new DefaultComboBoxModel(choices));
        hostInput.setSelectedIndex(0);
        
        final JTextField connectPortInput = new JTextField("" + DEFAULT_PORT, 5);
        
        
        
        
        
        final JRadioButton selectServerMode = new JRadioButton("Start a new game");
        final JRadioButton selectClientMode = new JRadioButton("Connect to existing game");
        
        ButtonGroup group = new ButtonGroup();
        group.add(selectServerMode);
        group.add(selectClientMode);
        ActionListener radioListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == selectServerMode) {
                	
//                  Host settings
                	listeningPortInput.setEnabled(true);
//                    numberOfPlayers.setEnabled(true);
                    listeningPortInput.setEditable(true);
                    
//                  Client settings
                    hostInput.setEnabled(false);
                    connectPortInput.setEnabled(false);
                    hostInput.setEditable(false);
                    connectPortInput.setEditable(false);
                }
                else {
                	
//                  Host settings
                    listeningPortInput.setEnabled(false);
//                    numberOfPlayers.setEnabled(false);
                    listeningPortInput.setEditable(false);
                    
//                  Client settings
                    hostInput.setEnabled(true);
                    connectPortInput.setEnabled(true);
                    hostInput.setEditable(true);
                    connectPortInput.setEditable(true);
                }
            }
        };
        selectServerMode.addActionListener(radioListener);
        selectClientMode.addActionListener(radioListener);
        
        selectServerMode.setSelected(true);
        
//      Client Settings disabled
        hostInput.setEnabled(false);
        connectPortInput.setEnabled(false);
        hostInput.setEditable(false);
        connectPortInput.setEditable(false);
        
        
        JPanel inputPanel = new JPanel();
        
        inputPanel.setLayout(new GridLayout(0,1,5,5));
        inputPanel.setBorder(BorderFactory.createCompoundBorder(
                     BorderFactory.createLineBorder(Color.BLACK, 2),
                     BorderFactory.createEmptyBorder(6,6,6,6) ));
        
        inputPanel.add(message);
        
        
        inputPanel.add(selectServerMode);
        
//        inputPanel.add(createRow("Players: ", numberOfPlayers));
        inputPanel.add(createRow("Listen on port: ", listeningPortInput));
        
        inputPanel.add(selectClientMode);
        
        inputPanel.add(createRow("Computer: ", hostInput));
        inputPanel.add(createRow("Port Number: ", connectPortInput));
        
        // Show the dialog, get the user's response and -- if the user doesn't
        // cancel -- start a game.  If the user chooses to run as the server
        // then a TicTacToeGameHub (server) is created and after that a TicTacToeWindow
        // is created that connects to the server running on  localhost, which was
        // just created.  In that case, the game will wait for a second connection. 
        // If the user chooses to connect to an existing server, then only
        // a TicTacToeWindow is created, that will connect to the specified
        // host where the server is running.
        
        while (true) {  // Repeats until a game is started or the user cancels.

            int action = JOptionPane.showConfirmDialog(null, inputPanel, "Network Go Fish", 
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
            if (action != JOptionPane.OK_OPTION)
                return;
            
            if (selectServerMode.isSelected()) {
                int port;
                try {
                    port = Integer.parseInt(listeningPortInput.getText().trim());
                    if (port <= 0)
                        throw new Exception();
                }
                catch (Exception e) {
                    message.setText("Illegal port number!");
                    listeningPortInput.selectAll();
                    listeningPortInput.requestFocus();
                    continue;
                }
                Hub hub;
                Hub chatHub;
                try {
                    hub = new GoFishGameHub(port);
                    chatHub = new Hub(CHAT_PORT); 
                }
                catch (Exception e) {
                    message.setText("Error: Can't listen on port " + port);
                    listeningPortInput.selectAll();
                    listeningPortInput.requestFocus();
                    continue;
                }
                try {
                	ChatRoomWindow.newChat("localhost");
                    new GoFishWindow("localhost", port);
                    
                }
                catch (IOException e) {
                    message.setText("Could not connect to server on localhost!!");
                    hub.shutDownHub();
                    continue;
                }
                break;
            }
            else {
                String host;
                int port;
                try {
                	host = choices[hostInput.getSelectedIndex()];
                } catch (Exception e) {
                	
                	host = (String) hostInput.getEditor().getItem();
                	
                }
//                host = hostInput.getText();
                if (host.length() == 0) {
                    message.setText("You must enter a computer name!");
                    hostInput.requestFocus();
                    continue;
                }
                try {
                    port = Integer.parseInt(connectPortInput.getText().trim());
                    if (port <= 0)
                        throw new Exception();
                }
                catch (Exception e) {
                    message.setText("Illegal port number!");
                    connectPortInput.selectAll();
                    connectPortInput.requestFocus();
                    continue;
                }
                try {
                	ChatRoomWindow.newChat(host);
                    new GoFishWindow(host,port);
                    
                    
                }
                catch (IOException e) {
                    message.setText("Could not connect to specified host and port.");
//                  hostInput.selectAll();
                    
                    hostInput.requestFocus();
                    continue;
                }
                break;
            }
        }
        
    }
    
    public static JPanel createRow(String labelText, JComponent field) {
    	JPanel row = new JPanel();
    	 row = new JPanel();
         row.setLayout(new FlowLayout(FlowLayout.LEFT));        
         row.add(Box.createHorizontalStrut(40));
         row.add(new JLabel(labelText));
         row.add(field);
         return row;
    	
    }
}
