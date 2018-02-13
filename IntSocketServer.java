/*
Andrew Grdoutskurth
CIST 2372
Lab #6----Part 2----
*/

import java.net.*;
import java.io.*;

class IntSocketServer{
	
	public static void main(String args[])
	{
		try
		{
			ServerSocket ss = new ServerSocket(8001);
			System.out.println("Waiting for client...");
			Socket s = ss.accept();
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeInt(1);
			dout.writeInt(2);
			dout.writeInt(3);
			dout.writeInt(4);
			dout.writeInt(0);
			dout.close();
			s.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}