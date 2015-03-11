import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import ymsg.network.AccountLockedException;
import ymsg.network.LoginRefusedException;
import ymsg.network.Session;

public class YahooClient
	extends JFrame
	implements ActionListener, WindowListener {
	MySessionListener mySessionListener;
	Session yahooMessengerSession = null;
	JFrame appFrame;
	JPanel loginPanel, messagingPanel;
	JTextField userNameTextField;
	JPasswordField passwordTextField;
	JTextField messageToField;
	JLabel userNameLabel,
		passwordLabel,
		status,
		messageToLabel,
		messagePaneLabel;
	JButton loginButton, sendMessageButton, buzzButton;
	JTextArea messageTextArea;
	JTextArea messageHistoryTextArea;
	boolean loggedIn = false;
	boolean connectionClosed = false;

	public static void main(String[] args) {
		YahooClient yahooClient = new YahooClient();
	}

	public void windowClosing(WindowEvent we) {
		System.out.println("Cleaning Up");
		try {
			if ((yahooMessengerSession != null) && (loggedIn == true))
				yahooMessengerSession.logout();
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void windowActivated(WindowEvent we) {

	}
	public void windowOpened(WindowEvent we) {
	}
	public void windowDeactivated(WindowEvent we) {
		System.out.println("Window Deactivated");
	}

	public void windowClosed(WindowEvent we) {
		System.out.println("Window Closed Event");
	}
	public void windowIconified(WindowEvent we) {
	}
	public void windowDeiconified(WindowEvent we) {

	}
	private void initialize() {

		appFrame = new JFrame("JYMSG Demo App");
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appFrame.setSize(new Dimension(120, 40));
		appFrame.setResizable(false);
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.add(getLoginPanel());
		splitPane.add(getMessagingPanel());

		//Add the panel to the window.
		appFrame.getContentPane().add(splitPane, BorderLayout.CENTER);

		//Display the window.
		appFrame.pack();

		appFrame.setVisible(true);
		appFrame.addWindowListener(this);
	}

	public YahooClient() {
		initialize();

	}

	public void setViewable() {
		loggedIn = true;
		getStatusLabel().setText("Logged In");
		getLoginButton().setText("Logout");
		getMessageTextArea().setEditable(true);
		getMessageTextArea().setOpaque(true);
		getMessageToField().setEnabled(true);
		getMessageToField().setOpaque(true);
		getUserNameTextField().setOpaque(false);
		getUserNameTextField().setEditable(false);
		getPasswordTextField().setOpaque(false);
		getPasswordTextField().setEditable(false);
		getMessageHistoryTextArea().setEditable(false);
		getMessageHistoryTextArea().setOpaque(true);
		getSendMessageButton().setEnabled(true);
	}
	public void setUnviewable() {
		loggedIn = false;
		getStatusLabel().setText("Logged Out");
		getLoginButton().setText("Login");
		getMessageTextArea().setEditable(false);
		getMessageTextArea().setOpaque(false);
		getMessageToField().setEnabled(false);
		getMessageToField().setOpaque(false);
		getUserNameTextField().setOpaque(true);
		getUserNameTextField().setEditable(true);
		getPasswordTextField().setOpaque(true);
		getPasswordTextField().setEditable(true);
		getMessageHistoryTextArea().setEditable(true);
		getMessageHistoryTextArea().setOpaque(false);
		getSendMessageButton().setEnabled(false);
	}

	public void logout() {
		try {
			yahooMessengerSession.logout();
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		getMessageHistoryTextArea().setText("");
		loggedIn = false;
		connectionClosed = false;
		setUnviewable();

	}

	public void login() {
		connectionClosed = false;
		if (loggedIn == false) {
			yahooMessengerSession = new Session();
			mySessionListener = new MySessionListener(this);
			yahooMessengerSession.addSessionListener(mySessionListener);
			String userName = getUserNameTextField().getText();
			String password = getPasswordTextField().getText();
			try 
			{
				if ((userName.equals("")) || (password.equals(""))) 
				{
					System.out.println("User name/password is blank");
				} 
				else {
					System.out.println("Attempting login");
					yahooMessengerSession.login(userName, password);
					System.out.println("Username: " + userName);
					System.out.println("Password: " + password);
					System.out.println("ConnectionClosed" + connectionClosed);
					if (connectionClosed==false) 
					{
						setViewable();
					}
					else 
					{
						setUnviewable();
					} 
					
				}

			} catch (IllegalStateException e1) {
				System.out.println("I am here!!!");
				getStatusLabel().setText("Login Failed");

				e1.printStackTrace();
				loggedIn = false;
				connectionClosed = false;
			} catch (AccountLockedException e1) {
				e1.printStackTrace();
			} catch (LoginRefusedException e1) {
				getStatusLabel().setText("Login Failed");
				loggedIn = false;
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			System.out.println("Attempting logout");
			logout();

		}

	}

	public void sendMessage() {

		System.out.println("Attempting to send message");
		String messageTo = getMessageToField().getText();
		String messageText = getMessageTextArea().getText();
		try {
			yahooMessengerSession.sendMessage(messageTo, messageText);
			updateMessagingPanel(
				getUserNameTextField().getText() + ": " + messageText + '\n');
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == getSendMessageButton()) {
			sendMessage();

		}

		if (e.getSource() == getLoginButton()) {
			login();
		}

	}

	private JPasswordField getPasswordTextField() {
		if (passwordTextField == null) {
			passwordTextField = new JPasswordField(19);
			passwordTextField.addKeyListener(new MyKeyListener());
		}
		return passwordTextField;
	}

	private JTextField getUserNameTextField() {
		if (userNameTextField == null) {
			userNameTextField = new JTextField(12);
			userNameTextField.addKeyListener(new MyKeyListener());
		}
		return userNameTextField;
	}

	private JLabel getStatusLabel() {
		if (status == null) {
			status = new JLabel();

		}
		return status;
	}

	private JButton getLoginButton() {
		if (loginButton == null) {
			loginButton = new JButton("Login");
			loginButton.addActionListener(this);

		}
		return loginButton;
	}
	private JButton getSendMessageButton() {
		if (sendMessageButton == null) {
			sendMessageButton = new JButton("Send Message");
			sendMessageButton.addActionListener(this);
		}
		return sendMessageButton;
	}
	private JTextField getMessageToField() {
		if (messageToField == null) {
			messageToField = new JTextField(12);
		}
		return messageToField;
	}
	private JTextArea getMessageTextArea() {
		if (messageTextArea == null) {
			messageTextArea = new JTextArea("", 3, 50);
			messageTextArea.addKeyListener(new MyKeyListener());

		}
		return messageTextArea;
	}

	public class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent evt) {
			if (evt.getKeyChar() == '\n') {
				if (evt.getSource() == messageTextArea) {
					String messageText = messageTextArea.getText();
					String tmpString = messageText.replace('\n', ' ');
					messageTextArea.setText(tmpString);
					sendMessage();
				} else if (evt.getSource() == passwordTextField)
					login();
				else if (evt.getSource() == userNameTextField)
					login();
			}

		}
	}

	private JTextArea getMessageHistoryTextArea() {
		if (messageHistoryTextArea == null) {
			messageHistoryTextArea = new JTextArea("", 20, 50);
		}
		return messageHistoryTextArea;

	}

	private JPanel getLoginPanel() {
		if (loginPanel == null) {
			loginPanel = new JPanel();
			//				Create widgets.
			userNameTextField = getUserNameTextField();
			passwordTextField = getPasswordTextField();

			userNameLabel = new JLabel("User Name: ", SwingConstants.RIGHT);
			loginButton = getLoginButton();
			passwordLabel = new JLabel("Password: ", SwingConstants.RIGHT);
			status = getStatusLabel();
			status.setText("Logged Out");
			status.setHorizontalAlignment(SwingConstants.RIGHT);
			status.setForeground(Color.blue);

			GridBagConstraints constraints = new GridBagConstraints();

			//Add the widgets to the container.

			// user name label
			constraints.gridx = 0;
			constraints.gridy = 0;
			constraints.anchor = GridBagConstraints.EAST;
			loginPanel.add(userNameLabel, constraints);

			// user name text field
			constraints.gridx = 1;
			constraints.weightx = 10;
			constraints.weighty = 10;
			constraints.anchor = GridBagConstraints.WEST;
			loginPanel.add(userNameTextField, constraints);

			// password label
			constraints.gridx = 0;
			constraints.gridy = 1;
			constraints.anchor = GridBagConstraints.EAST;
			loginPanel.add(passwordLabel, constraints);

			// password text field
			constraints.gridx = 1;
			constraints.anchor = GridBagConstraints.WEST;
			loginPanel.add(passwordTextField, constraints);
			constraints.gridx = 1;
			constraints.gridy = 2;

			loginPanel.add(loginButton, constraints);

			constraints.gridy = 3;
			constraints.gridx = 0;
			constraints.gridwidth = 3;
			constraints.anchor = GridBagConstraints.WEST;
			loginPanel.add(status, constraints);

			userNameLabel.setBorder(
				BorderFactory.createEmptyBorder(5, 5, 5, 5));
			passwordLabel.setBorder(
				BorderFactory.createEmptyBorder(5, 5, 5, 5));
		}
		return loginPanel;
	}

	public void updateMessagingPanel(String text) {
		messageHistoryTextArea.append(text);
		messageHistoryTextArea.setCaretPosition(
			messageHistoryTextArea.getText().length());
		//		clear message area

		getMessageTextArea().setCaretPosition(0);
		getMessageTextArea().setText("");
			

	}

	public void handleConnectionClosed() {
		System.out.println("I am in handleConnectionClosed");
		connectionClosed = true;
		loggedIn = false;
		setUnviewable();

	}

	private JPanel getMessagingPanel() {
		if (messagingPanel == null) {
			messagingPanel = new JPanel();
			messagingPanel.setLayout(new GridBagLayout());
			messagingPanel.setBorder(
				BorderFactory.createCompoundBorder(
					BorderFactory.createTitledBorder("Messaging"),
					BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			// Create widgets.

			messageToField = getMessageToField();
			messageToField.disable();
			messageToField.setOpaque(false);

			// message text area		
			messageTextArea = getMessageTextArea();
			JScrollPane messageTextAreaScrollPane =
				new JScrollPane(
					messageTextArea,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			messageTextArea.setOpaque(false);
			messageTextArea.setEditable(false);
			messageTextArea.setWrapStyleWord(true);

			// message history text area
			messageHistoryTextArea = getMessageHistoryTextArea();
			messageHistoryTextArea.setOpaque(false);
			JScrollPane messageHistoryScrollPane =
				new JScrollPane(
					messageHistoryTextArea,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			messageHistoryTextArea.setEditable(false);
			messageHistoryTextArea.setWrapStyleWord(true);

			messageToLabel = new JLabel("To: ", SwingConstants.RIGHT);
			sendMessageButton = getSendMessageButton();
			sendMessageButton.setOpaque(false);
			sendMessageButton.setEnabled(false);
			messagePaneLabel = new JLabel("Message: ", SwingConstants.RIGHT);

			GridBagConstraints constraints = new GridBagConstraints();
			constraints.gridx = 0;
			constraints.gridy = 0;
			constraints.anchor = GridBagConstraints.EAST;
			messagingPanel.add(messageToLabel, constraints);

			constraints.gridx = 1;
			constraints.gridy = 0;
			constraints.anchor = GridBagConstraints.WEST;
			messagingPanel.add(messageToField, constraints);

			//Add the widgets to the container.
			constraints.gridx = 0;
			constraints.gridy = 1;
			constraints.gridwidth = 2;
			messagingPanel.add(messageHistoryScrollPane, constraints);
			constraints.gridx = 0;
			constraints.gridy = 2;
			constraints.gridwidth = 2;
			messagingPanel.add(messageTextAreaScrollPane, constraints);

			constraints.gridx = 0;
			constraints.gridy = 3;
			constraints.gridwidth = 2;
			messagingPanel.add(sendMessageButton, constraints);
		}
		return messagingPanel;
	}

}
