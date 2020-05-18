import java.io.*;
import java.net.*;
import java.util.*;

public class Fileclientclone{
	public static void main(String[] args){
	 try{

				Socket s = new Socket("localhost", 12011); 
				System.out.println("Press 1 for Web Scraping\n2. Press 2 for browse visiting");
				
				DataOutputStream dout = new DataOutputStream(s.getOutputStream());

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String msgout = "";

				while(!msgout.equals("end")){
					msgout = br.readLine();
					dout.writeUTF(msgout);
			       		}

			}
	    catch(Exception e){
		System.out.println("Something failed, Check your internet connection\n");
		}
	}
}
