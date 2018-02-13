/*
Andrew Grosskurth
CIST 2372
Lab #6----Part 2----
*/

import java.net.*;
import java.io.*;

class SocketServer{
	
	public static void main(String args[])
	{
		try
		{
			ServerSocket ss = new ServerSocket(8000);
			System.out.println("Waiting for client...");
			Socket s = ss.accept();
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			PrintStream ps = new PrintStream(dout);
			ps.println("Hello!");
			dout.close();
			s.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}