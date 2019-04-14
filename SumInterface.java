import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SumInterface extends Remote
{
	int sum(int m,int n)throws RemoteException;
}
