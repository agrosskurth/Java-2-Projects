/*
Andrew Grosskurth
CIST 2372
Lab #6----Part 2----
*/

import java.net.*;
import java.io.*;

class IntSocketClient{
	
	public static void main(String args[])
	{
		try
		{
			Socket s = new Socket("localhost", 8001);
			DataInputStream din = new DataInputStream(s.getInputStream());
			int ints = 0;
			while((ints = din.readInt()) != 0)
			{
			System.out.println(ints);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}