import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SumImplement extends UnicastRemoteObject implements SumInterface 
{

	public SumImplement() throws RemoteException 
	{
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public int sum(int m, int n) throws RemoteException {
		// TODO Auto-generated method stub
		return m+n;
	}

}
