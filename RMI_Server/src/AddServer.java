import java.rmi.*;
import java.net.*;

public class AddServer
{
	public static void main(String args[])
	{
		
		try
		{
				AddRemImpl locobj=new AddRemImpl();
				Naming.rebind("rmi:///AddRem",locobj);
			
		}

		catch (RemoteException re)
		{
			re.printStackTrace();
		}
		catch(MalformedURLException mfe)
		{
				mfe.printStackTrace();
		
	
	}



}
}
