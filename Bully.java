import java.io.*;
import java.util.Scanner;

class Bully
{
	static int n ;
	static int elect ;
	static int coordinator;
	static int process[] = new int[100] ;

	public static void main(String args[])
	{
		System.out.print( "\n Enter no of processes : " ) ;

		Scanner in = new Scanner(System.in);
        n = in.nextInt();

		for( int i = 1 ; i <= n ; i++ )
		{
			process[i] = 1 ;
		}

		System.out.print( "\n Current processes are : " ) ;

		for( int i = 1 ; i <= n ; i++ )
		{
			System.out.print( "p"+ i + "\t") ;
		}

		process[n] = -1 ;

		System.out.print( "\n\n Current coordinator is : p" + n ) ;

		System.out.print( "\n\n Which process detected the crash of coordinator : " ) ;
		elect = in.nextInt();

		System.out.print( "\n Process p"+ elect +" will start the election" ) ;

		System.out.print( "\n\n Election has started \n " ) ;		

		do
		{
			for( int i = 1  ; i <= n ; i++ )
			{	
				if( i > elect )
				{	
					System.out.print( "\n Election message is sent from "+ (elect) + " to "+ (i) ) ;

					if( process[i] == -1 )
					{
						System.out.print( "\n Communication is broken down between "+ (i) + " and "+ (elect) ) ;
					}
					else
					{
						System.out.print( "\n Ok message is sent from "+ (i) + " to "+ (elect) ) ;

						process[elect] = -1 ;
					}

					System.out.print( "\n -----------------------------------------------------------------------" ) ;					
				} 
			}	

			elect = elect + 1 ;

		}while( n != elect ) ;

		for( int i = 1 ; i <= n ; i++ )
		{
			if( process[i] == 1 )
			{
				coordinator = i ;
			}
		}

        System.out.println( " \n\n Final coordinator is : p"+ coordinator) ;

		for( int i = 1 ; i< coordinator ; i++ )
		{
			System.out.print( "\n Process p"+ coordinator + " has send coordinator message to p" + i + "\n" ) ;
		}
	}
}
