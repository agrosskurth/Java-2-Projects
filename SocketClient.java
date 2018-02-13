/*
Andrew Grosskurth
CIST 2372
Lab #6----Part 2----
*/

import java.net.*;
import java.io.*;

class SocketClient{
	
	public static void main(String args[])
	{
		try
		{
			Socket s = new Socket("localhost", 8000);
			BufferedReader bin = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String line = "";
			while((line = bin.readLine()) != null)
			{
			System.out.println(line);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}