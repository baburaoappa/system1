import java.rmi.Naming;

public class Server 
{
	public static void main(String[] args)
	{
		try
		{
			SumImplement implement = new SumImplement();
			Naming.rebind("SUM", implement);
		}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
		}
	}
}
