/*
Andrew Grdoutskurth
CIST 2372
Project
*/
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

class ChatClient extends JFrame implements ActionListener, Runnable{
	static Socket s;
	JTextField msg;
	JTextArea chat;
	JButton send;
	PrintStream ps;
	BufferedReader br;
	
	public ChatClient()
	{
		try
		{
			msg = new JTextField();
			chat = new JTextArea();
			send = new JButton("Send");
			JPanel panel = new JPanel();
			this.setSize(400,400);
			this.setLocation(400,0);
			this.setVisible(true);
			this.setLayout(new BorderLayout());
			panel.setLayout(new GridLayout(1,2));
			send.addActionListener(this);
			panel.add(msg);
			panel.add(send);
			this.add(panel, BorderLayout.SOUTH);
			this.add(chat, BorderLayout.CENTER);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("Client");
			
			Socket s = new Socket("localhost", 8000);
			ps = new PrintStream(s.getOutputStream());
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			chat.setText("Server Found");
			Thread thread = new Thread(this);
			thread.start();
		}
		catch(Exception e)
		{
			chat.setText(chat.getText() + '\n' + "Recieve  Error: " + e);
		}
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				chat.setText(chat.getText() + '\n' + "Server: " + br.readLine());
			}
		}
		catch(Exception e)
		{
			chat.setText(chat.getText() + '\n' + "Thread Error: " + e);
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == send && (msg.getText() != ""))
		{
			try
			{
				String string = msg.getText();
				chat.setText(chat.getText() + '\n' + "Client: " + string);
				msg.setText("");
				ps.println(string);
				ps.flush();
			}
			catch(Exception ex)
			{
				chat.setText(chat.getText() + '\n' + "Send Error: " + ex);
			}
		}
	}
	
	public static void main(String args[])
	{
		ChatClient cc = new ChatClient();
	}
}