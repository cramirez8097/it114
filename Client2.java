import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Client2 {
	String      appName     = "D&D v3";
	Client2     Client2;
	JFrame      newFrame    = new JFrame(appName);
	JButton     sendMessage;
	JTextField  messageBox;
	JTextArea   chatBox;
	JTextField  usernameChooser;
	JTextField  strChooser;
	JTextField  intlChooser;
	JTextField  chaChooser;
	JTextField  dexChooser;
	JTextField  conChooser;
	JTextField  wisChooser;
	JTextField  typeChooser;
	JFrame      preFrame;
	Socket server;
	public void preDisplay() {
			newFrame.setVisible(false);
			preFrame = new JFrame(appName);
			usernameChooser = new JTextField(15);
			strChooser = new JTextField(3);
			intlChooser = new JTextField(3);
			chaChooser = new JTextField(3);
			dexChooser = new JTextField(3);
			conChooser = new JTextField(3);
			wisChooser = new JTextField(3);
			typeChooser = new JTextField(15);
			JLabel chooseUsernameLabel = new JLabel("Enter a name:");
			JLabel chooseStrLabel = new JLabel("Enter Str:");
			JLabel chooseIntlLabel = new JLabel("Enter Int:");
			JLabel chooseChaLabel = new JLabel("Enter Cha:");
			JLabel chooseDexLabel = new JLabel("Enter Dex:");
			JLabel chooseConLabel = new JLabel("Enter Con:");
			JLabel chooseWisLabel = new JLabel("Enter Wis:");
			JLabel chooseTypeLabel = new JLabel("Player or DM?(P/D):");
			JButton enterServer = new JButton("Enter Chat Server");
			enterServer.addActionListener(new enterServerButtonListener());
			JPanel prePanel = new JPanel(new GridBagLayout());

			GridBagConstraints preRight = new GridBagConstraints();
			preRight.insets = new Insets(0, 0, 0, 10);
			preRight.anchor = GridBagConstraints.EAST;
			GridBagConstraints preLeft = new GridBagConstraints();
			preLeft.anchor = GridBagConstraints.WEST;
			preLeft.insets = new Insets(0, 10, 0, 10);

			preRight.fill = GridBagConstraints.HORIZONTAL;
			preRight.gridwidth = GridBagConstraints.REMAINDER;

			prePanel.add(chooseUsernameLabel, preLeft);
			prePanel.add(usernameChooser, preRight);
			prePanel.add(chooseStrLabel, preLeft);
			prePanel.add(strChooser, preRight);
			prePanel.add(chooseIntlLabel, preLeft);
			prePanel.add(intlChooser, preRight);
			prePanel.add(chooseChaLabel, preLeft);
			prePanel.add(chaChooser, preRight);
			prePanel.add(chooseDexLabel, preLeft);
			prePanel.add(dexChooser, preRight);
			prePanel.add(chooseConLabel, preLeft);
			prePanel.add(conChooser, preRight);
			prePanel.add(chooseWisLabel, preLeft);
			prePanel.add(wisChooser, preRight);
			prePanel.add(chooseTypeLabel, preLeft);
			prePanel.add(typeChooser, preRight);
			preFrame.add(BorderLayout.CENTER, prePanel);
			preFrame.add(BorderLayout.SOUTH, enterServer);
			preFrame.setSize(300, 300);
			preFrame.setVisible(true);

	}

	public void display() {
			JPanel mainPanel = new JPanel();
			mainPanel.setLayout(new BorderLayout());

			JPanel southPanel = new JPanel();
			southPanel.setBackground(Color.BLUE);
			southPanel.setLayout(new GridBagLayout());

			messageBox = new JTextField(30);
			messageBox.requestFocusInWindow();

			sendMessage = new JButton("Send Message");
			sendMessage.addActionListener(new sendMessageButtonListener());

			chatBox = new JTextArea();
			chatBox.setEditable(false);
			chatBox.setFont(new Font("Serif", Font.PLAIN, 15));
			chatBox.setLineWrap(true);

			mainPanel.add(new JScrollPane(chatBox), BorderLayout.CENTER);

			GridBagConstraints left = new GridBagConstraints();
			left.anchor = GridBagConstraints.LINE_START;
			left.fill = GridBagConstraints.HORIZONTAL;
			left.weightx = 512.0D;
			left.weighty = 1.0D;

			GridBagConstraints right = new GridBagConstraints();
			right.insets = new Insets(0, 10, 0, 0);
			right.anchor = GridBagConstraints.LINE_END;
			right.fill = GridBagConstraints.NONE;
			right.weightx = 1.0D;
			right.weighty = 1.0D;

			southPanel.add(messageBox, left);
			southPanel.add(sendMessage, right);

			mainPanel.add(BorderLayout.SOUTH, southPanel);

			newFrame.add(mainPanel);
			newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			newFrame.setSize(470, 300);
			newFrame.setVisible(true);
	}

	class sendMessageButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
					if (messageBox.getText().length() < 1) {
							// do nothing
					}
				  if (messageBox.getText().equals("roll20")){
						int x = (int)(Math.random()*((20-1)+1))+1;
						String y = Integer.toString(x);
						chatBox.setText("<"+username+">"+type+": "+y+"\n");
					}
					if (messageBox.getText().equals("roll12")){
						int x = (int)(Math.random()*((12-1)+1))+1;
						String y = Integer.toString(x);
						chatBox.setText("<"+username+">"+type+": "+y+"\n");
					}
					if (messageBox.getText().equals("roll10")){
						int x = (int)(Math.random()*((10-1)+1))+1;
						String y = Integer.toString(x);
						chatBox.setText("<"+username+">"+type+": "+y+"\n");
					}
				  if (messageBox.getText().equals("roll8")){
						int x = (int)(Math.random()*((8-1)+1))+1;
						String y = Integer.toString(x);
						chatBox.setText("<"+username+">"+type+": "+y+"\n");
					}
					if (messageBox.getText().equals("roll6")){
						int x = (int)(Math.random()*((6-1)+1))+1;
						String y = Integer.toString(x);
						chatBox.setText("<"+username+">"+type+": "+y+"\n");
					}
					 if (messageBox.getText().equals("roll4")){
						int x = (int)(Math.random()*((4-1)+1))+1;
						String y = Integer.toString(x);
						chatBox.setText("<"+username+">"+type+": "+y+"\n");
					}
					 if (messageBox.getText().equals("rollstr")){
						int x = (int)(Math.random()*((20-1)+1))+1;
						int y= x+str;
						String z = Integer.toString(y);
						chatBox.setText("<"+username+">"+type+": "+z+"\n");
					}
					if (messageBox.getText().equals("rollint")){
					 int x = (int)(Math.random()*((20-1)+1))+1;
					 int y= x+intl;
					 String z = Integer.toString(y);
					 chatBox.setText("<"+username+">"+type+": "+z+"\n");
				 }
				 if (messageBox.getText().equals("rollcha")){
					int x = (int)(Math.random()*((20-1)+1))+1;
					int y= x+cha;
					String z = Integer.toString(y);
					chatBox.setText("<"+username+">"+type+": "+z+"\n");
				}
				if (messageBox.getText().equals("rolldex")){
				 int x = (int)(Math.random()*((20-1)+1))+1;
				 int y= x+dex;
				 String z = Integer.toString(y);
				 chatBox.setText("<"+username+">"+type+": "+z+"\n");
			 }
			 if (messageBox.getText().equals("rollcon")){
				int x = (int)(Math.random()*((20-1)+1))+1;
				int y= x+con;
				String z = Integer.toString(y);
				chatBox.setText("<"+username+">"+type+": "+z+"\n");
			}
			if (messageBox.getText().equals("rollwis")){
			 int x = (int)(Math.random()*((20-1)+1))+1;
			 int y= x+wis;
			 String z = Integer.toString(y);
			 chatBox.setText("<"+username+">"+type+": "+z+"\n");
		 }
					 if (messageBox.getText().equals("clear")) {
							chatBox.setText("Cleared all messages\n");
							messageBox.setText("");
					}else {
							chatBox.append("<" + username + ">"+type+":  " + messageBox.getText()
											+ "\n");
							messageBox.setText("");
					}
					messageBox.requestFocusInWindow();
			}
	}

	String  username;
	String type;
	int str;
	int intl;
	int cha;
	int dex;
	int con;
	int wis;
	class enterServerButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
					username = usernameChooser.getText();
					type= typeChooser.getText();
						str = Integer.parseInt(strChooser.getText());
						intl = Integer.parseInt(intlChooser.getText());
						cha = Integer.parseInt(chaChooser.getText());
						dex = Integer.parseInt(dexChooser.getText());
						con = Integer.parseInt(conChooser.getText());
						wis = Integer.parseInt(wisChooser.getText());
					if (username.length() < 1) {
							System.out.println("Need a name");
					} else {
							preFrame.setVisible(false);
							display();
					}
			}

	}
	public Client2() {
	}
	public void connect(String address, int port) {
		try {
			server = new Socket(address, port);
			System.out.println("Client connected");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void start() throws IOException {
		if(server == null) {
			return;
		}
		System.out.println("Client Started");
		try(Scanner si = new Scanner(System.in);
				PrintWriter out = new PrintWriter(server.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));){
			Thread inputThread = new Thread() {
				@Override
				public void run() {
					try {
						while(!server.isClosed()) {
							System.out.println("Send a Message!");
							String line = si.nextLine();
							if(!"quit".equalsIgnoreCase(line) && line != null) {
								out.println(line);
							}
							else {
								System.out.println("Stopping input thread");
								break;
							}
						}
					}
					catch(Exception e) {
						System.out.println("Shuting down");
					}
					finally {
						close();
					}
				}
			};
			inputThread.start();//start the thread

			//Thread to listen for responses from server so it doesn't block main thread
			Thread fromServerThread = new Thread() {
				@Override
				public void run() {
					try {
						String fromServer = "";
						while(!server.isClosed() && (fromServer = in.readLine()) != null) {
							System.out.println("Reply from server: " + fromServer);
						}
						System.out.println("Stopping server listen thread");
					}
					catch (Exception e) {
						if(!server.isClosed()) {
							e.printStackTrace();
							System.out.println("Server closed connection");
						}
						else {
							System.out.println("Connection closed");
						}
					}
					finally {
						close();
					}
				}
			};
			fromServerThread.start();//start the thread

			//Keep main thread alive until the socket is closed
			while(!server.isClosed()) {
				Thread.sleep(50);
			}
			System.out.println("Exited loop");
			System.exit(0);//force close
			//TODO implement cleaner closure when server stops before client
			//currently hangs/waits on the console/scanner input
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	private void close() {
		if(server != null && !server.isClosed()) {
			try {
				server.close();
				System.out.println("Closed socket");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
	@Override
        public void run() {
	try {
	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (Exception e) {
        e.printStackTrace();
}
	Client2 Client = new Client2();
	Client.preDisplay();
}
});
	Client2 client = new Client2();
	int port = -1;
	try{	
	port = Integer.parseInt(args[0]);
}
	catch(Exception e){
	System.out.println("Incorrect port");
}
	if(port == -1){
		return;
}
	client.connect("127.0.0.1", port);
	try {
	 client.start();
	} catch (IOException e) {
	e.printStackTrace();
}
}
}
