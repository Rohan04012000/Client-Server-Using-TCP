import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.Desktop;
import java.net.URI;

public class Fileserverclone{
	public static void main (String[] args){  
	  try{
		System.out.println("Waiting for Client to give me an URL");
		ServerSocket ss = new ServerSocket(12011);
		Socket s = ss.accept();	
		DataInputStream din = new DataInputStream(s.getInputStream());			
		
		String msgin = "";
		String hold = "1";
		String hold1 = "2";
		
		while(!msgin.equals("end")){
			
			msgin = din.readUTF();			

			if (Integer.parseInt(msgin) == 1){
				System.out.println("You are inside option 1. Reading the URL, type the url to read\n");
				msgin = din.readUTF();

				String urlString = msgin;
				URL url = new URL(urlString);
				InputStream is = url.openConnection().getInputStream(); 
				BufferedReader reader = new BufferedReader(new InputStreamReader(is));
				
				String line = null;
				while ((line = reader.readLine()) != null)
				{
				      System.out.println(line);
				}
				System.out.print("\nDone\n");
				reader.close();				
			}
			else if(Integer.parseInt(msgin) == 2){
				System.out.println("You are inside option 2. Browse URL, type the url to Browse\n");
				msgin = din.readUTF();
				Desktop d = Desktop.getDesktop();
				d.browse(new URI(msgin));
			}
			
		    }	

		s.close();	
		}
		catch(Exception e){
			System.out.println("Not Valid URL");
		}
	}
}
