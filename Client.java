import java.rmi.Naming;
import java.util.Scanner;

public class Client 
{
	public static void main(String[] args)
	{
		try
		{
			String url = "rmi://"+args[0]+"/SUM";
			Scanner sc = new Scanner(System.in);
			System.out.println("\nEnter number 1:");
			int m = sc.nextInt();
			System.out.println("\nEnter number 2:");
			int n = sc.nextInt();
			SumInterface inter = (SumInterface)Naming.lookup(url);
			System.out.println("\nAddition is:"+inter.sum(m, n));
			
		}
		catch(Exception e)
		{
			
		}
	}
}
