package com.example.dell.home1;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }
}
import java.io.*;
import java.net.*;
public class GossipServer
{
	public static void main (String [] args) throws Exception
	{
	    ServerSocket sersock= new ServerSocket(3000);//used to communcate with the client
			System.out.println("Server ready for chatting");
				Socket sock=sersock.accept();// waiting fr a client to listen
			BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));// sending to client 
    OutputStream otream=sock.getOutputStream();
		PrintWriter pwrite = new PrintWriter(otream,true);// recieving frm server
			InputStream itream= sock.getInputStream();
					BufferedReader receiveread = new BufferedReader(new InputStreamReader (itream)); //recieving  frm client to recieve messages
						String receiveMessage,sendMessage;
			              while(true)
					{  
				  if((receiveMessage=receiveread.readLine()) !=null) // is not equal to anything	 
				  {
					  System.out.println(receiveMessage);
				  }
						sendMessage=keyRead.readLine();
							pwrite.println(sendMessage);
								pwrite.flush();
					}
		
	}
}